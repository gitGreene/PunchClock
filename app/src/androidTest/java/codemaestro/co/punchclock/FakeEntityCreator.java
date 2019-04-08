package codemaestro.co.punchclock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.Goal;

class FakeEntityCreator {

    static final List<Category> ALL_FAKE_CATEGORIES = getFakeCategories(CategoryDaoOperationsTest.FAKE_CATEGORIES);
    static final List<Category> ALL_FAKE_FAVORITE_CATEGORIES = getFakeFavoriteCategories(CategoryDaoOperationsTest.FAKE_FAVORITES);
    static final List<Goal> ALL_FAKE_GOALS = getFakeGoals(GoalDaoOperationsTest.FAKE_GOALS);

    static List<Category> getFakeCategories(int numOfFakeCategoriesWanted) {

        List<Category> fakeCategories = new ArrayList<>();

        for(int i = 0; i < numOfFakeCategoriesWanted; i++) {
            Category fakeCategory = new Category("Fake Category " + i+1, "Fake Description " + i+1, System.currentTimeMillis(), Calendar.getInstance().getTime(), false);
            fakeCategories.add(fakeCategory);
        }

        return fakeCategories;
    }

    static List<Category> getFakeFavoriteCategories(int numOfFakeFavoriteCategoriesWanted) {
        List<Category> fakeFavorites = new ArrayList<>();

        for(int i = 0; i < numOfFakeFavoriteCategoriesWanted; i++) {
            Category fakeCategory = new Category("Fake Favorite " + i+1, "Fake Favorite Description " + i+1, System.currentTimeMillis(), Calendar.getInstance().getTime(), true);
            fakeFavorites.add(fakeCategory);
        }
        return fakeFavorites;
    }

    static List<Goal> getFakeGoals(int numOfFakeGoalsWanted) {
        List<Goal> fakeGoals = new ArrayList<>();
        for(int i = 0; i < numOfFakeGoalsWanted; i++) {
            Goal goal = new Goal(i+1, "Fake Goal " + i+1, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false, false, (long)i+1);
            fakeGoals.add(goal);
        }

        return fakeGoals;
    }



}
