package xueweu.atguigu.appnews.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import xueweu.atguigu.appnews.R;

public class MyService extends Service {
    private MediaPlayer mediaPlayer;

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String command = intent.getStringExtra("command");
        if ("play".equals(command)) {
            play();
        } else if ("pause".equals(command)) {
            pause();
        } else if ("stop".equals(command)) {
            stop();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();//释放资源
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void pause() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();//暂停音乐
        }
    }

    private void play() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.everything_at_once);
        }

        if (mediaPlayer != null) {
            mediaPlayer.start();//播放音乐
        }
    }
}
