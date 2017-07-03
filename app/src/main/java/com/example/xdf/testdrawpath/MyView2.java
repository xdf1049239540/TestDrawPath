package com.example.xdf.testdrawpath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by xdf on 2017/7/3.
 */

public class MyView2 extends View{

    private int progress=0;
    private int stroke_width=35;
    public MyView2(Context context) {
        super(context);
    }

    public MyView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mMode= MeasureSpec.getMode(widthMeasureSpec);
        if(mMode==MeasureSpec.AT_MOST){
            Log.e("s","");
        }else if(mMode==MeasureSpec.EXACTLY){
            Log.e("s","");
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆环
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(stroke_width);
        float center=getWidth()/2;
        float radius=center-stroke_width*2;
        canvas.drawCircle(center,center,radius,paint);


        //画百分比

        Paint paint2=new Paint();
        paint2.setColor(Color.RED);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint2.setTextSize(60);
        paint2.setTypeface(Typeface.DEFAULT_BOLD);
        paint2.setStrokeWidth(2);
        int percent= (int) ((progress/100f)*100);
        String str_percent=percent+"%";
        float str_size=paint2.measureText(str_percent);
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        float y=center+(fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
        canvas.drawText(str_percent,(getWidth()-str_size)/2,y,paint2);

        //绘制圆弧   顺时针旋转
        Paint paint3=new Paint();
        paint3.setColor(Color.GREEN);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setAntiAlias(true);
        paint3.setStrokeWidth(stroke_width);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        RectF oval=new RectF(center-radius,center-radius,center+radius,center+radius);
        canvas.drawArc(oval,0,360*progress/100,false,paint3);

        //绘制圆弧   逆时针旋转
        Paint paint4=new Paint();
        paint4.setColor(Color.GRAY);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setAntiAlias(true);
        paint4.setStrokeWidth(stroke_width);
        paint4.setStrokeCap(Paint.Cap.ROUND);
        RectF oval2=new RectF(center-radius+stroke_width,center-radius+stroke_width,center+radius-stroke_width,center+radius-stroke_width);
        canvas.drawArc(oval2,180,360*progress/100,false,paint4);
    }
    public  void setProgress(int progress){
        this.progress=progress;
        postInvalidate();
    }

}
