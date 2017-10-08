package alexanderivanets.uptechtest.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import alexanderivanets.uptechtest.R;
import alexanderivanets.uptechtest.di.app.App;
import alexanderivanets.uptechtest.model.Config;
import alexanderivanets.uptechtest.model.UserItem;
import alexanderivanets.uptechtest.presenter.LogInPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by alexander on 07.10.17.
 */

public class LogInView extends Fragment implements ILogInView {

    private OnLogInListener logInListener;

    @Inject
    Context context;

    @Inject
    LogInPresenter presenter;

    @Inject
    SharedPreferences sharedPreferences;

    @BindView(R.id.btn_login)
    Button button;

    @BindView(R.id.et_login_password)
    EditText password;

    @BindView(R.id.et_login_username)
    EditText username;


    @OnClick(R.id.btn_login)
    void onLogIn(){
        presenter.onLogin(username.getText().toString(), password.getText().toString());
    }

    public static LogInView newInstance() {
        
        Bundle args = new Bundle();
        LogInView fragment = new LogInView();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLogInListener){
            logInListener = (OnLogInListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        logInListener = null;
    }

    @Override
    public void onSuccess(UserItem item) {
        sharedPreferences.edit()
                .putString(Config.PREF_TOKEN, item.getToken())
                .putString(Config.PREF_USERNAME, item.getName())
                .apply();
        logInListener.logedIn();

    }

    @Override
    public void onFailure(String e) {
        Toast.makeText(context, e, Toast.LENGTH_SHORT).show();
    }

    public interface OnLogInListener{
        void logedIn();
    }
}
