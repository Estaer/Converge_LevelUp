package utils;

import android.content.Context;
import android.net.ConnectivityManager;

public class NetworkConnectivity {

    private Context context;

    public NetworkConnectivity(Context context) {
        this.context = context;
    }

    public boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
