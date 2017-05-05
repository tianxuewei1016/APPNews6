package xueweu.atguigu.appnews.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import xueweu.atguigu.appnews.R;
import xueweu.atguigu.appnews.adapter.AppNewsAdapter;
import xueweu.atguigu.appnews.base.BaseFragment;
import xueweu.atguigu.appnews.bean.NewsInfo;

/**
 * 作者：田学伟 on 2017/4/30 23:54
 * QQ：93226539
 * 作用：硅谷新闻
 */

public class NewsFragment extends BaseFragment {

    private ListView lv_news_fragment;
    private TextView tv_no_media;
    private AppNewsAdapter adapter;

    private List<NewsInfo.ListBean> listBeen;
    private String url = "http://wangyi.butterfly.mopaasapp.com/news/api?type=war&page=1&limit=10";

    MaterialRefreshLayout mRefresh;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //接收消息内容
            String json = (String) msg.obj;
            //使用Gson解析数据
            Gson gson = new Gson();
            //用反射
            NewsInfo newsInfo = gson.fromJson(json, NewsInfo.class);

            listBeen = newsInfo.getList();

            if (listBeen != null && listBeen.size() > 0) {
                //集合里面有数据
                //设置适配器
                adapter = new AppNewsAdapter(mContext, listBeen);
                //设置适配器
                lv_news_fragment.setAdapter(adapter);

                tv_no_media.setVisibility(View.GONE);
            } else {
                //集合没有数据
                //加载数据的页面显示
                tv_no_media.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    public View initView() {
        Log.e("TAG", "本地新闻ui初始化了。。");
        View view = View.inflate(mContext, R.layout.fragment_news, null);
        lv_news_fragment = (ListView) view.findViewById(R.id.lv_news_fragment);
        tv_no_media = (TextView) view.findViewById(R.id.tv_no_media);
        mRefresh = (MaterialRefreshLayout) view.findViewById(R.id.refresh);

        lv_news_fragment.setOnItemClickListener(new MyOnItemClickListener());
        //监听下拉和上拉刷新
        mRefresh.setMaterialRefreshListener(new MyMaterialRefreshListener());
        return view;
    }

    /**
     * 是否加载更多
     */
    private boolean isLoadMore = false;

    class MyMaterialRefreshListener extends MaterialRefreshListener {

        @Override
        public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
            isLoadMore = false;
            getDataFromNews();
        }

        @Override
        public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
            super.onRefreshLoadMore(materialRefreshLayout);
            isLoadMore = true;
            getDataFromNews();
        }
    }

    class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            NewsInfo.ListBean item = adapter.getItem(position);
            String url = item.getDocurl();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri content_url = Uri.parse(url);
            intent.setData(content_url);
            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
            startActivity(intent);
        }
    }

    @Override
    public void initData() {
        super.initData();
        //网络请求数据
        getDataFromNews();
    }

    /**
     * 网络请求数据
     */
    private void getDataFromNews() {
        //从网络获取数据--在子线程中请求网络
        new Thread() {
            public void run() {
                //1.构建OkHttpClient类
                OkHttpClient httpClient = new OkHttpClient();

                //2.请求类Request
                Request request = new Request.Builder()
                        .url(url).build();

                //3.返回Call
                Call call = httpClient.newCall(request);

                //4.同步或者异步
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", "请求失败====" + e.getMessage());
                        //当联网失败：没有网络，资源链接不存在了
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        //返回json数据
                        String json = response.body().string();
                        Log.e("TAG", "请求成功==json==" + json);
                        Message msg = Message.obtain();//从消息队列总获取空的消息
                        msg.obj = json;
                        //使用Handler切换到主线程

                        if (!isLoadMore) {
                            //完成刷新
                            mRefresh.finishRefresh();
                        } else {
                            //把上拉的隐藏
                            mRefresh.finishRefreshLoadMore();
                        }
                        handler.sendMessage(msg);
                    }
                });

            }
        }.start();
    }

    @Override
    public void onRefrshData() {
        super.onRefrshData();
    }
}
