package codemaestro.co.punchclock.Fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ViewFlipper;

import androidx.navigation.Navigation;

import java.util.Calendar;
import java.util.Date;

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.CreateCategoryViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateCareerCategoryFragment extends Fragment {
    private ViewFlipper viewFlipper;
    private Integer questionNumber = 0;
    private Integer defaultCategoryNumber;
    private Button continueButton;
    private CreateCategoryViewModel viewModel;
    public static final String TEMPLATE_ID = "TEMPLATE_ID";
    private String categoryName, categoryDescription;
    private Date dateCreated;
    private boolean isFavorite;
    private Category newCategory;

    public CreateCareerCategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_create_career_category, container, false);
        viewModel = ViewModelProviders.of(this).get(CreateCategoryViewModel.class);
        viewModel.setCategoryNumber(getArguments().getInt(TEMPLATE_ID));
        viewFlipper = view.findViewById(R.id.viewFlipper);
        continueButton = view.findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (viewFlipper.getDisplayedChild()) {
                    case 0:
                        View questionLayout = viewFlipper.getCurrentView();
                        EditText enterName = questionLayout.findViewById(R.id.enterName);
                        categoryName = enterName.getText().toString();
                        viewModel.setQuestionNumber(questionNumber+1);
                        break;
                    case 1:
                        questionLayout = viewFlipper.getCurrentView();
                        EditText enterDescription = questionLayout.findViewById(R.id.enterDescription);
                        categoryDescription = enterDescription.getText().toString();
                        viewModel.setQuestionNumber(questionNumber+1);
                        break;
                    default:
                        break;
                }
            }
        });

        viewModel.getQuestionNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if(integer==2) {
                    newCategory = new Category(categoryName, categoryDescription, 0L, Calendar.getInstance().getTime(), false);
                    viewModel.saveNewCategory(newCategory);
                    Bundle bundle = new Bundle();
                    bundle.putString("category_title", newCategory.getCategoryName());
                    Navigation.findNavController(view).navigate(R.id.action_categoryWizard_to_newCategoryDetailFragment, bundle);
                } else {
                    viewFlipper.setDisplayedChild(integer);
                    questionNumber = integer;
                }
            }
        });
        return view;
    }

}
