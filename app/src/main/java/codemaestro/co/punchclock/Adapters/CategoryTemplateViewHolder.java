package codemaestro.co.punchclock.Adapters;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import codemaestro.co.punchclock.R;

public class CategoryTemplateViewHolder extends RecyclerView.ViewHolder {
    private TextView categoryHeaderText, categoryDescLabel, categoryDescription;
    private Button createButton;

    public CategoryTemplateViewHolder(@NonNull View itemView) {
        super(itemView);
        categoryHeaderText = itemView.findViewById(R.id.category_template_card_header);
        categoryDescLabel = itemView.findViewById(R.id.template_description_label);
        categoryDescription = itemView.findViewById(R.id.template_description);
        createButton = itemView.findViewById(R.id.create_category_button);
    }

    public void setCategoryTemplateData(int position, Resources resources) {
        String[] categoryTitles = resources.getStringArray(R.array.category_template_names);
        String[] templateDescriptionLabels = resources.getStringArray(R.array.category_template_desc_labels);
        String[] categoryDescriptions = resources.getStringArray(R.array.category_template_descriptions);

        categoryHeaderText.setText(categoryTitles[position]);
        categoryDescLabel.setText(templateDescriptionLabels[position]);
        categoryDescription.setText(categoryDescriptions[position]);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
