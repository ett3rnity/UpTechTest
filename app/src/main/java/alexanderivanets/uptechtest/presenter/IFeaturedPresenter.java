package alexanderivanets.uptechtest.presenter;

import java.util.ArrayList;

import alexanderivanets.uptechtest.model.VideoItem;

/**
 * Created by alexander on 06.10.17.
 */

public interface IFeaturedPresenter {
    void getVideos(int limit, int offset);
}
