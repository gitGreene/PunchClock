package codemaestro.co.punchclock.Fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.CreateCategoryViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateHealthCategoryFragment extends Fragment {

    private static int templateQuestionNumber;
    private EditText questionDescriptionEditText, questionEnterTitleEditText, questionEnterWeightEditText;
    private TextView questionEnterTitleLabel, questionEnterDescriptionLabel, questionEnterWeightLabel, questionEnterHeightLabel, questionEnterHeightFeetEditText,questionEnterHeightInchesEditText;
    private Button continueButton;
    private static int currentPosition;
    private static ContinueButtonClicked continueButtonListener;

    public interface ContinueButtonClicked {
        void continueButtonClicked();
    }

    public CreateHealthCategoryFragment() {
        // Required empty public constructor
    }

    public static CreateHealthCategoryFragment newInstance(int position, ContinueButtonClicked listener) {
        currentPosition = position;
        continueButtonListener = listener;
        return new CreateHealthCategoryFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_create_health_category, container, false);
        final CreateCategoryViewModel viewModel = ViewModelProviders.of(this).get(CreateCategoryViewModel.class);
//        templateQuestionNumber = viewModel.getQuestionNumber();

        viewModel.initializeWizard("Health");



        // TITLE
        questionEnterTitleLabel = view.findViewById(R.id.questionEnterTitleLabel);
        questionEnterTitleEditText = view.findViewById(R.id.questionEnterTitleEditText);

        // DESCRIPTION
        questionEnterDescriptionLabel = view.findViewById(R.id.questionEnterDescriptionLabel);
        questionDescriptionEditText = view.findViewById(R.id.questionDescriptionEditText);

        // HEIGHT
        questionEnterWeightLabel = view.findViewById(R.id.questionEnterWeightLabel);
        questionEnterWeightEditText = view.findViewById(R.id.questionEnterWeightEditText);

        //WEIGHT
        questionEnterHeightLabel = view.findViewById(R.id.questionEnterHeightLabel);
        questionEnterHeightFeetEditText = view.findViewById(R.id.questionEnterHeightFeetEditText);
        questionEnterHeightInchesEditText = view.findViewById(R.id.questionEnterHeightInchesEditText);

        //CONTINUE
        continueButton = view.findViewById(R.id.questionContinueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueButtonListener.continueButtonClicked();
            }
        });


        switch(currentPosition) {
            case 1:
                questionEnterTitleLabel.setVisibility(View.VISIBLE);
                questionEnterTitleLabel.setText("Enter Category Title:");
                questionEnterTitleEditText.setVisibility(View.VISIBLE);
                questionEnterTitleEditText.setHint("Health");
                continueButton.setVisibility(View.VISIBLE);
                break;
            case 2:
                questionEnterDescriptionLabel.setVisibility(View.VISIBLE);
                questionEnterDescriptionLabel.setText("Enter Category Description:");
                questionDescriptionEditText.setVisibility(View.VISIBLE);
                questionDescriptionEditText.setHint("0/240");
                continueButton.setVisibility(View.VISIBLE);
                break;
            case 3:
                questionEnterWeightLabel.setVisibility(View.VISIBLE);
                questionEnterWeightLabel.setText("Enter Weight:");
                questionEnterWeightEditText.setVisibility(View.VISIBLE);
                questionEnterWeightEditText.setHint("00");
                questionEnterHeightLabel.setVisibility(View.VISIBLE);
                questionEnterHeightLabel.setText("Enter Height:");
                questionEnterHeightFeetEditText.setVisibility(View.VISIBLE);
                questionEnterHeightFeetEditText.setHint("00");
                questionEnterHeightInchesEditText.setVisibility(View.VISIBLE);
                questionEnterHeightInchesEditText.setHint("00");
                continueButton.setVisibility(View.VISIBLE);
                continueButton.setText("Finish");
                break;
            default:
                break;
        }

        return view;
    }
}
