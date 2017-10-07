package alexanderivanets.uptechtest.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import alexanderivanets.uptechtest.R;
import alexanderivanets.uptechtest.adapter.FragmentAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainView extends AppCompatActivity {

    @BindView(R.id.tl_main)
    TabLayout tabLayout;

    @BindView(R.id.vp_main)
    ViewPager viewPager;

    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        fillViews();
    }


    private void fillViews(){
        adapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
