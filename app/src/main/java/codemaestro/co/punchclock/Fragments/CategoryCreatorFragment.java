package codemaestro.co.punchclock.Fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import codemaestro.co.punchclock.Adapters.CategoryWizardAdapter;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.CreateCategoryViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryCreatorFragment extends Fragment {
    private int templateId;


    public CategoryCreatorFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_category_creator, container, false);
        CreateCategoryViewModel viewModel = ViewModelProviders.of(this).get(CreateCategoryViewModel.class);

        int templateId = getArguments().getInt("TEMPLATE_ID");

        ViewPager viewPager = view.findViewById(R.id.templateQuestionsViewPager);
        CategoryWizardAdapter adapter = new CategoryWizardAdapter(getChildFragmentManager(), templateId);
        viewPager.setAdapter(adapter);
        viewPager.getCurrentItem();
        return view;
    }

}
