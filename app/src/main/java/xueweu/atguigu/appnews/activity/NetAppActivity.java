package xueweu.atguigu.appnews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import xueweu.atguigu.appnews.R;

public class NetAppActivity extends AppCompatActivity implements View.OnTouchListener{

    private ImageView iv_logo;
    private LinearLayout ll_parent;

    /**
     * 视图View在屏幕上显示主要经历的步骤
     * 测量 measue 要得到孩子的大小
     * 布局 layou 指定孩子在布局里面的位置
     * 绘制 绘制 绘制出来
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_app);
        iv_logo = (ImageView) findViewById(R.id.iv_logo);

        //从子视图得到父视图
        ll_parent = (LinearLayout) iv_logo.getParent();
        //设置监听ImageView的触摸事件
        iv_logo.setOnTouchListener(this);




    }

    /**
     * 记录按下时候的坐标
     */
    private int preX;
    private int preY;
    //距离右边最大距离
    private int maxRight;
    //距离底部最大距离
    private int maxBottom;
    /**
     * 触摸事件
     *
     * @param v
     * @param event
     * @return
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //新的坐标
        int eventX = (int) event.getRawX();
        int eventY = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://手指按下
                Log.e("TAG", "ACTION_DOWN");
                //记录按下的坐标
                preX = eventX;
                preY = eventY;
                //当控件看得见的时候，视图里面的高或者宽或者相关参数是有值
                if(maxRight ==0){
                    maxRight = ll_parent.getRight();
                    maxBottom = ll_parent.getBottom();
                    Log.e("TAG",maxRight+"");
                    Log.e("TAG",maxBottom+"");
                }

                break;
            case MotionEvent.ACTION_MOVE://手指在屏幕移动
                Log.e("TAG", "ACTION_MOVE");
                //移动的距离
                int dX = eventX - preX;
                int dY = eventY - preY;

                //X坐标
                int left = iv_logo.getLeft() + dX;
                int right = iv_logo.getRight() + dX;
                //Y 坐标
                int top = iv_logo.getTop() + dY;
                int bottom = iv_logo.getBottom() + dY;

                //left限制
                if(left < 0){
//                    right = right - left;
                    right -= left;
                    left = 0;
                }

                //top限制
                if(top < 0){
                    bottom -= top;
                    top = 0;
                }


                //限制right
                if(right > maxRight){
                    left -= (right - maxRight);
                    right = maxRight;
                }


                //限制bottom
                if(bottom > maxBottom){
                    top -= (bottom - maxBottom);
                    bottom = maxBottom;
                }

                //设置参数到layou方法中，让视图重新在布局的
                iv_logo.layout(left,top,right,bottom);

                //不要忘记
                preX = eventX;
                preY = eventY;

                break;
            case MotionEvent.ACTION_UP://手指离开屏幕
                Log.e("TAG", "ACTION_UP");
                break;

        }

        return true;
    }
}
