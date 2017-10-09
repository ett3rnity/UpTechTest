package alexanderivanets.uptechtest.view.activity;

import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.widget.ImageButton;

import javax.inject.Inject;

import alexanderivanets.uptechtest.R;
import alexanderivanets.uptechtest.adapter.FragmentAdapter;
import alexanderivanets.uptechtest.di.app.App;
import alexanderivanets.uptechtest.model.Config;
import alexanderivanets.uptechtest.view.fragment.ListFragment;
import alexanderivanets.uptechtest.view.fragment.LogInView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainView extends AppCompatActivity  implements LogInView.OnLogInListener{

    @BindView(R.id.tl_main)
    TabLayout tabLayout;

    @BindView(R.id.vp_main)
    ViewPager viewPager;

    @BindView(R.id.ib_menu)
    ImageButton menu;

    @OnClick(R.id.ib_menu)
    void menuClick(){
        showPopup(menu);
    }

    private SharedPreferences sharedPreferences;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = App.getAppComponent().sharedPreferences();
        ButterKnife.bind(this);

        fillViews();
    }

    @Override
    public void logedIn() {
        adapter.notifyDataSetChanged();
        menu.setVisibility(View.VISIBLE);
    }

    private void fillViews(){
        adapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(Config.TAB_NAMES.length);
        if(sharedPreferences.contains(Config.PREF_TOKEN)){
            menu.setVisibility(View.VISIBLE);
        }else {
            menu.setVisibility(View.INVISIBLE);
        }
    }

    private void showPopup(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);

        popupMenu.inflate(R.menu.menu_main);

        popupMenu.setOnMenuItemClickListener(item -> {
           sharedPreferences.edit().clear().apply();
           adapter.notifyDataSetChanged();
            menu.setVisibility(View.INVISIBLE);
           return true;
        });

        popupMenu.show();
    }

}
