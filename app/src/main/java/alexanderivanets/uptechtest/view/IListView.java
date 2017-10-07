package alexanderivanets.uptechtest.view;

import java.util.ArrayList;

import alexanderivanets.uptechtest.model.VideoItem;

/**
 * Created by alexander on 06.10.17.
 */

public interface IListView {

    void showInfo(ArrayList<VideoItem> items);
    void showError(String e);
}
