package alexanderivanets.uptechtest.presenter;

import java.util.ArrayList;

import javax.inject.Inject;

import alexanderivanets.uptechtest.api.VidmeApi;
import alexanderivanets.uptechtest.model.VideoItem;
import alexanderivanets.uptechtest.model.featured.FeaturedModel;
import alexanderivanets.uptechtest.model.featured.Video;
import alexanderivanets.uptechtest.view.IFeaturedView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by alexander on 06.10.17.
 */

public class FeaturedPresenter implements IFeaturedPresenter {

    @Inject VidmeApi api;


    private IFeaturedView view;

    @Inject
    public FeaturedPresenter(IFeaturedView view){
        this.view = view;
    }

    @Override
    public void getVideos(int limit, int offset) {
        Observable<FeaturedModel> observable = api.getFeaturedResponse(limit, offset);

        observable
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .map(featuredModel -> {
                    ArrayList<VideoItem> items = new ArrayList<>();

                    for (Video video:
                         featuredModel.getVideos()) {
                        items.add(new VideoItem(
                                video.getEmbedUrl(),
                                video.getThumbnailUrl(),
                                video.getTitle(),
                                video.getLikesCount()));
                    }
                    return items;
                })
                .subscribe(videoItems -> view.showInfo(videoItems),
                        throwable -> view.showError(throwable.getLocalizedMessage()));

    }
}
