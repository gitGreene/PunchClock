package codemaestro.co.punchclock.Adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import codemaestro.co.punchclock.Fragments.CreateCareerCategoryFragment;
import codemaestro.co.punchclock.Fragments.CreateFamilyCategoryFragment;
import codemaestro.co.punchclock.Fragments.CreateFriendsCategoryFragment;
import codemaestro.co.punchclock.Fragments.CreateHealthCategoryFragment;

public class TemplateQuestionsAdapter extends FragmentPagerAdapter {

    private int templateId;

    public TemplateQuestionsAdapter(FragmentManager fm, int templateId) {
        super(fm);
        this.templateId = templateId;
    }

    @Override
    public int getCount() {
        if(templateId >=0 && templateId <= 4) {
            return 5;
        } else if( templateId >= 5 && templateId <= 9) {
            return 5;
        } else if(templateId >= 11 & templateId <= 14) {
            return 5;
        } else if(templateId >= 15 && templateId <= 20) {
            return 5;
        } else return 0;
    }

    @Override
    public Fragment getItem(int templateId) {
        Fragment fragment = null;
        if(templateId >=0 && templateId <= 4) {
            return CreateHealthCategoryFragment.newInstance(templateId);
        } else if( templateId >= 5 && templateId <= 9) {
            return CreateFamilyCategoryFragment.newInstance(templateId);
        } else if(templateId >= 11 & templateId <= 14) {
            return CreateFriendsCategoryFragment.newInstance(templateId);
        } else if(templateId >= 15 && templateId <= 20) {
            return CreateCareerCategoryFragment.newInstance(templateId);
        } else return null;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return o == view;
    }
}
