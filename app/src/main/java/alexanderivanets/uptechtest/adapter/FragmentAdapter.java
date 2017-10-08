package alexanderivanets.uptechtest.adapter;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import alexanderivanets.uptechtest.di.app.App;
import alexanderivanets.uptechtest.model.Config;
import alexanderivanets.uptechtest.view.fragment.FeaturedView;
import alexanderivanets.uptechtest.view.fragment.FeedView;
import alexanderivanets.uptechtest.view.fragment.LogInView;
import alexanderivanets.uptechtest.view.fragment.NewView;

/**
 * Created by alexander on 07.10.17.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private SharedPreferences preferences;


    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        preferences = App.getAppComponent().sharedPreferences();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return FeaturedView.newInstance();
            case 1:
                return NewView.newInstance();
            case 2:
                if (logedIn()){
                    return FeedView.newInstance();
                }else {
                    return LogInView.newInstance();
                }
            default:
                return null;
        }
    }




    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }





    @Override
    public CharSequence getPageTitle(int position) {
        return Config.TAB_NAMES[position];
    }

    @Override
    public int getCount() {
        return Config.TAB_NAMES.length;
    }

    private boolean logedIn(){
        String logedIn = preferences.getString(Config.PREF_TOKEN, null);
        return logedIn != null;
    }
}
