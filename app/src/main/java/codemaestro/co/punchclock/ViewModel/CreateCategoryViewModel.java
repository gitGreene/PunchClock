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


