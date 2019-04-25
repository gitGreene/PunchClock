package codemaestro.co.punchclock.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import codemaestro.co.punchclock.R;

public class CategoryTemplateViewHolder extends RecyclerView.ViewHolder {
    private TextView categoryHeaderText, categoryDescLabel, categoryDescription;
    private Button createButton;
    private NavController navController;
    private Context context;

    public CategoryTemplateViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        categoryHeaderText = itemView.findViewById(R.id.category_template_card_header);
        categoryDescLabel = itemView.findViewById(R.id.template_description_label);
        categoryDescription = itemView.findViewById(R.id.template_description);
        createButton = itemView.findViewById(R.id.create_category_button);
        this.context = context;
    }

    public void setCategoryTemplateData(int position, Resources resources) {
        String[] categoryTitles = resources.getStringArray(R.array.category_template_names);
        String[] templateDescriptionLabels = resources.getStringArray(R.array.category_template_desc_labels);
        String[] categoryDescriptions = resources.getStringArray(R.array.category_template_descriptions);

        navController = Navigation.findNavController((Activity)context, R.id.nav_host_fragment);

        categoryHeaderText.setText(categoryTitles[position]);
        categoryDescLabel.setText(templateDescriptionLabels[position]);
        categoryDescription.setText(categoryDescriptions[position]);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.defaultCategoriesFragment_toCategoryDetail);
            }
        });

    }
}
