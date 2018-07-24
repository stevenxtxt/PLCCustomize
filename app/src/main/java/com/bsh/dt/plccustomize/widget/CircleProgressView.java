package com.bsh.dt.plccustomize.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bsh.dt.plccustomize.R;

/**
 * Created by XuTe on 2018/6/1.
 */

public class CircleProgressView extends View {

    private Paint mCirclePaint;
    private Paint mRingPaint;
    private Paint mRingPaintBg;
    private int mCircleColor;
    private int mRingColor;
    private int mRingBgColor;
    private float mRadius;
    private float mRingRadius;
    private float mStrokeWidth;
    private int mXCenter;
    private int mYCenter;
    private int mTotalProgress = 100;
    private int mProgress;

    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
        initPaints();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.CircleProgressView, 0, 0);
        mRadius = typedArray.getDimension(R.styleable.CircleProgressView_radius, 80);
        mStrokeWidth = typedArray.getDimension(R.styleable.CircleProgressView_strokeWidth, 10);
        mCircleColor = typedArray.getColor(R.styleable.CircleProgressView_circleColor, 0xffffffff);
        mRingColor = typedArray.getColor(R.styleable.CircleProgressView_ringColor, 0xffffffff);
        mRingBgColor = typedArray.getColor(R.styleable.CircleProgressView_ringBgColor, 0xffffffff);

        mRingRadius = mRadius + mStrokeWidth / 2;
    }

    private void initPaints() {
        //Inner circle
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(mCircleColor);
        mCirclePaint.setStyle(Paint.Style.FILL);

        //Outer circle background
        mRingPaintBg = new Paint();
        mRingPaintBg.setAntiAlias(true);
        mRingPaintBg.setColor(mRingBgColor);
        mRingPaintBg.setStyle(Paint.Style.STROKE);
        mRingPaintBg.setStrokeWidth(mStrokeWidth);

        mRingPaint = new Paint();
        mRingPaint.setAntiAlias(true);
        mRingPaint.setColor(mRingColor);
        mRingPaint.setStyle(Paint.Style.STROKE);
        mRingPaint.setStrokeWidth(mStrokeWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mXCenter = getWidth() / 2;
        mYCenter = getHeight() / 2;

        canvas.drawCircle(mXCenter, mYCenter, mRadius, mCirclePaint);

        RectF oval1 = new RectF();
        oval1.left = mXCenter - mRingRadius;
        oval1.top = mYCenter - mRingRadius;
        oval1.right = mXCenter + mRingRadius;
        oval1.bottom = mYCenter + mRingRadius;
        canvas.drawArc(oval1, 0, 360, false, mRingPaintBg);

        if (mProgress > 0) {
            RectF oval = new RectF();
            oval.left = mXCenter - mRingRadius;
            oval.top = mYCenter - mRingRadius;
            oval.right = mXCenter + mRingRadius;
            oval.bottom = mYCenter + mRingRadius;
            canvas.drawArc(oval, -90, ((float) mProgress / mTotalProgress) * 360, false, mRingPaint);
        }
    }

    public void setProgress(int progress) {
        mProgress = progress;
        postInvalidate();
    }
}
