package alexanderivanets.uptechtest.utils;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by alexander on 07.10.17.
 */

public class RecyclerScrollListener extends RecyclerView.OnScrollListener {
    private LoadCallback loadCallback;

    public RecyclerScrollListener(LoadCallback callback){
        loadCallback = callback;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        GridLayoutManager manager =  (GridLayoutManager) recyclerView.getLayoutManager();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        int lastVisible = manager.findLastCompletelyVisibleItemPosition();
        if (lastVisible !=RecyclerView.NO_POSITION &&
                lastVisible == adapter.getItemCount() -1){
            loadCallback.loadMore();
        }
    }

    public interface LoadCallback{
        void loadMore();
    }
}
