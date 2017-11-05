package lianxi.titleactivitydemo04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lianxi.titleactivitydemo04.activity.NewActivity;

public class TitleActivity extends AppCompatActivity {

    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.textView2)
    TextView textView2;
    @Bind(R.id.textView3)
    TextView textView3;
    @Bind(R.id.linear_layout)
    RelativeLayout linearLayout;
    @Bind(R.id.textview4)
    TextView textview4;
    @Bind(R.id.button)
    Button button;
    private NewActivity newActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        ButterKnife.bind(this);

        newActivity = new NewActivity();
    }

    @OnClick({R.id.textView, R.id.textView3, R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                Toast.makeText(this,"我是返回",Toast.LENGTH_SHORT).show();
                break;
            case R.id.textView3:
                Toast.makeText(this,"我是提交按钮",Toast.LENGTH_SHORT).show();
                System.out.println("TitleActivity打印"+textview4.toString());
                String shujv = newActivity.shujv(textview4.toString());
                textview4.setText(shujv);
//                invalidate();
                invalidateOptionsMenu();
                break;
            case R.id.button:
                Toast.makeText(this,"我是返回按钮",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
