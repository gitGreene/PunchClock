package codemaestro.co.punchclock.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import codemaestro.co.punchclock.Adapters.TemplateQuestionsAdapter;
import codemaestro.co.punchclock.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryCreatorFragment extends Fragment {
    private TemplateQuestionsAdapter adapter;
    private int templateId;


    public CategoryCreatorFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_category_creator, container, false);

        templateId = getArguments().getInt("TEMPLATE_ID");
        ViewPager viewPager = view.findViewById(R.id.templateQuestionsViewPager);
        adapter = new TemplateQuestionsAdapter(getChildFragmentManager(), templateId);
        viewPager.setAdapter(adapter);
        adapter.getItem(templateId);

        return view;
    }

}
