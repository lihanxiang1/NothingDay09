package lianxi.a05_02.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import lianxi.a05_02.R;

/**
 * Created by Lonely on 2017/11/4.
 */
public class GroupView extends View {

    private int oneColor;
    private int twoColor;
    private int threeColor;
    float mHeight;
    private Paint paint;

    public GroupView(Context context) {
        super(context);
    }

    public GroupView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GroupView);

        oneColor = typedArray.getColor(R.styleable.GroupView_oneColor, Color.RED);
        twoColor = typedArray.getColor(R.styleable.GroupView_twocolor, Color.RED);
        threeColor = typedArray.getColor(R.styleable.GroupView_threeColor, Color.RED);
        mHeight = typedArray.getDimension(R.styleable.GroupView_mHeight, 15);

        typedArray.recycle();

        paint = new Paint();
    }

    public GroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(oneColor);
        canvas.drawRect(0, 0, getWidth() / 3, mHeight, paint);

        paint.setColor(twoColor);
        canvas.drawRect(getWidth() / 3, mHeight, getWidth() / 3 * 2, mHeight * 2, paint);

        paint.setColor(threeColor);
        canvas.drawRect(getWidth() / 3 * 2, mHeight * 2, getWidth(), mHeight * 3, paint);
    }
}
