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
public class CreateFamilyCategoryFragment extends Fragment {
    private static int templateQuestionNumber;

    public CreateFamilyCategoryFragment() {
        // Required empty public constructor
    }

    public static CreateFamilyCategoryFragment newInstance(int templateId) {
        templateQuestionNumber = templateId;
        return new CreateFamilyCategoryFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_create_family_category, container, false);

        return view;
    }

}
