package codemaestro.co.punchclock.Fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;

import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.CreateCategoryViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateHealthCategoryFragment extends Fragment {
    private ViewFlipper viewFlipper;
    private Integer questionNumber = 0;
    private Integer defaultCategoryNumber;
    private Button continueButton;
    private CreateCategoryViewModel viewModel;
    public static final String TEMPLATE_ID = "TEMPLATE_ID";

    public CreateHealthCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_create_health_category, container, false);
        viewModel = ViewModelProviders.of(this).get(CreateCategoryViewModel.class);
        viewModel.setCategoryNumber(getArguments().getInt(TEMPLATE_ID));

        viewFlipper = view.findViewById(R.id.viewFlipper);
        continueButton = view.findViewById(R.id.continueButton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setQuestionNumber(questionNumber+1);
            }
        });

        viewModel.getQuestionNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                viewFlipper.setDisplayedChild(integer);
                questionNumber = integer;
            }
        });

        return view;
    }

}
