package codemaestro.co.punchclock.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import codemaestro.co.punchclock.R;

// This goes in the home fragment

public class CategoryTemplateAdapter extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    private Resources resources;
    private Context context;

    public CategoryTemplateAdapter(Context context, Resources resources) {
        this.inflater = LayoutInflater.from(context);
        this.resources = resources;
        this.context = context;
    }

    public void showDefaultCategories(){
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view1 = inflater.inflate(R.layout.card_category_template, viewGroup, false);
        return new CategoryTemplateViewHolder(view1, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        CategoryTemplateViewHolder viewHolder1 = (CategoryTemplateViewHolder) viewHolder;
        viewHolder1.setCategoryTemplateData(position, resources);
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}