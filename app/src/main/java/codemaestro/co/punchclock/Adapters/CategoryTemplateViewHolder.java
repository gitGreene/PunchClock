package codemaestro.co.punchclock.Adapters;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.CreateCategoryViewModel;

import static android.support.constraint.Constraints.TAG;

public class CategoryTemplateViewHolder extends RecyclerView.ViewHolder {
    private TextView categoryHeaderText, categoryDescLabel, categoryDescription;
    private Button createButton;
    private Context context;
    private NavController navController;
    public static final String TAG = "TemplateViewHolder: ";
    public static final String TEMPLATE_ID = "TEMPLATE_ID";

    public CategoryTemplateViewHolder(@NonNull final View itemView, Context context) {
        super(itemView);
        categoryHeaderText = itemView.findViewById(R.id.category_template_card_header);
        categoryDescLabel = itemView.findViewById(R.id.template_description_label);
        categoryDescription = itemView.findViewById(R.id.template_description);
        createButton = itemView.findViewById(R.id.create_category_button);
        this.context = context;
    }

    public void setCategoryTemplateData(final int position, Resources resources) {
        final String[] categoryTitles = resources.getStringArray(R.array.category_template_names);
        String[] templateDescriptionLabels = resources.getStringArray(R.array.category_template_desc_labels);
        String[] categoryDescriptions = resources.getStringArray(R.array.category_template_descriptions);

        categoryHeaderText.setText(categoryTitles[position]);
        categoryDescLabel.setText(templateDescriptionLabels[position]);
        categoryDescription.setText(categoryDescriptions[position]);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt(TEMPLATE_ID, position);
                Navigation.findNavController(view).navigate(R.id.action_createCategoryFormFragment_to_categoryCreatorFragment, bundle);
                Log.e(TAG, "Create Button Clicked");
            }
        });
    }
}
