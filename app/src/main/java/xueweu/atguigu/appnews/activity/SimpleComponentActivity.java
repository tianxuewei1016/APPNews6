package xueweu.atguigu.appnews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import xueweu.atguigu.appnews.R;

public class SimpleComponentActivity extends AppCompatActivity {

    //类的成员变量
    private TextView tv_simple_title;
    private EditText et_simple_password;
    private Button btn_simple_commit;

    private ImageView iv_simple_play;

    private CheckBox cb_simple_football;
    private CheckBox cb_simple_basketball;
    private CheckBox cb_simple_pingpong;

    private RadioGroup rg_simple_blood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //把整个布局加载到Activity里面
        setContentView(R.layout.activity_simple_component);//TextView被初始化了
        //1.TextView-初始化
        tv_simple_title = (TextView) findViewById(R.id.tv_simple_title);

        //休眠2000
//        SystemClock.sleep(2000);
        //用代码设置文本

        //用代码设置文字大小
        tv_simple_title.setTextSize(24);
        tv_simple_title.setText("窈窕淑女，君子好逑！");

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                tv_simple_title.setText("窈窕淑女，君子好逑！");
//            }
//        }, 2000);

        //2.EditText
        et_simple_password = (EditText) findViewById(R.id.et_simple_password);
//        et_simple_password.setText("我是一个兵");

//        String i = "你好";//局部变量/当onCreate方法执行后，被回收
//
//        final String string = et_simple_password.getText().toString().trim();//局部变量--“”
        //3.Button
        btn_simple_commit = (Button) findViewById(R.id.btn_simple_commit);
        //设置点击事件
        btn_simple_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //重新修改
                String string = et_simple_password.getText().toString().trim();//从新获取
                Toast.makeText(SimpleComponentActivity.this, string, Toast.LENGTH_SHORT).show();

            }
        });



        //4.ImageView
        iv_simple_play = (ImageView) findViewById(R.id.iv_simple_play);
        //设置点击事件
        iv_simple_play.setOnClickListener(new View.OnClickListener() {
            /**
             * true:播放图片
             * false:暂停图片
             */
            boolean isPlay = true;

            @Override
            public void onClick(View v) {
//                Toast.makeText(SimpleComponentActivity.this, "点击事件", Toast.LENGTH_SHORT).show();
                if (isPlay) {//当前状态播放
                    //设置暂时
                    //1.设置前景图片
                    iv_simple_play.setImageResource(android.R.drawable.ic_media_pause);
                    //2.设置背景图片
                    iv_simple_play.setBackgroundResource(android.R.drawable.alert_light_frame);
                    isPlay = false;
                } else {
                    //设置播放状态
                    //前景图片-播放效果
                    iv_simple_play.setImageResource(android.R.drawable.ic_media_play);

                    //背景图片-播放时候的
                    iv_simple_play.setBackgroundResource(android.R.drawable.alert_dark_frame);
                    isPlay = true;
                }
            }
        });


        //5.CheckBox
        cb_simple_football = (CheckBox) findViewById(R.id.cb_simple_football);
        cb_simple_basketball = (CheckBox) findViewById(R.id.cb_simple_basketball);
        cb_simple_pingpong = (CheckBox) findViewById(R.id.cb_simple_pingpong);
        //设置是否被勾选
        cb_simple_football.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(SimpleComponentActivity.this, "已经勾选足球", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SimpleComponentActivity.this, "取消勾选足球", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //6.RadioGroup 和RadioButton
        rg_simple_blood = (RadioGroup) findViewById(R.id.rg_simple_blood);

        //设置是否勾选状态变化的监听
        rg_simple_blood.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //第一种方式：使用Activity的方法
//                RadioButton button = (RadioButton) findViewById(checkedId);

                //第二种方式：
                RadioButton button = (RadioButton) group.findViewById(checkedId);
                String conent = button.getText().toString().trim();
                Toast.makeText(SimpleComponentActivity.this, conent, Toast.LENGTH_SHORT).show();
            }
        });

    }


    /**
     * 提交爱好
     *
     * @param view
     */
    public void commitHobby(View view) {
        String hobby = " ";
        //CheckBox是否被选中
        if (cb_simple_football.isChecked()) {
            hobby += cb_simple_football.getText().toString() + " ";
        }

        if (cb_simple_basketball.isChecked()) {
            hobby += cb_simple_basketball.getText().toString() + " ";
        }


        if (cb_simple_pingpong.isChecked()) {
            hobby += cb_simple_pingpong.getText().toString() + " ";
        }

        if (hobby.length() == 1) {
            Toast.makeText(this, "您还没有勾选任何爱好", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, hobby, Toast.LENGTH_SHORT).show();
        }


    }


}
