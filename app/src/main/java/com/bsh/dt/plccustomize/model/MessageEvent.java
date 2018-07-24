package com.bsh.dt.plccustomize.model;

import android.os.Message;

/**
 * Created by XuTe on 2018/7/8.
 */

public class MessageEvent {
    private int code;
    private String message;
    public MessageEvent(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
