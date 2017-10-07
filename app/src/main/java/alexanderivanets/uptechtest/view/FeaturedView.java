package alexanderivanets.uptechtest.view;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import alexanderivanets.uptechtest.di.app.App;
import alexanderivanets.uptechtest.model.VideoItem;
import alexanderivanets.uptechtest.presenter.FeaturedPresenter;
import alexanderivanets.uptechtest.utils.RecyclerScrollListener;
import butterknife.BindView;
import butterknife.ButterKnife;


public class FeaturedView extends Fragment implements IListView {
    @BindView(R.id.rv_fragment)
    RecyclerView recyclerView;

    @BindView(R.id.fl_fragment)
    FrameLayout parent;

    @Inject
    Context context;

    @Inject
    FeaturedPresenter presenter;

    private VideoListAdapter adapter;
    private GridLayoutManager manager;

    private static int offset = 0;
    private static int limit = 10;


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
        App.getAppComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_featured, container, false);
        ButterKnife.bind(this, view);
        setRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
        presenter.getVideos(limit, offset);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    private void setRecyclerView(){
        adapter = new VideoListAdapter(context, null);
        manager = new GridLayoutManager(context, 1);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.addOnScrollListener(new RecyclerScrollListener(callback));
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

    private RecyclerScrollListener.LoadCallback callback = () -> {
        offset += limit;
        presenter.getVideos(limit, offset);};


}
