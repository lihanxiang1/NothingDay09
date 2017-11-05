package lianxi.a05.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.uuzuche.lib_zxing.activity.CaptureActivity;

import lianxi.a05.MainActivity;

/**
 * Created by Lonely on 2017/11/4.
 */
public class Pro extends View {

    //定义画笔
    Paint paint;
    Paint paint2;
    boolean runing = true;
    int progress = 0;
    int jia;
    private int text;

    public Pro(Context context) {
        super(context);
    }

    public Pro(Context context, AttributeSet attrs) {
        super(context, attrs);
        //创建画笔
        paint = new Paint();
        paint2 = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint2.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);

        new Thread(new Runnable() {
            @Override
            public void run() {
                 while (runing){
                     if (progress >= 360){
                         runing = false;
                         return;
                     }
                     System.out.println("progress = "+progress);
                     progress += 10;
                     System.out.println("jia  =  "+jia);
                     //子线程刷新
                     postInvalidate();
                     //睡0.1秒
                     try {
                         Thread.sleep(300);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
            }
        }).start();
    }

    public Pro(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //getWidth（） 获取当前View 的宽度
        int x = getWidth()/2;
        int y = getHeight()/2;

        int redius = 100;
        //定义一个区域
        RectF rectF = new RectF(x-redius,y-redius,x+redius,y+redius);
        //画弧
        // useCentor  true 从中心点开始画 false 中心点不现实
//        canvas.drawCircle(200,200,150,paint2);
        canvas.drawArc(rectF,-90,progress,false,paint);
        canvas.drawArc(rectF,-90,360,false,paint2);
        text = (int) ((float)progress/360*100);
        // measureText  测量字符串的宽度
        float textWidth = paint.measureText(text +"%");
        Rect rect = new Rect();
        // rextText.height() 获取字符串的高度
        paint.getTextBounds(text +"%",0,(text +"%").length(),rect);

        paint.setTextSize(30);
        paint.setStrokeWidth(5);
        //画文字
        canvas.drawText(text +"%",x-textWidth/2,y+rect.height()/2,paint);

        MainActivity mainActivity = new MainActivity();
        mainActivity.chuan(text);
        System.out.println("text11111111111111 = "+text);
    }
    public void chuanzhi(int jia1){
        System.out.println("jia  =  "+jia+"jia1  =  "+jia1);
        jia =  jia1;
        System.out.println("2jia  =  "+jia+"2jia1  =  "+jia1);
    }
}
