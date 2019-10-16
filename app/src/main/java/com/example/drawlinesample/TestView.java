package com.example.drawlinesample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TestView extends View {
    public Canvas canvas;
    public Paint pen; //画笔
    public Paint erase; //橡皮
    private Bitmap bitmap;
    float x,y;
    int bgColor;
    int mode; //画画模式，0为画图，1为擦除

    public TestView(Context context)
    {
        super(context);
        initPaint();
    }

    public TestView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        initPaint();
    }

    public TestView(Context context,AttributeSet attris,int defStyleAttrs)
    {
        super(context,attris,defStyleAttrs);
        initPaint();
    }

    public void initPaint(){
        mode = 0; //设置模式为画图
        bgColor = Color.WHITE;
        bitmap = Bitmap.createBitmap(1800,2000,Bitmap.Config.ARGB_8888);
        canvas = new Canvas();
        canvas.setBitmap(bitmap);
        canvas.drawColor(Color.WHITE);
        //设置笔的属性
        pen = new Paint(Paint.DITHER_FLAG);
        pen.setAntiAlias(true);
        pen.setColor(Color.RED);
        pen.setStrokeCap(Paint.Cap.ROUND);
        pen.setStrokeWidth(8);
        //设置橡皮属性
        erase = new Paint(Paint.DITHER_FLAG);
        erase.setAntiAlias(true);
        erase.setColor(Color.WHITE);
        erase.setStrokeCap(Paint.Cap.ROUND);
        erase.setStrokeWidth(16);
    }

    //设置当前模式（绘画或是擦除）
    public void setMode(int mode)
    {
        this.mode = mode;
    }

    //获取当前的Paint为笔或者是橡皮
    private Paint getPen(){
        if(mode == 0)
            return pen;
        else
            return erase;
    }

    //清空画布
    public void clearPaint()
    {
        bitmap = Bitmap.createBitmap(1800,2000,Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        canvas.drawColor(Color.WHITE);
        invalidate();
    }
    //设置笔的颜色
    public void setPenColor(int color)
    {
        pen.setColor(color);
    }

    //设置笔的粗细
    public void setPenWidth(float w)
    {
        pen.setStrokeWidth(w);
    }

    //设置橡皮大小
    public void setEraseWidth(float w)
    {
        erase.setStrokeWidth(w);
    }
    //触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_MOVE) {    //拖动屏幕
            canvas.drawLine(x, y, event.getX(), event.getY(), getPen());   //画线，x，y是上次的坐标，event.getX(), event.getY()是当前坐标
            invalidate();
        }

        if (event.getAction() == MotionEvent.ACTION_DOWN) {    //按下屏幕
            x = event.getX();
            y = event.getY();
            canvas.drawPoint(x, y, getPen());                //画点
            invalidate();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {    //松开屏幕

        }
        x = event.getX();   //记录坐标
        y = event.getY();
        return true;
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawBitmap(bitmap, 0, 0, null);
    }
}

