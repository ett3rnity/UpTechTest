package alexanderivanets.uptechtest.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import alexanderivanets.uptechtest.di.app.App;
import alexanderivanets.uptechtest.presenter.FeaturedPresenter;


public class FeaturedView extends ListFragment {

    @Inject
    FeaturedPresenter presenter;


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
        offset = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setListeners();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
        presenter.getVideos(limit, offset);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentRefreshListener){
            fragmentRefreshListener = (FragmentRefreshListener) context;
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        fragmentRefreshListener = null;
    }

    private void setListeners(){
        callback = () -> {offset += limit;presenter.getVideos(limit, offset);};

        refreshListener =()->{
            refreshAdapter();
            offset = 0;
            presenter.getVideos(limit, offset);
            fragmentRefreshListener.refresh();
            refreshLayout.setRefreshing(false);};
    }


}
