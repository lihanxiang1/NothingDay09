package lianxi.a05_02;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.Timer;
import java.util.TimerTask;

import lianxi.a05_02.view.RoundView;

public class MainActivity extends Activity {

    private RoundView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RoundView) findViewById(R.id.rv);
    }

    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.iv_z:
                Toast.makeText(this, "左侧", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_y:
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                finish();
                break;
            case R.id.btn:
                final int[] i = {0};
                final Timer timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        if (i[0] == 10) {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                                    startActivityForResult(intent, 1);
                                }
                            });
                            timer.cancel();
                        }
                        rv.setProgress(i[0] * 10);
                        i[0]++;
                    }
                };
                //第二個參數是只你第一次推迟多久   第三个参数是指你第二次以后每次隔多久
                timer.schedule(timerTask, 0, 1000);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /**
         * 处理二维码扫描结果
         */
        if (requestCode == 1) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
