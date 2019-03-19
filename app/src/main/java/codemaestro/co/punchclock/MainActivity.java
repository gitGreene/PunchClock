package codemaestro.co.punchclock;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.Goal;
import codemaestro.co.punchclock.ViewModel.CategoryViewModel;
import codemaestro.co.punchclock.ViewModel.GoalViewModel;

public class MainActivity extends AppCompatActivity {

    private CategoryViewModel categoryViewModel;
    private GoalViewModel goalViewModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);

        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        goalViewModel = ViewModelProviders.of(this).get(GoalViewModel.class);


        // Get Category by Name Data Stream
//        String name = "Gym";
//        categoryViewModel.getCategoryByName(name).observe(this, new Observer<Category>() {
//            @Override
//            public void onChanged(@Nullable Category category) {
//
//                if(category != null) {
//                    textView.setText(category.getCategoryName());
//                } else {
//                    Toast.makeText(getApplicationContext(), "FUCK YOU IDIOT", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        // Get All Categories Data Stream
//        categoryViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
//            @Override
//            public void onChanged(@Nullable List<Category> categories) {
//                if(categories !=null) {
//                    Category category = categories.get(0);
//                    String name = category.getCategoryName();
//                    textView.setText(name);
//                }
//            }
//        });


        // How to Create a Goal
//        Goal goal = new Goal("30DayChallenge", "Gym", "Start Date", "End Date", 0, 24, 0);
//        goalViewModel.insertNewGoal(goal);


        // Get Specific Goal Data Stream
        // Need to search by goalName and parentCategoryName
//        goalViewModel.getCurrentGoal("30DayChallenge", "Gym").observe(this, new Observer<Goal>() {
//            @Override
//            public void onChanged(@Nullable Goal goal) {
//                if(goal != null) {
//                    textView.setText(goal.getGoalName());
//                } else {
//                    Toast.makeText(getApplicationContext(), "There is no goal created", Toast.LENGTH_LONG).show();
//                }
//            }
//        });


    }
}
