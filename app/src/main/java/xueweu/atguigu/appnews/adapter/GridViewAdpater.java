package xueweu.atguigu.appnews.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import xueweu.atguigu.appnews.R;

/**
 * 作者：田学伟 on 2017/5/5 16:49
 * QQ：93226539
 * 作用：
 */

public class GridViewAdpater extends BaseAdapter{


    private final Context mContext;
    private final String[] names;
    private final int[] icons;

    public GridViewAdpater(Context mContext, String[] names, int[] icons) {
        this.mContext = mContext;
        this.names = names;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return names==null ? 0 : names.length;
    }

    @Override
    public String getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView ==null){
            //把布局文件item Lyout转换成View
            convertView = View.inflate(mContext,R.layout.item_gridview,null);
            viewHolder = new ViewHolder();
            //把findViewById后的子View放在ViewHolder里面
            viewHolder.iv_icons = (ImageView) convertView.findViewById(R.id.iv_icons);
            viewHolder.tv_names = (TextView) convertView.findViewById(R.id.tv_names);
            //convertView要和ViewHolder一一关联
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //根据位置索引得到对应的数据，并且从ViewHolder取出子View,设置数据
        viewHolder.iv_icons.setImageResource(icons[position]);
        viewHolder.tv_names.setText(names[position]);



        return convertView;
    }

    static class ViewHolder{
        ImageView iv_icons;
        TextView tv_names;
    }
}
