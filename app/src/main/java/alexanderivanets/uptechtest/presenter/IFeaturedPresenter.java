package alexanderivanets.uptechtest.presenter;

import alexanderivanets.uptechtest.view.IListView;

/**
 * Created by alexander on 06.10.17.
 */

public interface IFeaturedPresenter {
    void setView(IListView view);
    void getVideos(int limit, int offset);
}
