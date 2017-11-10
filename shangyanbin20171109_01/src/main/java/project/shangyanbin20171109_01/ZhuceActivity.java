package project.shangyanbin20171109_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import project.shangyanbin20171109_01.jiekou.NewCallBack;
import project.shangyanbin20171109_01.presenter.Mypersenter;

public class ZhuceActivity extends AppCompatActivity implements NewCallBack.ZhuCeCallback{

    private EditText zhucephone;
    private EditText zhucepwd;
    private Mypersenter mypersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mypersenter = new Mypersenter(this);
        setContentView(R.layout.activity_zhuce);
        zhucephone = (EditText) findViewById(R.id.zhucephone);
        zhucepwd = (EditText) findViewById(R.id.zhucepwd);

    }
    public void zhuceyonghu(View view){
        mypersenter.Zhuce(zhucephone.getText().toString(),zhucepwd.getText().toString());
    }

    @Override
    public void ZhuPhoneEmpty() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ZhuceActivity.this,"手机号为空",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void ZhuPwdEmpty() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ZhuceActivity.this,"密码为空",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void Zhucesuccessa(final String string) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ZhuceActivity.this,string,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void Zhuceerrora(final Integer objects) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ZhuceActivity.this,objects,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
