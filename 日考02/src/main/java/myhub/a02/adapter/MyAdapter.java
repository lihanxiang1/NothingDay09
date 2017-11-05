package myhub.a02.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

import myhub.a02.MainActivity;
import myhub.a02.R;
import myhub.a02.bean.UserBean;

/**
 * Created by Lonely on 2017/11/1.
 */
public class MyAdapter extends BaseAdapter {

    Context context;
    List<UserBean.DataBean> list;
    private static final int IMAGE_ITEM_LEFT = 0;
    private static final int IMAGE_ITEM_RIGHT = 1;

    public MyAdapter(Context context, List<UserBean.DataBean> list) {
        this.context = context;
        this.list = list;

        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if ((position%2) == 0){
            return IMAGE_ITEM_LEFT;
        }
        return IMAGE_ITEM_RIGHT;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == IMAGE_ITEM_LEFT){
            ViewHolderLeft holderLeft;
            if (view == null){
                holderLeft = new ViewHolderLeft();
                view = View.inflate(context , R.layout.image_left , null);
                holderLeft.textView = (TextView) view.findViewById(R.id.text_title);
                holderLeft.textView2 = (TextView) view.findViewById(R.id.text_title02);
                holderLeft.imageView = (ImageView) view.findViewById(R.id.iamge_01);
                view.setTag(holderLeft);
            }else{
                holderLeft = (ViewHolderLeft) view.getTag();
            }
            holderLeft.textView.setText(list.get(i).getTitle());
            holderLeft.textView2.setText((int) list.get(i).getBargainPrice());
            ImageLoader.getInstance().displayImage(list.get(i).getImages() , holderLeft.imageView , getOption());
        }else{
            ViewHolderRight holderRight;
            if (view == null){
                holderRight = new ViewHolderRight();
                view = View.inflate(context , R.layout.image_right , null);
                holderRight.textView = (TextView) view.findViewById(R.id.text_title);
                holderRight.textView02 = (TextView) view.findViewById(R.id.text_title02);
                holderRight.imageView = (ImageView) view.findViewById(R.id.iamge_02);
                view.setTag(holderRight);
            }else{
                holderRight = (ViewHolderRight) view.getTag();
            }
            holderRight.textView.setText(list.get(i).getTitle());
            holderRight.textView02.setText((int) list.get(i).getBargainPrice());
            ImageLoader.getInstance().displayImage(list.get(i).getImages() , holderRight.imageView , getOption());
        }
        return view;
    }
    public DisplayImageOptions getOption() {
        DisplayImageOptions imageOptions = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .resetViewBeforeLoading(true)//在加载之前复位一下显示
                .bitmapConfig(Bitmap.Config.RGB_565)//图片的质量
                .considerExifParams(true)//是否考虑JPEG图像EXIF参数（旋转，翻转）
                .build();
        return imageOptions;
    }
    class ViewHolderLeft{
        ImageView imageView;
        TextView textView;
        TextView textView2;
    }
    class ViewHolderRight{
        TextView textView;
        TextView textView02;
        ImageView imageView;
    }
}
