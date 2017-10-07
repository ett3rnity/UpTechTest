package alexanderivanets.uptechtest.presenter;

import alexanderivanets.uptechtest.view.LogInView;

/**
 * Created by alexander on 07.10.17.
 */

public interface ILogInPresenter {
    void onLogin(String username, String password);
    void setView(LogInView view);
}
