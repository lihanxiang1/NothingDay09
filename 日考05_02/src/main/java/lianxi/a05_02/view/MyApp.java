package lianxi.a05_02.view;

import android.app.Application;

import com.uuzuche.lib_zxing.ZApplication;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by Lonely on 2017/11/4.
 */
public class MyApp extends ZApplication{

    @Override
    public void onCreate() {
        super.onCreate();

        ZXingLibrary.initDisplayOpinion(this);
    }
}
