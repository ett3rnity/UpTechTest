package alexanderivanets.uptechtest.view.activity;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import javax.inject.Inject;

import alexanderivanets.uptechtest.R;
import alexanderivanets.uptechtest.adapter.FragmentAdapter;
import alexanderivanets.uptechtest.di.app.App;
import alexanderivanets.uptechtest.model.Config;
import alexanderivanets.uptechtest.utils.NetworkStateReceiver;
import alexanderivanets.uptechtest.view.fragment.ListFragment;
import alexanderivanets.uptechtest.view.fragment.LogInView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainView extends AppCompatActivity  implements LogInView.OnLogInListener
        , NetworkStateReceiver.OnNetworkStateChanged{

    @BindView(R.id.tl_main)
    TabLayout tabLayout;

    @BindView(R.id.vp_main)
    ViewPager viewPager;

    @BindView(R.id.ib_menu)
    ImageButton menu;

    @BindView(R.id.rl_main)
    RelativeLayout mainLayout;

    @OnClick(R.id.ib_menu)
    void menuClick(){
        showPopup(menu);
    }

    private SharedPreferences sharedPreferences;
    private NetworkStateReceiver receiver;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = App.getAppComponent().sharedPreferences();
        receiver = new NetworkStateReceiver(this);
        registerReceiver(receiver,
                new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));

        ButterKnife.bind(this);

        fillViews();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
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
            menu.setVisibility(View.GONE);
        }
    }

    private void showPopup(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);

        popupMenu.inflate(R.menu.menu_main);

        popupMenu.setOnMenuItemClickListener(item -> {
           sharedPreferences.edit().clear().apply();
           adapter.notifyDataSetChanged();
            menu.setVisibility(View.GONE);
           return true;
        });

        popupMenu.show();
    }

    @Override
    public void isConnected() {

    }

    @Override
    public void disConnected() {
        Snackbar.make(mainLayout, "No Internet Connection!", Snackbar.LENGTH_LONG).show();
    }
}
