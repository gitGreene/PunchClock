package codemaestro.co.punchclock.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import codemaestro.co.punchclock.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateCareerCategoryFragment extends Fragment {
    private static int templateQuestionNumber;

    public CreateCareerCategoryFragment() {
        // Required empty public constructor
    }

    public static CreateCareerCategoryFragment newInstance(int templateId) {
        templateQuestionNumber = templateId;
        return new CreateCareerCategoryFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_career_category, container, false);
    }

}
