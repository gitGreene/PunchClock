package codemaestro.co.punchclock;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.ViewModel.CategoryViewModel;

public class MainActivity extends AppCompatActivity {

    private CategoryViewModel categoryViewModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);

        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);

        String name = "Gym";
        categoryViewModel.getCategoryByName(name).observe(this, new Observer<Category>() {
            @Override
            public void onChanged(@Nullable Category category) {

                if(category != null) {
                    textView.setText(category.getCategoryName());
                } else {
                    Toast.makeText(getApplicationContext(), "FUCK YOU IDIOT", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
