
package alexanderivanets.uptechtest.model.feed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {

    @SerializedName("maxVideoId")
    @Expose
    private String maxVideoId;
    @SerializedName("maxDate")
    @Expose
    private Integer maxDate;
    @SerializedName("maxDateCompleted")
    @Expose
    private Integer maxDateCompleted;
    @SerializedName("isDefault")
    @Expose
    private Boolean isDefault;

    public String getMaxVideoId() {
        return maxVideoId;
    }

    public void setMaxVideoId(String maxVideoId) {
        this.maxVideoId = maxVideoId;
    }

    public Integer getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Integer maxDate) {
        this.maxDate = maxDate;
    }

    public Integer getMaxDateCompleted() {
        return maxDateCompleted;
    }

    public void setMaxDateCompleted(Integer maxDateCompleted) {
        this.maxDateCompleted = maxDateCompleted;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

}
