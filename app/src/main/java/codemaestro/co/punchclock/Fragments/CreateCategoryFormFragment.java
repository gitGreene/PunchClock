package codemaestro.co.punchclock.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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

import androidx.navigation.NavController;

import codemaestro.co.punchclock.Adapters.CategoryTemplateAdapter;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.CreateCategoryViewModel;

public class CreateCategoryFormFragment extends Fragment {
    private NavController navController;
    private CreateCategoryViewModel viewModel;

    public CreateCategoryFormFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_create_category_form, container, false);
        viewModel = ViewModelProviders.of(this).get(CreateCategoryViewModel.class);


        viewModel.getCategoryTemplate().observe(getViewLifecycleOwner(), new Observer<CreateCategoryViewModel.CategoryTemplate>() {
            @Override
            public void onChanged(@Nullable CreateCategoryViewModel.CategoryTemplate categoryTemplate) {
                switch (categoryTemplate) {
                    case HEALTH:
                        break;
                    case FAMILY:
                        break;
                    case FRIENDS:
                        break;
                    case CAREER:
                        break;
                }
            }
        });


        final RecyclerView recyclerView = view.findViewById(R.id.default_categories_recycler_view);
        final Resources resources = getResources();
        final CategoryTemplateAdapter adapter = new CategoryTemplateAdapter(getContext(), resources);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        recyclerView.setAdapter(adapter);
        adapter.showDefaultCategories();

        return view;
    }
}
