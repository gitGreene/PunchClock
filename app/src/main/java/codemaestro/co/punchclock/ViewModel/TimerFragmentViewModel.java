package codemaestro.co.punchclock.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;


public class TimerFragmentViewModel extends AndroidViewModel {
    public TimerFragmentViewModel(@NonNull Application application) {
        super(application);
    }




    private LiveData<Long> observedTime = new MutableLiveData<>();

    // Method that returns liveData Object
    public LiveData<Long> getObservedTime() {
        return observedTime;
    }

    public void setTimer(long displayTime) {
        ((MutableLiveData<Long>) observedTime).setValue(displayTime);
    }




}
