package alexanderivanets.uptechtest.di.component;

import javax.inject.Singleton;

import alexanderivanets.uptechtest.view.FeaturedView;
import alexanderivanets.uptechtest.di.module.ApiModule;
import alexanderivanets.uptechtest.di.module.AppModule;
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
}
