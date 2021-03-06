package alexanderivanets.uptechtest.view.fragment;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import alexanderivanets.uptechtest.R;
import alexanderivanets.uptechtest.adapter.VideoListAdapter;
import alexanderivanets.uptechtest.di.app.App;
import alexanderivanets.uptechtest.model.VideoItem;
import alexanderivanets.uptechtest.utils.NetworkStateReceiver;
import alexanderivanets.uptechtest.utils.RecyclerScrollListener;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alexander on 07.10.17.
 */

public abstract class ListFragment extends Fragment  implements IListView{

    @BindView(R.id.rv_fragment)
    RecyclerView recyclerView;

    @BindView(R.id.fl_fragment)
    FrameLayout parent;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.pb_fragment)
    ProgressBar progressBar;

    @Inject
    Context context;

    private NetworkStateReceiver receiver;


    private VideoListAdapter adapter;
    private GridLayoutManager manager;
    private  NetworkStateReceiver.OnNetworkStateChanged networkListener;

    protected static int offset = 0;
    protected static int limit = 10;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film, container, false);
        ButterKnife.bind(this, view);
        setRecyclerView();
        setRefreshLayout();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar.setVisibility(View.VISIBLE);
    }




    @Override
    public void showInfo(ArrayList<VideoItem> items) {
        adapter.addItems(items);
        adapter.notifyDataSetChanged();
        if (refreshLayout.isRefreshing()) {
            refreshLayout.setRefreshing(false);
        }
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String e) {
        Snackbar.make(parent, e, Snackbar.LENGTH_LONG).show();
        progressBar.setVisibility(View.GONE);
    }




    protected RecyclerScrollListener.LoadCallback callback = () -> {
    };

    protected SwipeRefreshLayout.OnRefreshListener refreshListener = () -> {
    };

    private void setRecyclerView() {
        adapter = new VideoListAdapter(context, null);
        manager = new GridLayoutManager(context, 1);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.addOnScrollListener(new RecyclerScrollListener(callback));
    }

    private void setRefreshLayout() {
        refreshLayout.setOnRefreshListener(refreshListener);
    }

    protected void refreshAdapter() {
        adapter.clearItems();
        adapter.notifyDataSetChanged();
    }
}
