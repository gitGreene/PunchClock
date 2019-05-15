package codemaestro.co.punchclock.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import codemaestro.co.punchclock.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateHealthCategoryFragment extends Fragment {

    private static int templateQuestionNumber;
    private EditText questionEditText1, questionEditText2, getQuestionEditText3;
    private TextView questionLabelOne, questionLabelTwo;
    private Button questionButton1;
    private static ContinueButtonClicked continueButtonListener;

    public interface ContinueButtonClicked {
        void continueButtonClicked();
    }

    public CreateHealthCategoryFragment() {
        // Required empty public constructor
    }

    public static CreateHealthCategoryFragment newInstance(int templateId, ContinueButtonClicked listener) {
        templateQuestionNumber = templateId;
        continueButtonListener = listener;
        return new CreateHealthCategoryFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_create_health_category, container, false);
        questionLabelOne = view.findViewById(R.id.questionLabelOne);
        questionButton1 = view.findViewById(R.id.questionContinueButton);
        questionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueButtonListener.continueButtonClicked();
            }
        });

        switch(templateQuestionNumber) {
            case 0:
                questionLabelOne.setVisibility(View.VISIBLE);
                questionLabelOne.setText("Enter Category Name:");

                questionEditText1 = view.findViewById(R.id.questionEditTextOne);
                questionEditText1.setHint("Health");
                questionEditText1.setVisibility(View.VISIBLE);

                questionButton1 = view.findViewById(R.id.questionContinueButton);
                questionButton1.setVisibility(View.VISIBLE);
                break;
            case 1:
                questionLabelOne.setText("Enter a brief description of your new Category:");
                questionLabelOne.setVisibility(View.VISIBLE);

                questionEditText1 = view.findViewById(R.id.questionDescriptionEditText);
                questionEditText1.setHint("0/240");
                questionEditText1.setVisibility(View.VISIBLE);

                questionButton1 = view.findViewById(R.id.questionContinueButton);
                questionButton1.setVisibility(View.VISIBLE);
                break;
            case 2:
                questionLabelOne.setText("Enter Weight:");
                questionLabelOne.setVisibility(View.VISIBLE);

                questionEditText1 = view.findViewById(R.id.questionWeightEditText);
                questionEditText1.setVisibility(View.VISIBLE);

                questionLabelTwo = view.findViewById(R.id.questionLabelTwo);
                questionLabelTwo.setText("Enter Height:");

                questionEditText2 = view.findViewById(R.id.questionEnterHeightFeet);
                questionEditText2.setVisibility(View.VISIBLE);

                getQuestionEditText3 = view.findViewById(R.id.questionEnterHeightInches);
                getQuestionEditText3.setVisibility(View.VISIBLE);

                questionButton1 = view.findViewById(R.id.questionContinueButton);
                questionButton1.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }

        return view;
    }
}
