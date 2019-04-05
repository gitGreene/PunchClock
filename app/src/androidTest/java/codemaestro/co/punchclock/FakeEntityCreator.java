package codemaestro.co.punchclock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import codemaestro.co.punchclock.Model.Category;

class FakeEntityCreator {

    static final List<Category> ALL_FAKE_CATEGORIES = getFakeCategories(CategoryDaoOperationsTest.FAKE_CATEGORIES);
    static final List<Category> ALL_FAKE_FAVORITE_CATEGORIES = getFakeFavoriteCategories(CategoryDaoOperationsTest.FAKE_FAVORITES);

    static List<Category> getFakeCategories(int numOfFakeCategoriesWanted) {

        List<Category> fakeCategories = new ArrayList<>();

        for(int i = 0; i < numOfFakeCategoriesWanted; i++) {
            Category fakeCategory = new Category("Fake Category " + i, "Fake Description " + i, System.currentTimeMillis(), Calendar.getInstance().getTime(), false);
            fakeCategories.add(fakeCategory);
        }

        return fakeCategories;
    }

    static List<Category> getFakeFavoriteCategories(int numOfFakeFavoriteCategoriesWanted) {
        List<Category> fakeFavorites = new ArrayList<>();

        for(int i = 0; i < numOfFakeFavoriteCategoriesWanted; i++) {
            Category fakeCategory = new Category("Fake Favorite " + i, "Fake Favorite Description " + i, System.currentTimeMillis(), Calendar.getInstance().getTime(), true);
            fakeFavorites.add(fakeCategory);
        }
        return fakeFavorites;
    }



}
