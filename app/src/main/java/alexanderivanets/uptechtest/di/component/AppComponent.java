package alexanderivanets.uptechtest.di.component;

import alexanderivanets.uptechtest.view.MainView;
import alexanderivanets.uptechtest.di.module.ApiModule;
import alexanderivanets.uptechtest.di.module.AppModule;
import dagger.Component;

/**
 * Created by alexander on 06.10.17.
 */

@Component(modules = {
        AppModule.class,
        ApiModule.class
})
public interface AppComponent {
    void inject(MainView mainView);
}
