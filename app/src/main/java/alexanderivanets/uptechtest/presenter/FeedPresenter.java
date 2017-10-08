package alexanderivanets.uptechtest.presenter;

import android.content.SharedPreferences;

import java.util.ArrayList;

import javax.inject.Inject;

import alexanderivanets.uptechtest.api.VidmeApi;
import alexanderivanets.uptechtest.di.app.App;
import alexanderivanets.uptechtest.model.Config;
import alexanderivanets.uptechtest.model.VideoItem;
import alexanderivanets.uptechtest.model.feed.FeedModel;
import alexanderivanets.uptechtest.model.feed.Video;
import alexanderivanets.uptechtest.view.FeedView;
import alexanderivanets.uptechtest.view.IListView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by alexander on 08.10.17.
 */

public class FeedPresenter implements IFeaturedPresenter {

    private FeedView view;
    private static String token;
    private SharedPreferences preferences;

    @Inject
    VidmeApi api;

    @Inject
    FeedPresenter(){
        preferences = App.getAppComponent().sharedPreferences();
        token = preferences.getString(Config.PREF_TOKEN, "");
    }


    @Override
    public void setView(IListView view) {
        this.view = (FeedView) view;
    }

    @Override
    public void getVideos(int limit, int offset) {
        Observable<FeedModel> observable = api.getFeedResponse(token, limit, offset);
        observable
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .map(feedModel -> {
                    ArrayList<VideoItem> items = new ArrayList<>();
                    for (Video video:
                         feedModel.getVideos()) {
                        items.add(new VideoItem(
                                video.getEmbedUrl(),
                                video.getThumbnailUrl(),
                                video.getTitle(),
                                video.getLikesCount() ));
                    }
                    return items;
                })
                .subscribe(items -> view.showInfo(items),
                        throwable -> view.showError(throwable.getLocalizedMessage()));
    }
}
