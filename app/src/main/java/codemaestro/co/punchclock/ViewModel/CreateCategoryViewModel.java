package codemaestro.co.punchclock.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import codemaestro.co.punchclock.Database.Repository;
import codemaestro.co.punchclock.Model.Category;

public class CreateCategoryViewModel extends AndroidViewModel {
    private Repository repository;
    public static final String TAG = "CreateCategoryVM: ";
    private Integer categoryNumber;

    public CreateCategoryViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    private final MutableLiveData<Integer> questionNumber = new MutableLiveData<>();

    public MutableLiveData<Integer> getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer integer) {
        questionNumber.setValue(integer);
    }

    public Integer getCategoryNumber() {
        return categoryNumber;
    }

    public void setCategoryNumber(Integer categoryNumber) {
        this.categoryNumber = categoryNumber;
    }


    public void saveNewCategory(Category category) {
        repository.insertCategory(category);
    }

    public boolean checkIfCategoryAlreadyExists(String categoryName) {
        if (repository.getCategoryByNameTest(categoryName) != null) {
            Log.e(TAG, "checkIfCategoryAlreadyExists = True");
            return true;
        } else {
            Log.e(TAG, "checkIfCategoryAlreadyExists = False");
            return false;
        }
    }

    public int[] initializeWizard(String categoryName) {
        if (!checkIfCategoryAlreadyExists(categoryName)) {
            int[] questionNumber = new int[5];
            return questionNumber;
        }
        return null;
    }

}


