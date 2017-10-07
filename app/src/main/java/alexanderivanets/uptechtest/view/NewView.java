package alexanderivanets.uptechtest.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import javax.inject.Inject;

import alexanderivanets.uptechtest.di.app.App;
import alexanderivanets.uptechtest.model.VideoItem;
import alexanderivanets.uptechtest.presenter.FeaturedPresenter;
import alexanderivanets.uptechtest.presenter.NewPresenter;

/**
 * Created by alexander on 07.10.17.
 */

public class NewView extends BasicFragment {


    @Inject
    NewPresenter presenter;

    public static NewView newInstance() {
        
        Bundle args = new Bundle();
        
        NewView fragment = new NewView();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        callback = () -> {offset += limit;presenter.getVideos(limit, offset);};
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
        presenter.getVideos(limit, offset);
    }


}
