package com.bsh.dt.plccustomize.connection;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.bsh.dt.plccustomize.constant.Constant;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by XuTe on 2018/6/29.
 */

public class SocketService extends Service {

    private static final String TAG = "SocketService";
    public static Socket socket;
    private String ip;
    private int port;
    public static boolean isConnected = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "service starts");
        ip = intent.getStringExtra(Constant.IP);
        port = intent.getIntExtra(Constant.PORT, 0);
        Log.d(TAG, "IP:" + ip + "-" + "PORT:" + port);
        new Thread(new Runnable() {
            @Override
            public void run() {
                startConnection();
            }
        }).start();
        return START_STICKY;
    }

    private void startConnection() {
        try {
            socket = new Socket(ip, port);
            Log.d(TAG, "Connect successfully");
            isConnected = true;
        } catch (IOException e) {
            e.printStackTrace();
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            isConnected = false;
        }
    }

}
