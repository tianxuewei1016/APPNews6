package xueweu.atguigu.appnews.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import xueweu.atguigu.appnews.R;
import xueweu.atguigu.appnews.adapter.NetAppAdapter;
import xueweu.atguigu.appnews.base.BaseFragment;
import xueweu.atguigu.appnews.bean.MovieInfo;

/**
 * 作者：田学伟 on 2017/4/30 23:54
 * QQ：93226539
 * 作用：本地视频
 */

public class VideoFragment extends BaseFragment implements AdapterView.OnItemClickListener{

    private ListView lv_net_fragment;
    private LinearLayout ll_loading;
    //联网地址
    private String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
    private NetAppAdapter adapter;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //接收消息内容
            String json = (String) msg.obj;
            //使用Gson解析数据
            Gson gson = new Gson();
            //用反射
            MovieInfo movieInfo = gson.fromJson(json, MovieInfo.class);
            //得到集合数据--List<xxx>
            List<MovieInfo.TrailersBean> trailers = movieInfo.getTrailers();

            if (trailers != null && trailers.size() > 0) {
                //集合里面有数据
                //设置适配器
                adapter = new NetAppAdapter(mContext, trailers);
                //设置适配器
                lv_net_fragment.setAdapter(adapter);
                //加载数据的页面消失
                ll_loading.setVisibility(View.GONE);
            } else {
                //集合没有数据
                //加载数据的页面显示
                ll_loading.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_videl, null);
        lv_net_fragment = (ListView) view.findViewById(R.id.lv_net_fragment);
        ll_loading = (LinearLayout) view.findViewById(R.id.ll_loading);

        lv_net_fragment.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MovieInfo.TrailersBean item = adapter.getItem(position);//根据位置获取对应的JavaBean对象
        String url = item.getUrl();//视频的播放地址

        //调用系统的播放器播放视频--隐式意图
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //携带播放地址和文件类型
        intent.setDataAndType(Uri.parse(url), "video/*");
        //启动Activity
        startActivity(intent);
    }

    @Override
    public void initData() {
        super.initData();
        //从网络获取数据
        getDataFromNet();
    }

    private void getDataFromNet() {
        //从网络获取数据-在子线程中请求网络
        new Thread() {
            public void run() {
                //1.构建OkHttpClient类
                OkHttpClient httpClient = new OkHttpClient();

                //2.请求类Request
                Request request = new Request.Builder().url(url).build();
                //3.返回Call
                Call call = httpClient.newCall(request);

                //4.同步或者异步
                //异步的方式
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", "请求失败====" + e.getMessage());
                        //当联网失败：没有网络，资源链接不存在了
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
//                        //得到一个输入流
//                        InputStream is = response.body().byteStream();
//                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        //返回json数据
                        String json = response.body().string();
                        //把请求好的数据保存起来
                        Log.e("TAG", "请求成功==json==" + json);
                        Message msg = Message.obtain();//从消息队列总获取空的消息
                        msg.obj = json;
                        //使用Handler切换到主线程
                        handler.sendMessage(msg);


                    }
                });

            }
        }.start();
    }

}
