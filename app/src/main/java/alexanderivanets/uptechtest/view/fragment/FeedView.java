package alexanderivanets.uptechtest.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import alexanderivanets.uptechtest.di.app.App;
import alexanderivanets.uptechtest.presenter.FeedPresenter;

/**
 * Created by alexander on 08.10.17.
 */

public class FeedView extends ListFragment {

    @Inject
    SharedPreferences preferances;

    @Inject
    FeedPresenter presenter;

    public static FeedView newInstance() {

        Bundle args = new Bundle();

        FeedView fragment = new FeedView();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        offset = 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setListeners();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
        presenter.getVideos(limit, offset);
    }


    private void setListeners(){
        callback = () -> {offset += limit;presenter.getVideos(limit, offset);};

        refreshListener =()->{
            refreshAdapter();
            offset = 0;
            presenter.getVideos(limit, offset);};
    }
}
