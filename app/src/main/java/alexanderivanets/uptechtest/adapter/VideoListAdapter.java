package alexanderivanets.uptechtest.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import alexanderivanets.uptechtest.R;
import alexanderivanets.uptechtest.model.Config;
import alexanderivanets.uptechtest.model.VideoItem;
import alexanderivanets.uptechtest.view.activity.VideoPlaybackView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alexander on 06.10.17.
 */

public class VideoListAdapter  extends RecyclerView.Adapter<VideoListAdapter.VideoListVH>{

    private Context context;
    private ArrayList<VideoItem> items;

    public VideoListAdapter(Context context, ArrayList<VideoItem> items){
        this.context = context;
        this.items = items;
    }

    public void addItems(ArrayList<VideoItem> videoItems){
        if (items != null){
        items.addAll(videoItems);
        }else {
            items = new ArrayList<>();
            items.addAll(videoItems);
        }
    }

    public void clearItems(){
        if (items!=null){
            items.clear();
            items.trimToSize();
        }else {
            items = new ArrayList<>();
        }
    }


    @Override
    public VideoListVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_video, parent, false);
        return new VideoListVH(view);
    }

    @Override
    public void onBindViewHolder(VideoListVH holder, int position) {
        VideoItem item = items.get(position);

        holder.likes.setText(String.valueOf(item.getLikes()) + "likes");
        holder.name.setText(item.getTitle());

        Picasso.with(context).load(item.getThumbUrl()).into(holder.imageView);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, VideoPlaybackView.class);
            intent.putExtra(Config.VIDEO_URL, item.getEmbUrl());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.getApplicationContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if (items != null)
        return items.size();
        else return 0;
    }



    public class VideoListVH extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_item_video)
        ImageView imageView;

        @BindView(R.id.tv_item_name)
        TextView name;

        @BindView(R.id.tv_item_likes)
        TextView likes;

        public VideoListVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }


}
