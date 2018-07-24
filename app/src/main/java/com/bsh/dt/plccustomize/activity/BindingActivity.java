package com.bsh.dt.plccustomize.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bsh.dt.plccustomize.R;
import com.bsh.dt.plccustomize.base.BaseActivity;
import com.bsh.dt.plccustomize.connection.SocketService;
import com.bsh.dt.plccustomize.constant.Constant;
import com.bsh.dt.plccustomize.model.MessageEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Locale;

import butterknife.BindView;

/**
 * Created by XuTe on 2018/6/28.
 */

public class BindingActivity extends BaseActivity {
    @BindView(R.id.iv_binding) ImageView ivBinding;
    @BindView(R.id.rl_binding) RelativeLayout rlBinding;
    @BindView(R.id.iv_binding_failed) ImageView ivBindingFailed;
    @BindView(R.id.btn_back) Button btnBack;
    @BindView(R.id.btn_rescan) Button btnRescan;
    @BindView(R.id.ll_binding_failed) RelativeLayout llBindingFailed;

    private Animation rotateAnimation;
    private String ip;
    private int port;
    private String language;
    public static final String TAG = "Connecting";

    @Override
    public int getLayoutId() {
        return R.layout.activity_binding;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAnimation();
        Intent intent = getIntent();
        if (intent != null) {
            String scanResult = intent.getStringExtra(Constant.SCAN_RESULT);
            if (scanResult.contains("-")) {
                String[] result = scanResult.split("-");
                ip = result[0];
                port = Integer.parseInt(result[1]);
                language = result[2];
            }
        }
        saveLanguage(language);
        changeLanguage(language);
        Intent serviceIntent = new Intent(this, SocketService.class);
        serviceIntent.putExtra(Constant.PORT, port);
        serviceIntent.putExtra(Constant.IP, ip);
        startService(serviceIntent);
        Handler handler = new Handler();
        handler.postDelayed(new Thread(new Runnable() {
            @Override
            public void run() {
                if (SocketService.isConnected) {
                    showToast("Connected successfully");
                    Intent intent1 = new Intent(BindingActivity.this, ScenarioSelectionActivity.class);
                    startActivity(intent1);
                    BindingActivity.this.finish();
                } else {
                    rlBinding.setVisibility(View.GONE);
                    llBindingFailed.setVisibility(View.VISIBLE);
                }
            }
        }), 3000);
    }

    private void initAnimation() {
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.binding_rotate);
        ivBinding.startAnimation(rotateAnimation);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event) {
        if (event.getCode() == 1111) {
            finish();
        }
    }

    private void changeLanguage(String language) {
        Locale locale = null;
        switch (language) {
            case "en":
                locale = Locale.US;
                break;

            case "zh":
                locale = Locale.SIMPLIFIED_CHINESE;
                break;
        }
        Locale currentLocal = getResources().getConfiguration().locale;
        if (locale.equals(currentLocal)) {
            return;
        }
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        Configuration configuration = getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        getResources().updateConfiguration(configuration, metrics);
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void saveLanguage(String language) {
        SharedPreferences sp = getSharedPreferences("LANGUAGE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("CURRENT_LANGUAGE", language);
        editor.commit();
    }
}
