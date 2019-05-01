package codemaestro.co.punchclock.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.Utils.FormatTimeUtil;
import codemaestro.co.punchclock.ViewModel.TimerFragmentViewModel;


//TODO: Make this better - especially about the lack of persistence. Maybe you can add pause time onto the initial system tier?
public class TimerFragment extends Fragment {
    String TAG = "TimerFragment";

    Button playButton, pauseButton, stopButton;
    Button commitButton;
    long displayTime, initialTime;
    TimerFragmentViewModel timerFragmentViewModel;
    Handler handler;
    TextView timerView;
    FormatTimeUtil formatTimeUtil;
    Boolean isRunning;

    public TimerFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_timer, container, false);
        playButton = view.findViewById(R.id.playButton);
        pauseButton = view.findViewById(R.id.pauseButton);
        stopButton = view.findViewById(R.id.stopButton);
        commitButton = view.findViewById(R.id.commitButton);
        timerView = view.findViewById(R.id.timerView);
        handler = new Handler();
        formatTimeUtil = new FormatTimeUtil();
        timerFragmentViewModel = ViewModelProviders.of(this).get(TimerFragmentViewModel.class);

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();

        isRunning = sharedPref.getBoolean(getString(R.string.is_running_string_key), false);
        displayTime = sharedPref.getLong(getString(R.string.timer_string_key), 0);
        timerView.setText(formatTimeUtil.FormatMillisIntoHMS(displayTime));

        if (isRunning) {
            StartEnabledButtons();
            if (displayTime > 0) {
                initialTime = SystemClock.elapsedRealtime() - displayTime;
            } else {
                initialTime = SystemClock.elapsedRealtime();
            }
            handler.postDelayed(runTimer,  0);
        }

        timerFragmentViewModel.getObservedTime().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long time) {
                if (time != null) {
                    editor.putLong(getString(R.string.timer_string_key), time);
                    editor.apply();
                    timerView.setText(formatTimeUtil.FormatMillisIntoHMS(time));
                }
            }
        });


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putBoolean(getString(R.string.is_running_string_key), true);
                editor.apply();
                StartEnabledButtons();
                if (displayTime > 0) {
                    initialTime = SystemClock.elapsedRealtime() - displayTime;
                } else {
                    initialTime = SystemClock.elapsedRealtime();
                }
                handler.postDelayed(runTimer,  0);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putBoolean(getString(R.string.is_running_string_key), false);
                editor.apply();
                handler.removeCallbacks(runTimer);
             }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayTime = 0;
                editor.putBoolean(getString(R.string.is_running_string_key), false);
                editor.apply();
                timerFragmentViewModel.setTimer(0);
                handler.removeCallbacks(runTimer);
            }
        });
        return view;
    }

    public Runnable runTimer = new Runnable() {
        @Override
        public void run() {
            displayTime = SystemClock.elapsedRealtime() - initialTime;
            timerFragmentViewModel.setTimer(displayTime);
            handler.postDelayed(runTimer, 0);
        }
    };


    public void StartEnabledButtons() {
        // timer Started
        playButton.setEnabled(false);
        pauseButton.setEnabled(true);
        stopButton.setEnabled(true);
        commitButton.setEnabled(false);
    }

    public void PauseEnabledButtons() {
        // timer Paused
        playButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(true);
        commitButton.setEnabled(true);
    }

    public void DefaultEnabledButtons() {
        // timer Reset
        playButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
        commitButton.setEnabled(false);
    }
}
