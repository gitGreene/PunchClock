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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import codemaestro.co.punchclock.Adapters.CategoryTemplateAdapter;
import codemaestro.co.punchclock.Adapters.CategoryTemplateViewHolder;
import codemaestro.co.punchclock.R;
import codemaestro.co.punchclock.ViewModel.CreateCategoryViewModel;

import static androidx.navigation.Navigation.findNavController;

public class CreateCategoryFormFragment extends Fragment implements CategoryTemplateViewHolder.TemplateCardListener {
    private static final String TAG = "CreateCategoryForm: ";
    private NavController navController;
    private CreateCategoryViewModel viewModel;
    public static final String TEMPLATE_ID = "TEMPLATE_ID";

    public CreateCategoryFormFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_create_category_form, container, false);
        viewModel = ViewModelProviders.of(this).get(CreateCategoryViewModel.class);

//        final NavController navController = findNavController(view);

        viewModel.getCategoryTemplate().observe(getViewLifecycleOwner(), new Observer<CreateCategoryViewModel.CategoryTemplate>() {
            @Override
            public void onChanged(@Nullable CreateCategoryViewModel.CategoryTemplate categoryTemplate) {
                switch (categoryTemplate) {
                    case HEALTH:
                        Bundle bundleHealth = new Bundle();
                        bundleHealth.putInt(TEMPLATE_ID, 1);
//                        navController.navigate(R.id.action_createCategoryFormFragment_to_categoryCreatorFragment, bundleHealth);
                        Navigation.findNavController(view).navigate(R.id.action_createCategoryFormFragment_to_categoryCreatorFragment, bundleHealth);
                        break;
                    case FAMILY:
                        Bundle bundleFamily = new Bundle();
                        bundleFamily.putInt(TEMPLATE_ID, 2);
//                        navController.navigate(R.id.action_createCategoryFormFragment_to_categoryCreatorFragment, bundleFamily);
                        Navigation.findNavController(view).navigate(R.id.action_createCategoryFormFragment_to_categoryCreatorFragment, bundleFamily);
                        break;
                    case FRIENDS:
                        Bundle bundleFriends = new Bundle();
                        bundleFriends.putInt(TEMPLATE_ID, 3);
//                        navController.navigate(R.id.action_createCategoryFormFragment_to_categoryCreatorFragment, bundleFriends);
                        Navigation.findNavController(view).navigate(R.id.action_createCategoryFormFragment_to_categoryCreatorFragment, bundleFriends);
                        break;
                    case CAREER:
                        Bundle bundleCareer = new Bundle();
                        bundleCareer.putInt(TEMPLATE_ID, 4);
//                        navController.navigate(R.id.action_createCategoryFormFragment_to_categoryCreatorFragment, bundleCareer);
                        Navigation.findNavController(view).navigate(R.id.action_createCategoryFormFragment_to_categoryCreatorFragment, bundleCareer);
                        break;
                }
            }
        });


        final RecyclerView recyclerView = view.findViewById(R.id.default_categories_recycler_view);
        final Resources resources = getResources();
        final CategoryTemplateAdapter adapter = new CategoryTemplateAdapter(getContext(), resources, this);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        recyclerView.setAdapter(adapter);
        adapter.showDefaultCategories();

        return view;
    }

    @Override
    public void onCreateButtonClicked(String categoryTitle) {
        viewModel.triggerCategoryWizard(categoryTitle);
        Log.e(TAG, "onCreateButton Listener");
    }
}
