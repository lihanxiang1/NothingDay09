package lianxi.titleactivitydemo04.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lianxi.titleactivitydemo04.R;
import lianxi.titleactivitydemo04.TitleActivity;

public class NewActivity extends TitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);


    }

    public String shujv(String name){
        System.out.println("NewActivity打印1"+name);
        name = "换了";
        System.out.println("NewActivity打印2"+name);
        return name;
    }
}
