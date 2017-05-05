package xueweu.atguigu.appnews.fragment;

import android.view.View;
import android.widget.ListView;

import xueweu.atguigu.appnews.R;
import xueweu.atguigu.appnews.base.BaseFragment;

/**
 * 作者：田学伟 on 2017/4/30 23:55
 * QQ：93226539
 * 作用：硅谷商城
 */

public class ShoppingFragment extends BaseFragment{

    private ListView fragment_home;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        fragment_home = (ListView) view.findViewById(R.id.lv_shopoing);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromShopping();
    }

    private void getDataFromShopping() {
        
    }


}
