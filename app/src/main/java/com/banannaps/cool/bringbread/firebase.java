package com.banannaps.cool.bringbread;

import java.io.DataOutputStream;
import 	java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.json.JSONObject;

import io.socket.client.Url;

import static android.content.ContentValues.TAG;

/**
 * Created by aleix on 3/3/2017.
 */

public class firebase extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // TODO: Implement this method to send any registration to your app's servers.
        sendRegistrationToServer(refreshedToken);
    }
    public void sendRegistrationToServer(String token){
        AsyncT task = new AsyncT(token);
        task.execute();
    }
}
