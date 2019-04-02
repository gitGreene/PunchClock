package codemaestro.co.punchclock;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.Model.TimeEntry;


public class HomeRecAdapter extends RecyclerView.Adapter<HomeRecAdapter.CustomViewHolder> {

    private LayoutInflater inflater;
    private List<Category> categories;
    private Context context;

    public HomeRecAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.categories = new ArrayList<>();
    }

    // Passes the list of categories we received from the Observer
    public void setCategories(final List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeRecAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.recycler_view_row_home, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecAdapter.CustomViewHolder viewHolder, int i) {
        Category categoryAtPosition = categories.get(i);
        viewHolder.categoryTitleView.setText(categoryAtPosition.getCategoryName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTitleView;

        CustomViewHolder(View itemView) {
            super(itemView);
            categoryTitleView = itemView.findViewById(R.id.textViewCategoryTitle);
        }
    }
}
