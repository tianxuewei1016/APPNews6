package xueweu.atguigu.appnews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import xueweu.atguigu.appnews.R;
import xueweu.atguigu.appnews.service.MyService;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_main_play;
    private Button btn_main_pause;
    private Button btn_main_stop;
    private Button btn_main_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //初始化控件
        btn_main_play = (Button) findViewById(R.id.btn_main_play);
        btn_main_pause = (Button) findViewById(R.id.btn_main_pause);
        btn_main_stop = (Button) findViewById(R.id.btn_main_stop);
        btn_main_exit = (Button) findViewById(R.id.btn_main_exit);

        //初始化控件
        btn_main_play = (Button) findViewById(R.id.btn_main_play);
        btn_main_pause = (Button) findViewById(R.id.btn_main_pause);
        btn_main_stop = (Button) findViewById(R.id.btn_main_stop);
        btn_main_exit = (Button) findViewById(R.id.btn_main_exit);

        //设置按钮的点击事件
        btn_main_play.setOnClickListener(this);
        btn_main_pause.setOnClickListener(this);
        btn_main_stop.setOnClickListener(this);
        btn_main_exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_play:
                play();
                break;
            case R.id.btn_main_pause:
                pause();
                break;
            case R.id.btn_main_stop:
                stop();
                break;
            case R.id.btn_main_exit:
                //退出Activity
                finish();
                break;
        }
    }

    private void stop() {
        Intent intent = new Intent(this,MyService.class);
        intent.putExtra("command","stop");
        startService(intent);
    }

    private void pause() {
        Intent intent = new Intent(this,MyService.class);
        intent.putExtra("command","pause");
        startService(intent);
    }

    private void play() {
        Intent intent = new Intent(this,MyService.class);
        intent.putExtra("command","play");
        startService(intent);
    }
}
