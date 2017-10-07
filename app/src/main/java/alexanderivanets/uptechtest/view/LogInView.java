package alexanderivanets.uptechtest.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import alexanderivanets.uptechtest.R;
import alexanderivanets.uptechtest.presenter.LogInPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by alexander on 07.10.17.
 */

public class LogInView extends BasicFragment {

    @Inject
    LogInPresenter presenter;

    @BindView(R.id.btn_login)
    Button button;

    @BindView(R.id.et_login_password)
    EditText password;

    @BindView(R.id.et_login_username)
    EditText username;

    @OnClick(R.id.btn_login)
    void onLogIn(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }





}
