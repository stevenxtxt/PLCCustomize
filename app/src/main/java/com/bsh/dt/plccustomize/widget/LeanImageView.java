package com.bsh.dt.plccustomize.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bsh.dt.plccustomize.R;


/**
 * Created by XuTe on 2018/7/6.
 */

@SuppressLint("AppCompatCustomView")
public class LeanImageView extends ImageView {

    private int degree = 0;
    private Bitmap sourceImg;
    private Context context;

    public LeanImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.LeanImageView, 0, 0);
        degree = typedArray.getDimensionPixelSize(R.styleable.LeanImageView_imageDegree, 0);
        sourceImg = BitmapFactory.decodeResource(getResources(), typedArray.getResourceId(
                R.styleable.LeanImageView_source, 0));
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        Matrix matrix = new Matrix();
        matrix.setRotate(degree, getWidth() / 2, getHeight() / 2);
        canvas.drawBitmap(sourceImg, matrix, paint);
        super.onDraw(canvas);
    }
}
