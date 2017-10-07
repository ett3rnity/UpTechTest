package alexanderivanets.uptechtest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import alexanderivanets.uptechtest.model.Config;
import alexanderivanets.uptechtest.view.FeaturedView;
import alexanderivanets.uptechtest.view.NewView;

/**
 * Created by alexander on 07.10.17.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {


    public FragmentAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return FeaturedView.newInstance();
            case 1:
                return NewView.newInstance();
            case 2:
                return FeaturedView.newInstance();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Config.TAB_NAMES[position];
    }

    @Override
    public int getCount() {
        return Config.TAB_NAMES.length;
    }
}
