package alexanderivanets.uptechtest.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import alexanderivanets.uptechtest.model.Config;
import dagger.Module;
import dagger.Provides;

/**
 * Created by alexander on 05.10.17.
 */

@Module
public class AppModule {
    private  Context context;

    public AppModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    SharedPreferences providePreferance(){
        return context.getSharedPreferences(Config.PREF_NAME, 0);
    }
}
