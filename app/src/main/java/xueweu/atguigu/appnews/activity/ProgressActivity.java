package xueweu.atguigu.appnews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import xueweu.atguigu.appnews.R;

public class ProgressActivity extends AppCompatActivity {

    private LinearLayout ll_progress_loading;
    private ProgressBar pb_progress_loading;
    private SeekBar sb_progress_voice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        //初始化控件
        ll_progress_loading = (LinearLayout) findViewById(R.id.ll_progress_loading);
        pb_progress_loading = (ProgressBar) findViewById(R.id.pb_progress_loading);
        sb_progress_voice = (SeekBar) findViewById(R.id.sb_progress_voice);
        //设置最大值，默认值是100
        pb_progress_loading.setMax(1000);
        sb_progress_voice.setMax(1000);



        //设置SeekBar改变的监听
        sb_progress_voice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            /**
             * 当手指在上面拖动的时候回调
             * @param seekBar SeekBar自身
             * @param progress 拖动的进度
             * @param fromUser true:用户拖动，false:自动改变的
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("TAG","progress==="+progress+",fromUser=="+fromUser);

                //设置ProgressBar进度
                //方式一：
//                pb_progress_loading.setProgress(progress);
                //方式二：
                pb_progress_loading.setProgress(sb_progress_voice.getProgress());

                //当滑到最大值的时候，隐藏加载布局
                if(progress==sb_progress_voice.getMax()){
                    //隐藏
                    //View.GONE:隐藏并且把空间让出来
                    //View.INVISIBLE:隐藏，但还占用空间
//                    ll_progress_loading.setVisibility(View.GONE);
                    ll_progress_loading.setVisibility(View.INVISIBLE);
                }else{
                    ll_progress_loading.setVisibility(View.VISIBLE);
                }

            }

            /**
             * 当手指一触碰的时候回调
             * @param seekBar
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("TAG","onStartTrackingTouch===");
            }

            /**
             * 手指离开的时候回调
             * @param seekBar
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("TAG","onStopTrackingTouch===");
            }
        });
    }
}
