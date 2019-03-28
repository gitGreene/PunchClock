package codemaestro.co.punchclock.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import codemaestro.co.punchclock.Database.Repository;
import codemaestro.co.punchclock.Model.Milestone;

public class MilestoneViewModel extends AndroidViewModel {
    private Repository repository;


    public MilestoneViewModel(@NonNull Application application, Repository repository) {
        super(application);
        this.repository = repository;
    }

    // TODO: Milestone ViewModel Methods
    public void insertMilestone(Milestone milestone) {
        repository.insertMilestone(milestone);
    }

    public void updateMilestone(Milestone milestone) {
        repository.updateMilestone(milestone);
    }

    public LiveData<List<Milestone>> getAllMilestones() {
        return repository.getAllMilestones();
    }

    public LiveData<List<Milestone>> getMilestonesByGoalId(int parentGoalId) {
        return repository.getMilestonesByGoalId(parentGoalId);
    }

    public LiveData<Milestone> getMilestoneByName(String milestoneName, int parentGoalId) {
        return repository.getMilestoneByName(milestoneName, parentGoalId);
    }

    public LiveData<List<Milestone>> getAllRecurringMilestones() {
        return repository.getAllRecurringMilestones();
    }

    public LiveData<List<Milestone>> getAGoalsRecurringMilestones(int parentGoalId) {
        return repository.getAGoalsRecurringMilestones(parentGoalId);
    }
}
