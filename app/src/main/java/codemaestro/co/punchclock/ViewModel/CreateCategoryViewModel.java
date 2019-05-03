package codemaestro.co.punchclock.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import codemaestro.co.punchclock.Database.Repository;
import codemaestro.co.punchclock.Model.Category;

public class CreateCategoryViewModel extends AndroidViewModel {
    private Repository repository;

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
        if(!checkIfCategoryAlreadyExists(categoryName)) {
            switch (categoryName){
                case "Health":
                    categoryTemplate.setValue(CategoryTemplate.HEALTH);
                    break;
                case "Family":
                    categoryTemplate.setValue(CategoryTemplate.FAMILY);
                    break;
                case "Friends":
                    categoryTemplate.setValue(CategoryTemplate.FRIENDS);
                    break;
                case "Career":
                    categoryTemplate.setValue(CategoryTemplate.CAREER);
                    break;
            }
        }
    }

    public boolean checkIfCategoryAlreadyExists(String categoryName) {
        if(repository.getCategoryByNameTest(categoryName) != null) {
            return true;
        } else return false;
    }
}


