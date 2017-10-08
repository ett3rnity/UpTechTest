
package alexanderivanets.uptechtest.model.feed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Page {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("minDate")
    @Expose
    private Integer minDate;
    @SerializedName("minDateCompleted")
    @Expose
    private Integer minDateCompleted;
    @SerializedName("unreadCount")
    @Expose
    private Integer unreadCount;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getMinDate() {
        return minDate;
    }

    public void setMinDate(Integer minDate) {
        this.minDate = minDate;
    }

    public Integer getMinDateCompleted() {
        return minDateCompleted;
    }

    public void setMinDateCompleted(Integer minDateCompleted) {
        this.minDateCompleted = minDateCompleted;
    }

    public Integer getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
    }

}
