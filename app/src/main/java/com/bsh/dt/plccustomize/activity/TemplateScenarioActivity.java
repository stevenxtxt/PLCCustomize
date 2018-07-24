package com.bsh.dt.plccustomize.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bsh.dt.plccustomize.R;
import com.bsh.dt.plccustomize.adapter.TemplateAdapter;
import com.bsh.dt.plccustomize.base.BaseActivity;
import com.bsh.dt.plccustomize.constant.Constant;
import com.bsh.dt.plccustomize.fragment.TemplateFiveFragment;
import com.bsh.dt.plccustomize.fragment.TemplateFourFragment;
import com.bsh.dt.plccustomize.fragment.TemplateOneFragment;
import com.bsh.dt.plccustomize.fragment.TemplateSixFragment;
import com.bsh.dt.plccustomize.fragment.TemplateThreeFragment;
import com.bsh.dt.plccustomize.fragment.TemplateTwoFragment;
import com.bsh.dt.plccustomize.model.Data;
import com.bsh.dt.plccustomize.model.LayoutTemplate;
import com.bsh.dt.plccustomize.model.MessageEvent;
import com.bsh.dt.plccustomize.model.Program;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by XuTe on 2018/7/4.
 */

public class TemplateScenarioActivity extends BaseActivity {

    @BindView(R.id.tv_name) TextView tvName;
    @BindView(R.id.fl_wrapper) FrameLayout flWrapper;
    @BindView(R.id.rv_templates) RecyclerView rvTemplates;
    @BindView(R.id.tv_confirm) TextView tvConfirm;

    private Data mData;
    private ArrayList<Program> programs;
    private TemplateAdapter mAdapter;
    private ArrayList<LayoutTemplate> templates;
    private LayoutTemplate mTemplate;

    private Fragment templateOneFragment;
    private Fragment templateTwoFragment;
    private Fragment templateThreeFragment;
    private Fragment templateFourFragment;
    private Fragment templateFiveFragment;
    private Fragment templateSixFragment;
    private ArrayList<Fragment> fragmentOnes = new ArrayList<>();
    private ArrayList<Fragment> fragmentTwos = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        changeLanguage();

        mData = (Data) getIntent().getSerializableExtra(Constant.DATA_EXTRA);
        programs = mData.getPrograms();

        tvName.setText(mData.getTag());

        initTemplates();

        rvTemplates.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TemplateAdapter(this, templates);
        rvTemplates.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new TemplateAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                for (LayoutTemplate layout : templates) {
                    layout.setSelected(false);
                }
                mTemplate = templates.get(position);
                mTemplate.setSelected(true);
                mAdapter.notifyDataSetChanged();
                switchFragment(position);
                mData.setLayouttype(mTemplate.getLayouttype());
                setConfirmTv(true);
            }
        });

        initFragment();
    }

    private void changeLanguage() {
        SharedPreferences sp = getSharedPreferences("LANGUAGE", MODE_PRIVATE);
        String language = sp.getString("CURRENT_LANGUAGE", Constant.LANGUAGE_EN);
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
    }

    private void initFragment() {
//        mData.setLayouttype(Constant.TEMPLATE_5_1_ID);

        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.DATA_EXTRA, programs);
        bundle.putInt(Constant.INT_EXTRA, Constant.LARGE);

        templateOneFragment = new TemplateOneFragment();
        templateOneFragment.setArguments(bundle);

        templateTwoFragment = new TemplateTwoFragment();
        templateTwoFragment.setArguments(bundle);

        templateThreeFragment = new TemplateThreeFragment();
        templateThreeFragment.setArguments(bundle);

        templateFourFragment = new TemplateFourFragment();
        templateFourFragment.setArguments(bundle);
        fragmentOnes.add(templateOneFragment);
        fragmentOnes.add(templateTwoFragment);
        fragmentOnes.add(templateThreeFragment);
        fragmentOnes.add(templateFourFragment);

        templateFiveFragment = new TemplateFiveFragment();
        templateFiveFragment.setArguments(bundle);

        templateSixFragment = new TemplateSixFragment();
        templateSixFragment.setArguments(bundle);
        fragmentTwos.add(templateFiveFragment);
        fragmentTwos.add(templateSixFragment);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (mData.getQuantity() == 5) {
            ft.replace(R.id.fl_wrapper, templateOneFragment);
        } else if (mData.getQuantity() == 6) {
            ft.replace(R.id.fl_wrapper, templateFiveFragment);
        }
        ft.commit();
    }

    private void initTemplates() {
        templates = new ArrayList<>();
        if (mData.getQuantity() == 5) {
            LayoutTemplate template1 = new LayoutTemplate();
            template1.setLayouttype(Constant.TEMPLATE_5_1_ID);
            template1.setImgNotSelectedResource(R.mipmap.img_template5_1_n);
            template1.setImgSelectedResource(R.mipmap.img_template5_1_s);
            template1.setSelected(true);
            mData.setLayouttype(Constant.TEMPLATE_5_1_ID);

            LayoutTemplate template2 = new LayoutTemplate();
            template2.setLayouttype(Constant.TEMPLATE_5_2_ID);
            template2.setImgNotSelectedResource(R.mipmap.img_template5_2_n);
            template2.setImgSelectedResource(R.mipmap.img_template5_2_s);
            template2.setSelected(false);

            LayoutTemplate template3 = new LayoutTemplate();
            template3.setLayouttype(Constant.TEMPLATE_5_3_ID);
            template3.setImgNotSelectedResource(R.mipmap.img_template5_3_n);
            template3.setImgSelectedResource(R.mipmap.img_template5_3_s);
            template3.setSelected(false);

            LayoutTemplate template4 = new LayoutTemplate();
            template4.setLayouttype(Constant.TEMPLATE_5_4_ID);
            template4.setImgNotSelectedResource(R.mipmap.img_template5_4_n);
            template4.setImgSelectedResource(R.mipmap.img_template5_4_s);
            template4.setSelected(false);

            templates.add(template1);
            templates.add(template2);
            templates.add(template3);
            templates.add(template4);
        } else if (mData.getQuantity() == 6) {
            LayoutTemplate template1 = new LayoutTemplate();
            template1.setLayouttype(Constant.TEMPLATE_6_1_ID);
            template1.setImgNotSelectedResource(R.mipmap.img_template6_1_n);
            template1.setImgSelectedResource(R.mipmap.img_template6_1_s);
            template1.setSelected(true);
            mData.setLayouttype(Constant.TEMPLATE_6_1_ID);

            LayoutTemplate template2 = new LayoutTemplate();
            template2.setLayouttype(Constant.TEMPLATE_6_2_ID);
            template2.setImgNotSelectedResource(R.mipmap.img_template6_2_n);
            template2.setImgSelectedResource(R.mipmap.img_template6_2_s);
            template2.setSelected(false);
            templates.add(template1);
            templates.add(template2);
        }
        setConfirmTv(true);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_template_scenario;
    }

    @OnClick(R.id.tv_confirm)
    public void onConfirmClick() {
        Intent intent = new Intent(this, MyProgramLoadingActivity.class);
        intent.putExtra(Constant.DATA_EXTRA, mData);
        startActivity(intent);
    }

    private void switchFragment(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (mData.getQuantity() == 5) {
            ft.replace(R.id.fl_wrapper, fragmentOnes.get(position));
        } else if (mData.getQuantity() == 6) {
            ft.replace(R.id.fl_wrapper, fragmentTwos.get(position));
        }
        ft.commit();
    }

    private void setConfirmTv(boolean isSelected) {
        tvConfirm.setClickable(isSelected);
        if (isSelected) {
            tvConfirm.setBackgroundResource(R.drawable.button_bg);
            tvConfirm.setTextColor(Color.parseColor("#ffffff"));
        } else {
            tvConfirm.setBackgroundResource(R.drawable.button_bg_30);
            tvConfirm.setTextColor(Color.parseColor("#4dffffff"));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event) {
        if (event.getCode() == 1111) {
            finish();
        }
    }
}
