package lianxi.a03.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Lonely on 2017/11/2.
 */
public class CustomCircleView extends View {

    private Paint paint;
    private int cx = 200;
    private int cy = 200;

    public CustomCircleView(Context context) {
        super(context);
    }

    public CustomCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //创建画笔
        paint = new Paint();
        //定义颜色
        paint.setColor(Color.RED);
        //所绘制的虚实
        paint.setStyle(Paint.Style.FILL);
        //边框实线
        paint.setAntiAlias(true);
        //宽度
        paint.setStrokeWidth(30);

    }

    public CustomCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                System.out.println("event ACTION_DOWN = " + event.getRawX() + "  " + event.getRawY());
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("event ACTION_MOVE = " + event.getRawX() + "  " + event.getRawY());
                //获取X,Y轴的坐标
                cx = (int) event.getX();
                cy = (int) event.getY();

                //刷新
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("event ACTION_UP = " + event.getRawX() + "  " + event.getRawY());
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(cx,cy,100,paint);
    }
}
