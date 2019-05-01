package codemaestro.co.punchclock.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
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

public class TimerFragment extends Fragment {
    String TAG = "TimerFragment";

    ToggleButton playPauseToggleButton;
    Button stopButton;
    Button commitButton;
    long displayTime, initialTime;
    TimerFragmentViewModel timerFragmentViewModel;
    Handler handler;
    TextView timerView;
    FormatTimeUtil formatTimeUtil;

    public TimerFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_timer, container, false);
        playPauseToggleButton = view.findViewById(R.id.playPauseToggleButton);
        stopButton = view.findViewById(R.id.stopButton);
        commitButton = view.findViewById(R.id.commitButton);
        timerView = view.findViewById(R.id.timerView);

        handler = new Handler();
        formatTimeUtil = new FormatTimeUtil();
        timerFragmentViewModel = ViewModelProviders.of(this).get(TimerFragmentViewModel.class);

        timerFragmentViewModel.getObservedTime().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long aLong) {
                if (aLong != null) {
                    timerView.setText(formatTimeUtil.FormatMillisIntoHMS(aLong));
                }
            }
        });


        playPauseToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isRunning) {
                if (isRunning) {
                    if (displayTime > 0) {
                        initialTime = SystemClock.elapsedRealtime() - displayTime;
                    } else {
                        initialTime = SystemClock.elapsedRealtime();
                    }
                    handler.postDelayed(runTimer,  0);
                } else {
                    handler.removeCallbacks(runTimer);
                }

            }
        });

//        stopButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                timerFragmentViewModel.setTimer(0);
//                handler.removeCallbacks(runTimer);
//            }
//        });



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
}
