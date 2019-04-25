package codemaestro.co.punchclock.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import codemaestro.co.punchclock.R;
public class CategoryDetailFragment extends Fragment {


    public CategoryDetailFragment() {
        // Required empty public constructor
    }

    public static CategoryDetailFragment newInstance() {
        return new CategoryDetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment\

        View view = inflater.inflate(R.layout.fragment_category_detail, container, false);
        TextView categoryIdText = view.findViewById(R.id.categoryId);
//        categoryIdText.setText(getArguments().getInt("CATEGORY_ID") + "");
        return view;
    }



}
