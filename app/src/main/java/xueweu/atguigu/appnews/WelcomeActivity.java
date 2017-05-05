package xueweu.atguigu.appnews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import xueweu.atguigu.appnews.activity.Login;

/**
 * 这个界面是欢迎界面
 */

public class WelcomeActivity extends AppCompatActivity {

    private RelativeLayout activity_main;

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        activity_main = (RelativeLayout)findViewById(R.id.activity_main);

        setAnimation();
        //两秒延迟进入主页面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //主線程
                startMainActivity();
            }
        }, 3500);
    }

    private boolean isStartMain = false;

    private void startMainActivity() {
        startActivity(new Intent(this,Login.class));
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        startMainActivity();
        return super.onTouchEvent(event);
    }

    private void setAnimation() {
        RotateAnimation ra = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(2000);
        ra.setFillAfter(true);


        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setDuration(2000);
        aa.setFillAfter(true);

        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(2000);
        sa.setFillAfter(true);

        AnimationSet set = new AnimationSet(false);
        set.addAnimation(aa);
        set.addAnimation(ra);
        set.addAnimation(sa);

        activity_main.startAnimation(set);

        set.setAnimationListener(new MyAnimationListener());
    }

    class MyAnimationListener implements Animation.AnimationListener {
        /**
         * 当动画开始播放的时候回调
         *
         * @param animation
         */
        @Override
        public void onAnimationStart(Animation animation) {

        }

        /**
         * 当动画播放结束的时候回调
         *
         * @param animation
         */
        @Override
        public void onAnimationEnd(Animation animation) {


        }

        /**
         * 当动画重复播放的时候回调
         *
         * @param animation
         */
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}

