package com.example.savethefood.GlobalUse;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
/*usage
* if (AppStatus.getInstance(this).isOnline()) {

    Toast.makeText(this,"You are online!!!!",8000).show();

} else {

    Toast.makeText(this,"You are not online!!!!",8000).show();
    Log.v("Home", "############################You are not online!!!!");
}
* */

//BRON: https://stackoverflow.com/questions/4238921/detect-whether-there-is-an-internet-connection-available-on-android
public class NetworkCheck {
    private static NetworkCheck instance = new NetworkCheck();
    static Context context;
    ConnectivityManager connectivityManager;
    boolean wifiInfo, mobileInfo;
    boolean connected = false;

    public static NetworkCheck getInstance(Context ctx) {
        context = ctx.getApplicationContext();
        return instance;
    }

    public boolean isOnline() {
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            wifiInfo = networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
            networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            mobileInfo = networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();

            return wifiInfo || mobileInfo ;

        } catch (Exception e) {
            System.out.println("CheckConnectivity Exception: " + e.getMessage());
            Log.v("connectivity", e.toString());
        }
        return connected;
    }
}
