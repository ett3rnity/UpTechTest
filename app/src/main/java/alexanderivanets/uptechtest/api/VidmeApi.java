package alexanderivanets.uptechtest.api;

import alexanderivanets.uptechtest.model.featured.FeaturedModel;
import alexanderivanets.uptechtest.model.neu.NewModel;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alexander on 05.10.17.
 */

public interface VidmeApi {

    @GET("/videos/new")
    Observable<NewModel> getNewResponse(@Query("limit") int mLimit,
                                        @Query("offset") int mOffset);

    @GET("/videos/featured")
    Observable<FeaturedModel> getFeaturedResponse(@Query("limit") int mLimit,
                                                  @Query("offset") int mOffset);
}
