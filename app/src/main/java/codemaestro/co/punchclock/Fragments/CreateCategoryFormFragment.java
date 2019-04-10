package codemaestro.co.punchclock.Fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import codemaestro.co.punchclock.Adapters.CreateCategoryAdapter;
import codemaestro.co.punchclock.R;

public class CreateCategoryFormFragment extends Fragment {
    public CreateCategoryFormFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_create_category_form, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.default_categories_recycler_view);
        final Resources resources = getResources();
        final CreateCategoryAdapter adapter = new CreateCategoryAdapter(getActivity(), resources);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(adapter);
        adapter.showDefaultCategories();

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
