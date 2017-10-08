package alexanderivanets.uptechtest.view;

import alexanderivanets.uptechtest.model.UserItem;

/**
 * Created by alexander on 07.10.17.
 */

public interface ILogInView {
    void onSuccess(UserItem item);
    void onFailure(String e);
}
