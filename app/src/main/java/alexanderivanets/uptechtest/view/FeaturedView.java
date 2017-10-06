package alexanderivanets.uptechtest.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alexanderivanets.uptechtest.R;


public class FeaturedView extends Fragment {

    public FeaturedView() {
        // Required empty public constructor
    }

    public static FeaturedView newInstance() {
        FeaturedView fragment = new FeaturedView();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_featured, container, false);
        return view;
    }



}