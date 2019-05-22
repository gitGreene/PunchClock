package codemaestro.co.punchclock.Fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import codemaestro.co.punchclock.Adapters.CategoryWizardAdapter;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.CreateCategoryViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryCreatorFragment extends Fragment implements CreateHealthCategoryFragment.ContinueButtonClicked {
    private int templateId;
    private CategoryWizardAdapter adapter;
    private ViewPager viewPager;
    int x;


    public CategoryCreatorFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_category_creator, container, false);
        CreateCategoryViewModel viewModel = ViewModelProviders.of(this).get(CreateCategoryViewModel.class);



        int templateId = getArguments().getInt("TEMPLATE_ID");

        viewPager = view.findViewById(R.id.templateQuestionsViewPager);
        adapter = new CategoryWizardAdapter(getChildFragmentManager(), templateId, this);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1, true);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                Toast.makeText(getContext(), "onPageScrolled", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPageSelected(int i) {
                Toast.makeText(getContext(), "onPageSelected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                Toast.makeText(getContext(), "onPageScrollStateChanged", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    @Override
    public void continueButtonClicked() {
        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
    }
}

