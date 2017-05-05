package xueweu.atguigu.appnews.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import xueweu.atguigu.appnews.R;
import xueweu.atguigu.appnews.bean.NewsInfo;

/**
 * 作者：田学伟 on 2017/4/30 23:58
 * QQ：93226539
 * 作用：
 */

public class AppNewsAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<NewsInfo.ListBean> datas;

    public AppNewsAdapter(Context mContext, List<NewsInfo.ListBean> listBeen) {
        this.mContext = mContext;
        this.datas = listBeen;

    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public NewsInfo.ListBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //判断convertView是否为空
        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_news_app,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tv_desc = (TextView) convertView.findViewById(R.id.tv_desc);
            viewHolder.tv_war = (TextView) convertView.findViewById(R.id.tv_war);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //根据下标位置从集合中获取对应的数据--局部变量
        NewsInfo.ListBean listBean = datas.get(position);
        viewHolder.tv_name.setText(listBean.getTitle());
        viewHolder.tv_desc.setText(listBean.getTime());
        viewHolder.tv_war.setText(listBean.getChannelname());
        //使用Picasso加载图片-本地就支持图片三级缓存
        Picasso.with(mContext)//毕加索
                .load(listBean.getImgurl())//图片路径
                .placeholder(R.mipmap.ic_launcher)//正在加载的时候显示
                .error(R.mipmap.ic_launcher)//如果图片加载失败，默认使用这张图片
                .into(viewHolder.iv_icon);//加载好的图片要显示在谁上
        return convertView;
    }
    static class ViewHolder{
        ImageView iv_icon;
        TextView tv_name;
        TextView tv_desc;
        TextView tv_war;
    }
}
