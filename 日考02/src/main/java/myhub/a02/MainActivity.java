package myhub.a02;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import myhub.a02.adapter.MyAdapter;
import myhub.a02.bean.UserBean;
import myhub.a02.view.XListView;

public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener {

    private XListView xListView;
    private List<UserBean.DataBean> list = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xListView = (XListView) findViewById(R.id.XListView);

        //上拉
        xListView.setPullLoadEnable(true);
        //下拉
        xListView.setPullRefreshEnable(true);

        xListView.setXListViewListener(this);


        getLoadEnable();
    }

    private void getLoadEnable() {
        AsyncTask<Void,Void,String> asyncTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                String path = "http://120.27.23.105/product/getProducts?pscid=39&page=1";
                try {
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);
                    int responseCode = connection.getResponseCode();
                    if (responseCode == 200){
                        InputStream inputStream = connection.getInputStream();
                        String json = StreamToString(inputStream, "utf-8");

                        return json;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                Gson gson = new Gson();
                UserBean userBean = gson.fromJson(s, UserBean.class);
                //list = null;
                Log.i("-------" , "list1" + list);
                list.addAll(userBean.getData());
                Log.i("-------" , "list2" + list);
                //设置适配器
                getadapter();
            }
        };
        asyncTask.execute();
    }

    private String StreamToString(InputStream inputStream, String s) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, s);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder builder = new StringBuilder();
            String string = "";
            while ((string = bufferedReader.readLine()) != null){
                builder.append(string);
            }
            bufferedReader.close();
            Log.i("builder" , "builder---->" + builder.toString());
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    //设置适配器
    private void getadapter() {
        if (adapter == null){
            adapter = new MyAdapter(MainActivity.this, list);
            xListView.setAdapter(adapter);
        }else{
            adapter.notifyDataSetChanged();;
        }
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
