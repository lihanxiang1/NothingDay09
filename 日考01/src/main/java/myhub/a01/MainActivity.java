package myhub.a01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText tel;
    private EditText pass;
    private String tels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tel = (EditText) findViewById(R.id.text01);
        pass = (EditText) findViewById(R.id.text02);

        Button denglu = (Button) findViewById(R.id.denglu);
        Button zhuce = (Button) findViewById(R.id.zhuce);

        denglu.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
//                tels = tel.getText();
                if (tel==null&&pass==null){
                    Intent intent = new Intent(MainActivity.this,OtherActivity.class);
                    startActivity(intent);
                }else{
                    Log.i("-----", tels +"--"+pass);
                    Toast.makeText(MainActivity.this,"空了",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
