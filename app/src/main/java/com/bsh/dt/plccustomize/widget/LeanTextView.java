package com.bsh.dt.plccustomize.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.bsh.dt.plccustomize.R;

/**
 * Created by XuTe on 2018/7/6.
 */

@SuppressLint("AppCompatCustomView")
public class LeanTextView extends TextView {

    private int degree;
    private Context context;

    public LeanTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.LeanTextView, 0, 0);
        degree = typedArray.getDimensionPixelSize(R.styleable.LeanTextView_textDegree, 0);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.rotate(degree, getWidth() / 2, getHeight() / 2);
        super.onDraw(canvas);
    }
}
