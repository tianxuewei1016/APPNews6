package xueweu.atguigu.appnews.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import xueweu.atguigu.appnews.base.BaseFragment;

/**
 * 作者：田学伟 on 2017/4/30 23:55
 * QQ：93226539
 * 作用：
 */

public class ShoppingCartFragment extends BaseFragment{



    private TextView textView;

    @Override
    public View initView() {
        Log.e("TAG", "本地购物车ui初始化了。。");
        textView = new TextView(mContext);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e("TAG", "本地购物车数据初始化了。。");
        textView.setText("本地购物车");
    }

    @Override
    public void onRefrshData() {
        super.onRefrshData();
        textView.setText("本地购物车刷新");
    }
}
