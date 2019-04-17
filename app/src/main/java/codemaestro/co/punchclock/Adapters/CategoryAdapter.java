package codemaestro.co.punchclock.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.R;

public class CategoryAdapter extends RecyclerView.Adapter {

    private List<Category> userCategories;
    private Context context;
    private LayoutInflater inflater;

    public CategoryAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.userCategories = new ArrayList<>();
    }

    public void setUserCategories(final List<Category> userCategories) {
        this.userCategories = userCategories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = inflater.inflate(R.layout.user_category_card, viewGroup, false);
        return new UserCategoryCardHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        UserCategoryCardHolder viewHolder1 = (UserCategoryCardHolder) viewHolder;
        viewHolder1.setUserCategoryCard(userCategories.get(position));
    }

    @Override
    public int getItemCount() {
        if(userCategories!= null) {
            return userCategories.size();
        } else return 0;
    }
}
