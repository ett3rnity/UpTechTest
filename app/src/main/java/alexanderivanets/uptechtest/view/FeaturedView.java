package alexanderivanets.uptechtest.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alexanderivanets.uptechtest.R;
import alexanderivanets.uptechtest.adapter.VideoListAdapter;
import alexanderivanets.uptechtest.presenter.IFeaturedPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;


public class FeaturedView extends Fragment implements IFeaturedView{
    @BindView(R.id.rv_fragment)
    RecyclerView recyclerView;


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
        ButterKnife.bind(this, view);
        return view;
    }


    private void setRecyclerView(){
        VideoListAdapter adapter = new VideoListAdapter(context, items);
        GridLayoutManager manager = new GridLayoutManager(context, 1);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }




}
