package alexanderivanets.uptechtest.api;

import alexanderivanets.uptechtest.model.featured.FeaturedModel;
import alexanderivanets.uptechtest.model.feed.FeedModel;
import alexanderivanets.uptechtest.model.login.LogInModel;
import alexanderivanets.uptechtest.model.neu.NewModel;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    @GET("/videos/feed/")
    Observable<FeedModel> getFeedResponse(@Query("token") String mToken,
                                          @Query("limit") int mLimit,
                                          @Query("offset") int mOffset);

    @FormUrlEncoded
    @POST("auth/create")
    Observable<LogInModel> getLogInResponse(@Field("username") String mUsername,
                                            @Field("password") String mPassword);
}
