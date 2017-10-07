package alexanderivanets.uptechtest.presenter;

import javax.inject.Inject;

import alexanderivanets.uptechtest.view.ILogInView;
import alexanderivanets.uptechtest.view.LogInView;

/**
 * Created by alexander on 07.10.17.
 */

public class LogInPresenter implements ILogInPresenter {
   private ILogInView view;

    @Inject
    public LogInPresenter(){

    }


    @Override
    public void setView(LogInView view) {

    }

    @Override
    public void onLogin(String username, String password) {

    }
}
