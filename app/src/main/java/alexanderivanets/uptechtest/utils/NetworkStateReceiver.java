package alexanderivanets.uptechtest.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

/**
 * Created by alexander on 10.10.17.
 */

public class NetworkStateReceiver extends BroadcastReceiver {
    private OnNetworkStateChanged listener;


    public NetworkStateReceiver(OnNetworkStateChanged listener){
        this.listener = listener;
    }



    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            listener.isConnected();
        }else{
            listener.disConnected();
        }
    }

    public interface OnNetworkStateChanged{
        void isConnected();
        void disConnected();
    }


}
