package com.bsh.dt.plccustomize.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bsh.dt.plccustomize.R;

/**
 * Created by XuTe on 2018/6/28.
 */

public class HeaderLayout extends LinearLayout {

    private ImageView ivBack;
    private TextView tvTitle;
    private Context context;
    private String title;
    private boolean isBackShow = false;

    public HeaderLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initAttrs(context, attrs);
        init();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.HeaderLayout, 0, 0);
        title = typedArray.getString(R.styleable.HeaderLayout_title);
        isBackShow = typedArray.getBoolean(R.styleable.HeaderLayout_isBackShow, true);
    }

    private void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.title_layout, this);
        ivBack = view.findViewById(R.id.iv_back);
        tvTitle = view.findViewById(R.id.tv_title);
        if (isBackShow) {
            ivBack.setVisibility(View.VISIBLE);
        } else {
            ivBack.setVisibility(View.INVISIBLE);
        }
        tvTitle.setText(title);
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    activity.finish();
                }
            }
        });
    }
}
