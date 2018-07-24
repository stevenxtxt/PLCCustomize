package com.bsh.dt.plccustomize.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.Button;

import com.bsh.dt.plccustomize.R;
import com.bsh.dt.plccustomize.adapter.ScenarioAdapter;
import com.bsh.dt.plccustomize.base.BaseActivity;
import com.bsh.dt.plccustomize.constant.Constant;
import com.bsh.dt.plccustomize.model.Data;
import com.bsh.dt.plccustomize.model.MessageEvent;
import com.bsh.dt.plccustomize.model.ModelSetup;
import com.bsh.dt.plccustomize.model.Program;
import com.bsh.dt.plccustomize.model.ScenarioData;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by XuTe on 2018/7/2.
 */

public class ScenarioSelectionActivity extends BaseActivity {


    @BindView(R.id.rv_programs) RecyclerView rvPrograms;
    @BindView(R.id.btn_next) Button btnNext;

    private ScenarioAdapter mAdapter;

    private ArrayList<Data> list;

    private Data mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        setNextButton(false);
        rvPrograms.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new ScenarioAdapter(list, this);
        rvPrograms.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ScenarioAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                for (Data scenarioData : list) {
                    scenarioData.setSelected(false);
                }
                mData = list.get(position);
                mData.setSelected(true);
                mAdapter.notifyDataSetChanged();
                setNextButton(true);
            }
        });
    }

    private void initData() {
        list = ModelSetup.initDataList(ScenarioSelectionActivity.this);
    }

//    class ProgressThread implements Runnable {
//        @Override
//        public void run() {
//            while (mCurrentProgress < mTotalProgress) {
//                mCurrentProgress += 1;
//                cpvProgress.setProgress(mCurrentProgress);
//                try {
//                    Thread.sleep(50);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            if (SocketService.isConnected) {
//                if (clientSocket.sendFile()) {
//                    response = clientSocket.receiveMessage();
//                    if (response.equals("success")) {
//                        cpvProgress.setProgress(100);
//                    }
//                } else {
//
//                }
//            }
//        }
//    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_scenario_selection;
    }

    private void setNextButton(boolean isSelected) {
        btnNext.setClickable(isSelected);
        if (isSelected) {
            btnNext.setBackgroundResource(R.drawable.button_bg);
            btnNext.setTextColor(Color.parseColor("#ffffff"));
        } else {
            btnNext.setBackgroundResource(R.drawable.button_bg_30);
            btnNext.setTextColor(Color.parseColor("#4dffffff"));
        }
    }

    @OnClick(R.id.btn_next)
    public void onNextClick() {
        Intent intent = new Intent(this, TemplateScenarioActivity.class);
        intent.putExtra(Constant.DATA_EXTRA, mData);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event) {
        if (event.getCode() == 1111) {
            finish();
        }
    }
}
