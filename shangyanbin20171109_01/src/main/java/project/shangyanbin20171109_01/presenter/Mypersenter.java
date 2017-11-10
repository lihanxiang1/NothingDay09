package project.shangyanbin20171109_01.presenter;

import android.text.TextUtils;

import project.shangyanbin20171109_01.jiekou.NewCallBack;
import project.shangyanbin20171109_01.model.Mymodel;

/**
 * Created by Lonely on 2017/11/9.
 */
public class Mypersenter {
    private  NewCallBack.LoginCallback callback;
    public Mypersenter(NewCallBack.LoginCallback callback) {
        this.callback =callback;
    }
    public NewCallBack.ZhuCeCallback zhuce;
    public Mypersenter(NewCallBack.ZhuCeCallback zhuce) {
        this.zhuce=zhuce;
    }

    public void Login(String phone, String pwd) {
        if(TextUtils.isEmpty(phone)){
            callback.LoginPhoneEmpty();
            return;
        }
        if(TextUtils.isEmpty(pwd)){
            callback.LoginPwdEmpty();
            return;
        }
        Mymodel.getdata(phone,pwd, new NewCallBack.LoginSuccess() {

            @Override
            public void Loginsuccess(String string) {
                callback.Loginsuccessa(string);
            }

            @Override
            public void Loginerror(Integer objects) {
                callback.Loginerrora(objects);
            }
        });
    }


    public  void Zhuce(String phone, String pwd) {
        if(TextUtils.isEmpty(phone)){
            zhuce.ZhuPhoneEmpty();
            return;
        }
        if(TextUtils.isEmpty(pwd)){
            zhuce.ZhuPwdEmpty();
            return;
        }
        Mymodel.Zhuce(phone,pwd, new NewCallBack.ZhuceSuccess() {
            @Override
            public void zhucesuccess(String string) {
                zhuce.Zhucesuccessa(string);
            }

            @Override
            public void Zhuceerror(Integer objects) {
                zhuce.Zhuceerrora(1);
            }
        });
    }
}
