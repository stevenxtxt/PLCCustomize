package com.bsh.dt.plccustomize.connection;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.View;

import com.bsh.dt.plccustomize.widget.CircleProgressView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by XuTe on 2018/6/4.
 */

public class ClientSocket {
    private String ip;
    private int port;
    private Socket socket;
    DataOutputStream outputStream = null;
    InputStream inputStream = null;
    private Context context;

    public static final String FILENAME = "new_data.json";

    public ClientSocket(Socket socket, Context context) {
        this.socket = socket;
        this.context = context;
    }

    public boolean createConnection() {
        boolean isSuccess = true;
        try {
            socket = new Socket(ip, port);
            Log.d("ClientSocket", "Connect successfully");
            return isSuccess;
        } catch (IOException e) {
            e.printStackTrace();
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            return false;
        }
    }

    public boolean sendFile() {
        try {
            outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = getAssetsFileStream(FILENAME);
            byte[] buf = new byte[1024];
            while (true) {
                int read = 0;
                if (dis != null) {
                    read = dis.read(buf);
                }
                if (read == -1) {
                    break;
                }
                outputStream.write(buf, 0, read);

            }
            outputStream.flush();
            socket.shutdownOutput();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    return false;
                }
            }
            return false;
        }
    }

    public boolean sendData(String data) {
        try {
            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.write(data.getBytes("UTF-8"));
            outputStream.flush();
            socket.shutdownOutput();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    return false;
                }
            }
            return false;
        }
    }

    private DataInputStream getAssetsFileStream(String filename) {
        DataInputStream dis = null;
        AssetManager assetManager = context.getAssets();
        try {
            dis = new DataInputStream(new BufferedInputStream(assetManager.open(filename)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return dis;
    }

    public String receiveMessage() {
        String response;
        try {
            inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            response = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    public void closeConnection() {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutdownOutput() throws IOException {
        socket.shutdownOutput();
    }
}
