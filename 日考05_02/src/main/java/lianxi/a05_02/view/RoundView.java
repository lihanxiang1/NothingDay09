package lianxi.a05_02.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.math.BigDecimal;

import lianxi.a05_02.R;

/**
 * Created by Lonely on 2017/11/4.
 */
public class RoundView extends View {
    //定义画笔
    private Paint paint;
    //圆环的颜色
    private int color;
    //圆环进度的颜色
    private int backColor;
    //中间进度百分比的字符串的颜色
    private int textColor;
    //中间进度百分比的字符串的字体
    private float textSize;
    //圆环的宽度
    private float roundWidth;
    //当前进度
    private int progress = 0;
    Context context;

    public RoundView(Context context) {
        super(context);
    }

    public RoundView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundView);

        color = typedArray.getColor(R.styleable.RoundView_color, Color.RED);
        backColor = typedArray.getColor(R.styleable.RoundView_backColor, Color.GREEN);
        textColor = typedArray.getColor(R.styleable.RoundView_textColor, Color.GREEN);
        textSize = typedArray.getDimension(R.styleable.RoundView_textSize, 15);
        roundWidth = typedArray.getDimension(R.styleable.RoundView_roundWidth, 5);
        //max = typedArray.getInteger(R.styleable.RoundProgressBar_max, 100);
        //textIsDisplayable = typedArray.getBoolean(R.styleable.RoundProgressBar_textIsDisplayable, true);
        typedArray.recycle();

        paint = new Paint();
    }

    public RoundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画背景
        int centre = getWidth() / 2; //获取圆心的x坐标
        paint.setColor(backColor); //设置圆环的颜色
        paint.setStyle(Paint.Style.STROKE); //设置空心
        paint.setStrokeWidth(20); //设置圆环的宽度
        paint.setAntiAlias(true);  //消除锯齿
        canvas.drawCircle(centre, centre, roundWidth, paint); //画出圆环

        //画进度百分比
        paint.setStrokeWidth(0);
        paint.setColor(textColor);
        paint.setTextSize(textSize);
        float percent = ((float) progress / (float) 100) * 100;  //中间的进度百分比，先转换成float在进行除法运算，不然都为0
        BigDecimal decimal = new BigDecimal(percent);
        String s = decimal.setScale(1, BigDecimal.ROUND_HALF_UP).toString();
        float textWidth = paint.measureText(s + "%");   //测量字体宽度，我们需要根据字体的宽度设置在圆环中间
        canvas.drawText(s + "%", centre - textWidth / 2, centre + textSize / 2, paint); //画出进度百分比
        //这里由于是以点向上，右画  为了居中x轴减去字的长一半   y轴 加上字高的一半

        //画圆弧 ，画圆环的进度
        //设置进度是实心还是空心
        paint.setStrokeWidth(20); //设置圆环的宽度
        paint.setColor(color);  //设置进度的颜色
        paint.setStyle(Paint.Style.STROKE);
        RectF oval = new RectF(centre - roundWidth, centre - roundWidth, centre
                + roundWidth, centre + roundWidth);  //用于定义的圆弧的形状和大小的界限
        canvas.drawArc(oval, -90, 360 * progress / 100, false, paint);  //根据进度画圆弧
    }
    /**
     * 设置进度，此为线程安全控件，由于考虑多线的问题，需要同步
     * 刷新界面调用postInvalidate()能在非UI线程刷新
     *
     * @param progress
     */
    public synchronized void setProgress(int progress) {
        if (progress > 100) {
            progress = 100;
        }
        if (progress <= 100) {
            this.progress = progress;
            postInvalidate();//刷新界面  调用了ondraw（）
        }
    }
}
