package codemaestro.co.punchclock.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import androidx.navigation.Navigation;
import codemaestro.co.punchclock.Model.Category;
import codemaestro.co.punchclock.R;

public class UserCategoryCardHolder extends RecyclerView.ViewHolder {

   // private Context context;
    //private Category userCategory;
    private TextView categoryName;
    public static final String CATEGORY_ID = "CATEGORY_ID";

    UserCategoryCardHolder(@NonNull View itemView, Context context) {
        super(itemView);
        //this.context = context;
        this.categoryName = itemView.findViewById(R.id.category_card_title);
    }

    void setUserCategoryCard(final Category userCategory) {
        //this.userCategory = userCategory;
        categoryName.setText(userCategory.getCategoryName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Category Title", userCategory.getCategoryName());
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_categoryDetailFragment, bundle);
            }
        });
    }
}
