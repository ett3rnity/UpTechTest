package alexanderivanets.uptechtest.di.component;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import alexanderivanets.uptechtest.view.FeaturedView;
import alexanderivanets.uptechtest.di.module.ApiModule;
import alexanderivanets.uptechtest.di.module.AppModule;
import alexanderivanets.uptechtest.view.FeedView;
import alexanderivanets.uptechtest.view.LogInView;
import alexanderivanets.uptechtest.view.NewView;
import dagger.Component;

/**
 * Created by alexander on 06.10.17.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        ApiModule.class,
})
public interface AppComponent {
    void inject(FeaturedView featuredView);
    void inject(NewView newView);
    void inject(LogInView logInView);
    void inject(FeedView feedView);
    SharedPreferences sharedPreferences();
}
