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
import xueweu.atguigu.appnews.bean.MovieInfo;

/**
 * 作者：田学伟 on 2017/5/1 19:15
 * QQ：93226539
 * 作用：
 */

public class NetAppAdapter extends BaseAdapter{

    /**
     * 集合数据
     */
    private final List<MovieInfo.TrailersBean> datas;
    private final Context context;

    /**
     * 构造器
     * @param context
     * @param datas
     */
    public NetAppAdapter(Context context, List<MovieInfo.TrailersBean> datas) {
        this.context = context;
        this.datas = datas;


    }
    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public MovieInfo.TrailersBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //判断convertView是否为空
        ViewHolder viewHolder = null;
        if(convertView == null){
            //convertView 为null
            convertView = View.inflate(context,R.layout.item_net_video,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_icon6 = (ImageView) convertView.findViewById(R.id.iv_icon6);
            viewHolder.tv_name6 = (TextView) convertView.findViewById(R.id.tv_name6);
            viewHolder.tv_desc6 = (TextView) convertView.findViewById(R.id.tv_desc6);
            //convertView和ViewHolder一一对应关联起来
            convertView.setTag(viewHolder);

        }else{
            //convertView 有值
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //根据下标位置从集合中获取对应的数据--局部变量
        MovieInfo.TrailersBean itemData = datas.get(position);
        //设置电影的名称
        viewHolder.tv_name6.setText(itemData.getMovieName());
        viewHolder.tv_desc6.setText(itemData.getVideoTitle());
        //使用Picasso加载图片-本地就支持图片三级缓存
        Picasso.with(context)//毕加索
                .load(itemData.getCoverImg())//图片路径
                .placeholder(R.mipmap.ic_launcher)//正在加载的时候显示
                .error(R.mipmap.ic_launcher)//如果图片加载失败，默认使用这张图片
                .into(viewHolder.iv_icon6);//加载好的图片要显示在谁上

        return convertView;
    }

    static class ViewHolder{
        ImageView iv_icon6;
        TextView tv_name6;
        TextView tv_desc6;
    }
}
