package codemaestro.co.punchclock.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import codemaestro.co.punchclock.Database.Repository;
import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.TimeEntry;

public class CategoryViewModel extends AndroidViewModel {
    private Repository repository;

    // Lists of LiveData
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Category>> allFavoriteCategories;

    private LiveData<List<TimeEntry>> allMilestoneTimeEntries;

    // Individual LiveData holders
    private LiveData<Category> currentCategory;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allCategories = repository.getAllCategories();
    }

    public LiveData<List<Category>> getAllCategories() {
        return allCategories;
    }

    public LiveData<Category> getCategoryByName(String name) {
        currentCategory = repository.getCategoryByName(name);
        return currentCategory;
    }

    public void insertNewCategory(Category category) {
        repository.insertCategory(category);
    }

    public void updateExistingCategory(Category category) {
        repository.updateCategory(category);
    }


//    public LiveData<List<TimeEntry>> getAllCategoryEntries(String parentCategoryName) {
//        allCategoryEntries = repository.getAllCategoryEntries(parentCategoryName);
//        return allCategoryEntries;
//    }

//    public LiveData<List<TimeEntry>> getEntriesByCategoryId(int parentCategoryId) {
//        allCategoryEntries = repository.getEntriesByCategoryId(parentCategoryId);
//        return allCategoryEntries;
//    }
//
//    public void insertNewTimeEntry(TimeEntry timeEntry) {
//        repository.insertNewTimeEntry(timeEntry);
//    }






}
