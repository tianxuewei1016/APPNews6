package xueweu.atguigu.appnews.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import xueweu.atguigu.appnews.R;
import xueweu.atguigu.appnews.activity.AnimationActivity;
import xueweu.atguigu.appnews.activity.CallCenterActivity;
import xueweu.atguigu.appnews.activity.DrawableActivity;
import xueweu.atguigu.appnews.activity.MusicActivity;
import xueweu.atguigu.appnews.activity.NetAppActivity;
import xueweu.atguigu.appnews.activity.PhoneActivity;
import xueweu.atguigu.appnews.adapter.GridViewAdpater;
import xueweu.atguigu.appnews.base.BaseFragment;

/**
 * 作者：田学伟 on 2017/4/30 23:55
 * QQ：93226539
 * 作用：
 */

public class MusicFragment extends BaseFragment implements AdapterView.OnItemClickListener{

    private GridView gv;
    private GridViewAdpater adpater;

    //名称
    private String[] names = new String[]{"电话短信", "NetApp", "动画", "摇摆", "媛媛老师",
            "音乐", "缓存清理", "高级工具", "设置中心"};

    //图标
    private int[] icons = new int[]{R.drawable.widget01, R.drawable.widget02,
            R.drawable.widget03, R.drawable.widget04, R.drawable.widget05,
            R.drawable.widget06, R.drawable.widget07, R.drawable.widget08,
            R.drawable.widget09};



    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.music_fragment, null);
        gv = (GridView) view.findViewById(R.id.gv);
        gv.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void initData() {

        adpater = new GridViewAdpater(mContext,names,icons);
        gv.setAdapter(adpater);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       switch (position){
           case 0:
                startActivity(new Intent(mContext,PhoneActivity.class));
               break;
           case 1:
               startActivity(new Intent(mContext,NetAppActivity.class));
               break;
           case 2:
               startActivity(new Intent(mContext,AnimationActivity.class));
               break;
           case 3:
               startActivity(new Intent(mContext,DrawableActivity.class));
               break;
           case 4:
               startActivity(new Intent(mContext,CallCenterActivity.class));
               break;
           case 5:
               startActivity(new Intent(mContext,MusicActivity.class));
               break;
           case 6:

               break;
           case 7:

               break;
           case 8:

               break;
           case 9:

               break;
       }
    }
}
