package alexanderivanets.uptechtest.di.app;

import android.app.Application;

import alexanderivanets.uptechtest.di.component.AppComponent;
import alexanderivanets.uptechtest.di.component.DaggerAppComponent;
import alexanderivanets.uptechtest.di.module.ApiModule;
import alexanderivanets.uptechtest.di.module.AppModule;

/**
 * Created by alexander on 06.10.17.
 */

public class App extends Application{
    private static AppComponent appComponent;

    public static AppComponent getAppComponent(){
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildAppComponent();
    }

    private AppComponent buildAppComponent(){
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .build();
    }
}
