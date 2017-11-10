package project.shangyanbin20171109_01.jiekou;

/**
 * Created by Lonely on 2017/11/9.
 */
public interface NewCallBack {
    public interface LoginCallback{
        public void LoginPhoneEmpty();
        public void LoginPwdEmpty();
        public void Loginsuccessa(String string);
        public void Loginerrora(Integer objects);
    }
    public interface LoginSuccess{
        public void Loginsuccess(String string);
        public void Loginerror(Integer objects);
    }
    public interface ZhuCeCallback{
        public void ZhuPhoneEmpty();
        public void ZhuPwdEmpty();
        public void Zhucesuccessa(String string);
        public void Zhuceerrora(Integer objects);
    }
    public interface ZhuceSuccess{
        public void zhucesuccess(String string);
        public void Zhuceerror(Integer objects);
    }
}
