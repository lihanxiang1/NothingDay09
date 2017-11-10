package project.shangyanbin20171109_01.model;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import project.shangyanbin20171109_01.jiekou.NewCallBack;

/**
 * Created by Lonely on 2017/11/9.
 */
public class Mymodel {

    public static void getdata(String phone, String pwd, final NewCallBack.LoginSuccess loginSuccess) {
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。

        FormBody build = new FormBody.Builder()
                .add("mobile", phone)
                .add("password", pwd)
                .build();
        //传递键值对参数
        Request request = new Request.Builder()//创建Request 对象。
                .url("http://120.27.23.105/user/login")
                .post(build)//传递请求体
               .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                loginSuccess.Loginerror(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                loginSuccess.Loginsuccess(string);
            }
        });//回调方法的使用与get异步请求相同，此时略。
    }

    public static void Zhuce(String phone, String pwd, final NewCallBack.ZhuceSuccess zhuceSuccess) {
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。

        FormBody build = new FormBody.Builder()
                .add("mobile", phone)
                .add("password", pwd)
                .build();
        //传递键值对参数
        final Request request = new Request.Builder()//创建Request 对象。
                .url("http://120.27.23.105/user/reg")
                .post(build)//传递请求体
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                zhuceSuccess.Zhuceerror(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                zhuceSuccess.zhucesuccess(string);

            }
        });//
    }
}
