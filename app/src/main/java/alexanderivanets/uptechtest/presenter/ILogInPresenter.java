package alexanderivanets.uptechtest.presenter;

import alexanderivanets.uptechtest.view.fragment.ILogInView;

/**
 * Created by alexander on 07.10.17.
 */

public interface ILogInPresenter {
    void onLogin(String username, String password);
    void setView(ILogInView view);
}
