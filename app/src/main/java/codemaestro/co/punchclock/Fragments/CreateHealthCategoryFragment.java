package codemaestro.co.punchclock.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import codemaestro.co.punchclock.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateHealthCategoryFragment extends Fragment {

    private static int templateQuestionNumber;

    public CreateHealthCategoryFragment() {
        // Required empty public constructor
    }

    public static CreateHealthCategoryFragment newInstance(int templateId) {
        templateQuestionNumber = templateId;
        return  new CreateHealthCategoryFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_create_health_category, container, false);
        TextView textView =  view.findViewById(R.id.textView);
        textView.setText("Fuck you");

        return view;
    }

}
