package alexanderivanets.uptechtest.presenter;

import java.util.ArrayList;

import javax.inject.Inject;

import alexanderivanets.uptechtest.api.VidmeApi;
import alexanderivanets.uptechtest.model.VideoItem;
import alexanderivanets.uptechtest.model.neu.NewModel;
import alexanderivanets.uptechtest.model.neu.Video;
import alexanderivanets.uptechtest.view.IListView;
import alexanderivanets.uptechtest.view.NewView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by alexander on 07.10.17.
 */

public class NewPresenter implements IFeaturedPresenter {
    private NewView view;

    @Inject
    VidmeApi api;

    @Inject
    public NewPresenter(){}


    @Override
    public void setView(IListView view) {
        this.view = (NewView) view;
    }

    @Override
    public void getVideos(int limit, int offset) {
        Observable<NewModel> observable = api.getNewResponse(limit,offset);

        observable
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .map(newModel -> {
                    ArrayList<VideoItem> items = new ArrayList<>();

                    for (Video video:
                            newModel.getVideos()) {
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
