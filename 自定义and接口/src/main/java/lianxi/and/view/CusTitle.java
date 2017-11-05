package lianxi.and.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import lianxi.and.R;

/**
 * Created by Lonely on 2017/11/5.
 */
public class CusTitle extends RelativeLayout {
    public CusTitle(Context context) {
        super(context);
    }

    public CusTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.title , null);
//        Button left = view.findViewById(R.id.left);
//        Button right = view.findViewById(R.id.right);
        this.addView(view);
    }

    public CusTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
