package project.shangyanbin20171109_01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import project.shangyanbin20171109_01.jiekou.NewCallBack;
import project.shangyanbin20171109_01.presenter.Mypersenter;

public class MainActivity extends AppCompatActivity implements NewCallBack.LoginCallback{

    @butterknife.Bind(R.id.phone)
    EditText phone;
    @butterknife.Bind(R.id.pwd)
    EditText pwd;
    private Mypersenter mypersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mypersenter = new Mypersenter(this);
        butterknife.ButterKnife.bind(this);

    }
    public void denglu(View view){
        mypersenter.Login(phone.getText().toString(),pwd.getText().toString());
    }
    public void zhuce(View view){
        Intent intent = new Intent(MainActivity.this, ZhuceActivity.class);
        startActivity(intent);
    }
    @Override
    public void LoginPhoneEmpty() {
        Toast.makeText(MainActivity.this,"手机号不能为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginPwdEmpty() {
        Toast.makeText(MainActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Loginsuccessa(final String string) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,string,Toast.LENGTH_SHORT).show();
               if(string.indexOf("登录成功")>=0){
                   Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(MainActivity.this,SeocndActivity.class);
                    startActivity(intent);
               }
            }
        });
    }

    @Override
    public void Loginerrora(final Integer objects) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,objects,Toast.LENGTH_SHORT).show();
            }
        });
    }


}
