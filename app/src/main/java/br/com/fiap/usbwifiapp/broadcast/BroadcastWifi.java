package br.com.fiap.usbwifiapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import br.com.fiap.usbwifiapp.StatusWifiActivity;

public class BroadcastWifi extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        //NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean conectado = false;
        conectado = wifi != null && wifi.isConnectedOrConnecting();

        String param;

        if (conectado){
            param ="Wi-Fi Ativo" ;
        }else {
            param = "Wi-Fi Inativo";
        }

        Intent i = new Intent(context, StatusWifiActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("conexao",param);
        context.startActivity(i);

    }
}
