package alexanderivanets.uptechtest.presenter;

import javax.inject.Inject;

import alexanderivanets.uptechtest.api.VidmeApi;
import alexanderivanets.uptechtest.model.UserItem;
import alexanderivanets.uptechtest.model.login.LogInModel;
import alexanderivanets.uptechtest.view.fragment.ILogInView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by alexander on 07.10.17.
 */

public class LogInPresenter implements ILogInPresenter {
   private ILogInView view;

    @Inject VidmeApi api;

    @Inject
    public LogInPresenter(){
    }


    @Override
    public void setView(ILogInView view){
        this.view = view;
    }

    @Override
    public void onLogin(String username, String password) {
        Observable<LogInModel> observable = api.getLogInResponse(username, password);

        observable
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .map(logInModel -> new UserItem(logInModel.getUser().getUsername(),
                        logInModel.getAuth().getToken(),
                        logInModel.getUser().getUserId()  ))
                .subscribe(userItem -> view.onSuccess(userItem),
                        throwable -> view.onFailure(throwable.getLocalizedMessage()));
    }
}
