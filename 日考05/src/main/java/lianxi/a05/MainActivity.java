package lianxi.a05;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.uuzuche.lib_zxing.activity.CaptureActivity;

import lianxi.a05.view.Pro;

public class MainActivity extends AppCompatActivity {

    @butterknife.Bind(R.id.image_fh)
    ImageButton imageFh;
    @butterknife.Bind(R.id.image_home)
    ImageButton imageHome;
    @butterknife.Bind(R.id.text)
    RelativeLayout text;
    @butterknife.Bind(R.id.pro)
    Pro pro;
    @butterknife.Bind(R.id.button_sm)
    Button buttonSm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);

    }

    public void chuan(int text) {
        System.out.println("text2222222222222 = " + text);
        if (text == 100) {
            Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
            startActivityForResult(intent, 1);
        }
    }

    @butterknife.OnClick({R.id.image_fh, R.id.image_home, R.id.button_sm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_fh:

                break;
            case R.id.image_home:

                break;
            case R.id.button_sm:
                int jia = 36;
                Pro pro = new Pro(this);
                pro.chuanzhi(jia);
                break;
        }
    }

//    private void shuzhi(int jia) {
//
//    }
}
