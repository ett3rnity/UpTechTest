package alexanderivanets.uptechtest.model;

/**
 * Created by alexander on 06.10.17.
 */

public class VideoItem {
    private final String embUrl;
    private final String thumbUrl;
    private final String title;
    private final int likes;

    public VideoItem(String embUrl, String thumbUrl, String title, int likes){
        this.embUrl = embUrl;
        this.likes = likes;
        this.thumbUrl = thumbUrl;
        this.title = title;
    }

    public String getEmbUrl() {
        return embUrl;
    }

    public int getLikes() {
        return likes;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String getTitle() {
        return title;
    }

}
