package com.example.xdf.testdrawpath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xdf on 2017/7/3.
 */

public class MyView extends View{
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //line_to(canvas);
        quadTo(canvas);
    }
    private void line_to(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(50);
        //paint.setStrokeCap(Paint.Cap.ROUND);
        Path path=new Path();
        path.moveTo(50,50);
        path.lineTo(500,500);
        canvas.drawPath(path,paint);
    }
    private void quadTo(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(50);
        Path path=new Path();
        path.moveTo(100, 500);
        path.quadTo(500, 100, 600, 500);
        canvas.drawPath(path,paint);
    }
}
