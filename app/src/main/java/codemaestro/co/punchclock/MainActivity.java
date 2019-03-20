package codemaestro.co.punchclock;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.Model.TimeEntry;
import codemaestro.co.punchclock.ViewModel.CategoryViewModel;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;

public class MainActivity extends AppCompatActivity {

    private CategoryViewModel categoryViewModel;
    private GoalViewModel goalViewModel;
    private TextView textView;
    private RecViewAdapter adapter;
    private RecyclerView recView;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        addButton = findViewById(R.id.addButton);

        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        goalViewModel = ViewModelProviders.of(this).get(GoalViewModel.class);

        recView = findViewById(R.id.recyclerViewTimer);
        recView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecViewAdapter(this);
        recView.setAdapter(adapter);

        categoryViewModel.getEntriesByCategoryId(1).observe(this, new Observer<List<TimeEntry>>() {
            @Override
            public void onChanged(@Nullable List<TimeEntry> timeEntries) {
                if(timeEntries != null) {
                    adapter.setTimeEntries(timeEntries);
                    Toast.makeText(MainActivity.this, "This happened", Toast.LENGTH_SHORT).show();
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1 is Gym's ID
                TimeEntry newEntry = new TimeEntry(1, 0, "00:00:00", "23:59:59", "06/26/91");
                categoryViewModel.insertNewTimeEntry(newEntry);
            }
        });



        // Get Category by Name Data Stream
//        String name = "Gym";
//        categoryViewModel.getCategoryByName(name).observe(this, new Observer<Category>() {
//            @Override
//            public void onChanged(@Nullable Category category) {
//                if(category != null) {
//                    textView.setText(category.getCategoryName());
//                } else {
//                    Toast.makeText(getApplicationContext(), "There is no category created", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        // Get All Categories Data Stream
//        categoryViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
//            @Override
//            public void onChanged(@Nullable List<Category> categories) {
//                if(categories != null) {
//                    Category category = categories.get(0);
//                    String name = category.getCategoryName();
//                    textView.setText(name);
//                } else {
//                    Toast.makeText(getApplicationContext(), "There is no category created", Toast.LENGTH_LONG).show();
//                }
//            }
//        });


        // How to create a goal
//        Goal goal = new Goal(1, "30DayChallenge", "Start Date", "End Date", 0, 24, 0);
//        goalViewModel.insertNewGoal(goal);

        // Get Specific Goal Data Stream
        // Need to search by goalName and parentCategoryName
//        goalViewModel.getCurrentGoal("30DayChallenge", 1).observe(this, new Observer<Goal>() {
//            @Override
//            public void onChanged(@Nullable Goal goal) {
//                Goal usableGoal = null;
//                if(goal != null) {
//                    usableGoal = goal;
//                    textView.setText(usableGoal.getGoalName());
//                } else {
//                    Toast.makeText(getApplicationContext(), "There is no goal created", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        // Get All Goals of a specific Category
//        goalViewModel.getGoalsByCategoryId(1).observe(this, new Observer<List<Goal>>() {
//            @Override
//            public void onChanged(@Nullable List<Goal> goals) {
//                Goal goal = null;
//                if(goals != null) {
//                    goal = goals.get(0);
//                    textView.setText(goal.getGoalName());
//                }
//            }
//        });




        //TODO: Fix fetching the Time Entries for specific Categories

//        How to create a Time Entry
//        TimeEntry timeEntry = new TimeEntry(1, 0, "Start Date", "End Date", "Date of Entry");
//        categoryViewModel.insertNewTimeEntry(timeEntry);
//
//         How to get all Time Entries by Category ID
//        categoryViewModel.getEntriesByCategoryId(1).observe(this, new Observer<List<TimeEntry>>() {
//            @Override
//            public void onChanged(@Nullable List<TimeEntry> timeEntries) {
//                TimeEntry usableTimeEntry = null;
//                if(timeEntries != null) {
//                    usableTimeEntry = timeEntries.get(0);
//                    textView.setText(usableTimeEntry.getDateOfEntry());
//                }
//            }
//        });


    }
}
