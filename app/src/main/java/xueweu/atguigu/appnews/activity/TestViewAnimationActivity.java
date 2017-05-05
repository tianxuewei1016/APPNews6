package xueweu.atguigu.appnews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import xueweu.atguigu.appnews.R;

public class TestViewAnimationActivity extends AppCompatActivity {

    private TextView tv_animation_msg;

    private ImageView iv_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_animation);
        tv_animation_msg = (TextView) findViewById(R.id.tv_animation_msg);

        iv_animation = (ImageView) findViewById(R.id.iv_animation);
    }

    /*
      * 1.1  编码实现: 缩放动画
      * ScaleAnimation
      */
    public void startCodeScale(View v) {
        tv_animation_msg.setText("Code缩放动画: 宽度从0.5到1.5, 高度从0.0到1.0, 缩放的圆心为顶部中心点,延迟1s开始,持续2s,最终还原");
        //1.创建动画
        ScaleAnimation sa = new ScaleAnimation(0.5f, 1.5f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0f);
        //2.设置相关参数
        //延迟一秒执行
        sa.setStartOffset(1000);
        //设置动画持续两秒执行
        sa.setDuration(2000);
        //设置最终还原状态
        sa.setFillAfter(false);
        //3.播放动画
        iv_animation.startAnimation(sa);
    }

    /*
     * 1.2 xml实现: 缩放动画
     * <scale>
     */
    public void startXmlScale(View v) {
        tv_animation_msg.setText("Xml缩放动画: Xml缩放动画: 宽度从0.0到1.5, 高度从0.0到1.0, 延迟1s开始,持续3s,圆心为左上角, 最终固定");
        //1.写XM动画
        //2.加载动画
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        //3.播放动画
        iv_animation.startAnimation(animation);
    }

    /*
     * 2.1 编码实现: 旋转动画
     * RotateAnimation
     */
    public void startCodeRotate(View v) {
        tv_animation_msg.setText("Code旋转动画: 以图片中心点为中心, 从负90度到正90度, 持续5s");
        //1.创建动画
        RotateAnimation ra = new RotateAnimation(-90, 90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //2.设置相关参数
        ra.setDuration(5000);
        ra.setFillAfter(false);
        //3.播放动画
        iv_animation.startAnimation(ra);
    }

    /*
     * 2.2 xml实现: 旋转动画
     * <rotate>
     */
    public void startXmlRotate(View v) {
        tv_animation_msg.setText("Xml旋转动画: 以左顶点为坐标, 从正90度到负90度, 持续5s");
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        iv_animation.startAnimation(animation);
    }

    /*
     * 3.1 编码实现: 透明度动画
     * AlphaAnimation
     */
    public void startCodeAlpha(View v) {
        tv_animation_msg.setText("Code透明度动画: 从完全透明到完全不透明, 持续2s");

        AlphaAnimation aa = new AlphaAnimation(0f, 1.0f);
        //设置持续事件
        aa.setDuration(2000);
        //设置停留到动画播放结束状态
        aa.setFillAfter(true);
        iv_animation.startAnimation(aa);
    }


    /*
     * 3.2 xml实现: 透明度动画
     * <alpha>
     */
    public void startXmlAlpha(View v) {
        tv_animation_msg.setText("Xml透明度动画: 从完全不透明到完全透明, 持续1s");
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        iv_animation.startAnimation(animation);
    }


    /*
     * 4.1 编码实现: 平移动画
     * TranslateAnimation
     */
    public void startCodeTranslate(View v) {
        tv_animation_msg.setText("Code移动动画: 向右移动一个自己的宽度, 向下移动一个自己的高度, 持续2s");
        TranslateAnimation tra = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1);
        tra.setDuration(2000);
        tra.setFillAfter(true);
        iv_animation.startAnimation(tra);
    }

    /*
     * 4.2 xml实现: 平移动画
     * <translate>
     */
    public void startXmlTranslate(View v) {
        tv_animation_msg.setText("xml移动动画: 从屏幕的右边逐渐回到原来的位置, 持续2s"); //***此效果用于界面切换的动画效果
        //1.写入XML文件的平移动画
        //2.AnimationUtils加载动画
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        //3.播放动画
        iv_animation.startAnimation(animation);
    }

    /*
     * 5.1 编码实现: 复合动画
     * AnimationSet
     */
    public void startCodeAnimationSet(View v) {
        tv_animation_msg.setText("Code复合动画: 透明度从透明到不透明, 持续2s, 接着进行旋转360度的动画, 持续1s");

        AlphaAnimation aa = new AlphaAnimation(0f, 1.0f);
        //持续2s
        aa.setDuration(2000);


        RotateAnimation ra = new RotateAnimation(1, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //持续时间1s
        ra.setDuration(1000);
        ra.setStartOffset(2000);
        //动画的集合,是否使用窜改器
        AnimationSet set = new AnimationSet(false);

        set.addAnimation(aa);
        set.addAnimation(ra);

        //播放动画
        iv_animation.startAnimation(set);

    }

    /*
     * 5.2  xml实现: 复合动画
     * <set>
     */
    public void startXmlAnimationSet(View v) {
        tv_animation_msg.setText("Xml复合动画: 透明度从透明到不透明, 持续2s, 接着进行旋转360度的动画, 持续2s");
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
        iv_animation.startAnimation(animation);
    }

    /*
     * 6. 测试动画监听
     */
    public void testAnimationListener(View v) {
        tv_animation_msg.setText("测试动画监听");


        //透明度动画
        AlphaAnimation aa = new AlphaAnimation(0,1.0f);
        //持续2s
        aa.setDuration(2000);


        RotateAnimation ra = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        //持续1秒执行
        ra.setDuration(2000);
        //动画延迟两秒执行
        ra.setStartOffset(0);

        ScaleAnimation sa = new ScaleAnimation(0,1.0f,0,1.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        sa.setDuration(2000);


        //动画集合-shareInterpolator:是否使用窜改器
        AnimationSet set = new AnimationSet(false);

        //添加动画
        set.addAnimation(ra);
        set.addAnimation(aa);
        set.addAnimation(sa);

        //播放动画
        iv_animation.startAnimation(set);
        //动画集合设置重复不起作用
        set.setRepeatCount(3);

        //监听动画播放完成
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.e("TAG","onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation ){
                Log.e("TAG","onAnimationEnd");
                Toast.makeText(TestViewAnimationActivity.this, "动画播放完成", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.e("TAG","onAnimationRepeat");
            }
        });

    }
}
