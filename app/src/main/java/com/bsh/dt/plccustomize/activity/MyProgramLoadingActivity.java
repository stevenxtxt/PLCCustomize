package com.bsh.dt.plccustomize.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bsh.dt.plccustomize.R;
import com.bsh.dt.plccustomize.base.BaseActivity;
import com.bsh.dt.plccustomize.connection.ClientSocket;
import com.bsh.dt.plccustomize.connection.SocketService;
import com.bsh.dt.plccustomize.constant.Constant;
import com.bsh.dt.plccustomize.fragment.TemplateFiveFragment;
import com.bsh.dt.plccustomize.fragment.TemplateFourFragment;
import com.bsh.dt.plccustomize.fragment.TemplateOneFragment;
import com.bsh.dt.plccustomize.fragment.TemplateSixFragment;
import com.bsh.dt.plccustomize.fragment.TemplateThreeFragment;
import com.bsh.dt.plccustomize.fragment.TemplateTwoFragment;
import com.bsh.dt.plccustomize.model.Data;
import com.bsh.dt.plccustomize.model.EntityData;
import com.bsh.dt.plccustomize.model.MessageEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by XuTe on 2018/7/7.
 */

public class MyProgramLoadingActivity extends BaseActivity {
    @BindView(R.id.btn_reset) Button btnReset;
    @BindView(R.id.iv_loading) ImageView ivLoading;
    @BindView(R.id.ll_loading) LinearLayout llLoading;
    @BindView(R.id.fl_wrapper) FrameLayout flWrapper;

    private Data mData;
    private Animation rotateAnimation;
    private EntityData mEntityData;
    private String dataJson;
    private ClientSocket clientSocket;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Constant.SEND_SUCCESS:
                    btnReset.setClickable(true);
                    showProgramLayout();
                    break;

                case Constant.SEND_FAILURE:
                    showToast("Send failure!");
                    btnReset.setClickable(true);
                    llLoading.setVisibility(View.GONE);
                    break;
            }
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_program_loading;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = (Data) getIntent().getSerializableExtra(Constant.DATA_EXTRA);
        initEntityData();
        initAnimation();
        btnReset.setClickable(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    sendData(dataJson);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void initEntityData() {
        mEntityData = new EntityData();
        mEntityData.setVersion(1010);
        mEntityData.setStatus(200);
        mEntityData.setData(mData);
        mEntityData.setDatetime("20180517T152830");
        mEntityData.setMessage("success");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        dataJson = gson.toJson(mEntityData);
        Log.d("MyProgramLoading", dataJson);
    }

    private void sendData(String dataJson) {
        clientSocket = new ClientSocket(SocketService.socket, this);
        if (SocketService.isConnected) {
            if (clientSocket.sendData(dataJson)) {
                String response = clientSocket.receiveMessage();
                if (response.equals("success")) {
                    handler.sendEmptyMessage(Constant.SEND_SUCCESS);
                } else {
                    handler.sendEmptyMessage(Constant.SEND_FAILURE);
                }
            } else {
                handler.sendEmptyMessage(Constant.SEND_FAILURE);
            }
        }
    }

    private void initAnimation() {
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.binding_rotate);
        ivLoading.startAnimation(rotateAnimation);
    }

    private void showProgramLayout() {
        llLoading.setVisibility(View.GONE);

        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.DATA_EXTRA, mData.getPrograms());
        bundle.putInt(Constant.INT_EXTRA, Constant.SMALL);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;
        switch (mData.getLayouttype()) {
            case Constant.TEMPLATE_5_1_ID:
                fragment = new TemplateOneFragment();
                break;
            case Constant.TEMPLATE_5_2_ID:
                fragment = new TemplateTwoFragment();
                break;
            case Constant.TEMPLATE_5_3_ID:
                fragment = new TemplateThreeFragment();
                break;
            case Constant.TEMPLATE_5_4_ID:
                fragment = new TemplateFourFragment();
                break;
            case Constant.TEMPLATE_6_1_ID:
                fragment = new TemplateFiveFragment();
                break;
            case Constant.TEMPLATE_6_2_ID:
                fragment = new TemplateSixFragment();
                break;
        }
        fragment.setArguments(bundle);
        ft.replace(R.id.fl_wrapper, fragment);
        ft.commit();
    }

    @OnClick(R.id.btn_reset)
    public void onResetClick() {
        EventBus.getDefault().post(new MessageEvent(1111, ""));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        onResetClick();
    }
}
