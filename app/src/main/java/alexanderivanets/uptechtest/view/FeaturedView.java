package alexanderivanets.uptechtest.view;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


import java.util.ArrayList;

import javax.inject.Inject;

import alexanderivanets.uptechtest.R;
import alexanderivanets.uptechtest.adapter.VideoListAdapter;
import alexanderivanets.uptechtest.model.VideoItem;
import alexanderivanets.uptechtest.presenter.IFeaturedPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;


public class FeaturedView extends Fragment implements IFeaturedView{
    @BindView(R.id.rv_fragment)
    RecyclerView recyclerView;

    @BindView(R.id.fl_fragment)
    FrameLayout parent;

    @Inject
    Context context;

    private VideoListAdapter adapter;
    private GridLayoutManager manager;


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
        setRecyclerView();
        return view;
    }


    private void setRecyclerView(){
        adapter = new VideoListAdapter(context, null);
        manager = new GridLayoutManager(context, 1);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }


    @Override
    public void showInfo(ArrayList<VideoItem> items) {
        adapter.addItems(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String e) {
        Snackbar.make(parent, e, Snackbar.LENGTH_SHORT);
    }


}
