package codemaestro.co.punchclock.Adapters;

import android.support.v4.app.FragmentPagerAdapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import codemaestro.co.punchclock.Fragments.CreateCareerCategoryFragment;
import codemaestro.co.punchclock.Fragments.CreateFamilyCategoryFragment;
import codemaestro.co.punchclock.Fragments.CreateFriendsCategoryFragment;
import codemaestro.co.punchclock.Fragments.CreateHealthCategoryFragment;


public class CategoryWizardAdapter extends FragmentPagerAdapter {
    private static int NUM_OF_FRAMES = 20;
    private int templateId;

    public CategoryWizardAdapter(FragmentManager fragmentManager, int templateId) {
        super(fragmentManager);
        this.templateId = templateId;
    }



    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (templateId) {
            case 0:
                fragment = CreateHealthCategoryFragment.newInstance(position);
                break;
            case 1:
                fragment = CreateFamilyCategoryFragment.newInstance(position);
                break;
            case 2:
                fragment = CreateFriendsCategoryFragment.newInstance(position);
                break;
            case 3:
                fragment = CreateCareerCategoryFragment.newInstance(position);
                break;
            default:
                return null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        switch (templateId) {
            case 0:
                return 5;
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 2;
            default:
                return 1;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}
