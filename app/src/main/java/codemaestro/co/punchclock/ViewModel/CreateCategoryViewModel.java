package codemaestro.co.punchclock.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import codemaestro.co.punchclock.Database.Repository;

public class CreateCategoryViewModel extends AndroidViewModel {
    private Repository repository;
    public static final String TAG = "CreateCategoryVM: ";

    public enum CategoryTemplate {
        HEALTH,
        FAMILY,
        FRIENDS,
        CAREER
    }

    final MutableLiveData<CategoryTemplate> categoryTemplate = new MutableLiveData<>();



    public MutableLiveData<CategoryTemplate> getCategoryTemplate() {
        return categoryTemplate;
    }



    public CreateCategoryViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public void triggerCategoryWizard(String categoryName) {
        Log.e(TAG, "Trigger Category Wizard");
        if(!checkIfCategoryAlreadyExists(categoryName)) {
            switch (categoryName){
                case "Health":
                    categoryTemplate.setValue(CategoryTemplate.HEALTH);
                    Log.e(TAG, "Case Health");
                    break;
                case "Family":
                    categoryTemplate.setValue(CategoryTemplate.FAMILY);
                    Log.e(TAG, "Case Family");
                    break;
                case "Friends":
                    categoryTemplate.setValue(CategoryTemplate.FRIENDS);
                    Log.e(TAG, "Case Friends");
                    break;
                case "Career":
                    categoryTemplate.setValue(CategoryTemplate.CAREER);
                    Log.e(TAG, "Case Career");
                    break;
                default:
                    Log.e(TAG, "Switch Default");
                    break;
            }
        } else {
            Toast.makeText(getApplication(), "Already Exists!", Toast.LENGTH_LONG).show();
            Log.e(TAG, "Category Already Exists");
        }
    }

    public boolean checkIfCategoryAlreadyExists(String categoryName) {
        if(repository.getCategoryByNameTest(categoryName) != null) {
            Log.e(TAG, "checkIfCategoryAlreadyExists = True");
            return true;
        } else {
            Log.e(TAG, "checkIfCategoryAlreadyExists = False");
            return false;
        }

    }
}


