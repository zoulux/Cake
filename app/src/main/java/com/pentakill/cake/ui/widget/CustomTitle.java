package com.pentakill.cake.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.pentakill.cake.R;

/**
 * Created by zoulux on 2016-1-31-0031.
 */
public class CustomTitle extends View {
    private static final String TAG = "CustomTitle";

    private int leftColor;
    private String rightTxt;
    private float rightTxtSize;
    private float leftColorWidth;

    private Paint colorPaint;
    private Paint txtPaint;

    private RectF bundle;

    public CustomTitle(Context context) {
        this(context, null);
    }

    public CustomTitle(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public CustomTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitle, defStyleAttr, -1);
        leftColor = a.getColor(R.styleable.CustomTitle_left_color, 0xffff4444);
        rightTxt = a.getString(R.styleable.CustomTitle_right_txt);
        rightTxtSize = a.getDimension(R.styleable.CustomTitle_right_txt_size, 18.0f);
        leftColorWidth = a.getDimension(R.styleable.CustomTitle_left_color_width, 3.0f);
        a.recycle();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init();

        drawColor(canvas);
        drawTxt(canvas);


    }

    private void init() {
        colorPaint = new Paint();
        colorPaint.setColor(leftColor);
        colorPaint.setAntiAlias(true);
        colorPaint.setDither(true);
        colorPaint.setStrokeWidth(leftColorWidth);


        txtPaint = new TextPaint();
        txtPaint.setColor(leftColor);
        txtPaint.setAntiAlias(true);
        txtPaint.setDither(true);
//        txtPaint.setStrokeWidth(rightTxtSize);
        txtPaint.setTextSize(rightTxtSize);

        bundle = new RectF();
        bundle.top = getTop();
        bundle.left = getLeft();
        bundle.right = getRight();
        bundle.bottom = getBottom();

    }

    private void drawTxt(Canvas canvas) {
        canvas.drawText(rightTxt, bundle.left, bundle.top, txtPaint);
    }

    private void drawColor(Canvas canvas) {

        Log.d(TAG, "drawColor:LEFT: "+getLeft());
        Log.d(TAG, "drawColor: TOP:"+getTop());

        canvas.drawLine(getLeft(),getTop(),getLeft()+leftColorWidth,getTop(),colorPaint);
    }
}
