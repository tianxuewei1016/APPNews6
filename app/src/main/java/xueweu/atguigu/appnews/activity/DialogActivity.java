package xueweu.atguigu.appnews.activity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import xueweu.atguigu.appnews.R;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dialog);
    }

    /**
     * 显示一般AlertDialog
     *
     * @param v
     */
    public void showAD(View v) {
        //第一种写法：
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        //设置标题
//        builder.setTitle("删除数据");
//        //设置内容
//        builder.setMessage("你确定要删除数据吗？");
//        //设置左边按钮
//        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(DialogActivity.this, "取消删除", Toast.LENGTH_SHORT).show();
//            }
//        });
//        //设置右边按钮
//        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(DialogActivity.this, "确定删除", Toast.LENGTH_SHORT).show();
//            }
//        });
//       //显示
//        builder.show();


        //第二种写法：链式写法--只要对话框都用这种

        new AlertDialog.Builder(this).setTitle("删除数据吗").setMessage("是否删除数据").setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "取消删除", Toast.LENGTH_SHORT).show();
            }
        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "确定删除", Toast.LENGTH_SHORT).show();
            }
        }).show();


    }


    /**
     * 显示单选列表AlertDialog
     *
     * @param v
     */
    public void showLD(View v) {
        //第二种写法：链式写法--只要对话框都用这种
        final String[] colors = {"红", "黄", "蓝", "绿"};
        new android.support.v7.app.AlertDialog.Builder(this).setTitle("指定背景颜色")
                .setSingleChoiceItems(colors, 2, new DialogInterface.OnClickListener() {
                    /**
                     *
                     * @param dialog AlerDialog自身
                     * @param which 点击的位置：0开始
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //1.取消
                        dialog.dismiss();
                        //2.得到选中的内容
                        Toast.makeText(DialogActivity.this, colors[which], Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }


    /**
     * 显示自定义AlertDialog
     *
     * @param v
     */
    public void showCD(View v) {
//        //创建Builder
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//
//
//        /**
//         * 第一种写法：
//         * 第一参数：上下文
//         * 第二参数：布局文件
//         * 第三个参数：要把当前布局添加到那个视图
//         */
//        final View customView = View.inflate(this,R.layout.dialog_login,null);
//        builder.setView(customView);
//
//
//        //第二种写法
////        LayoutInflater inflater = getLayoutInflater();
////        builder.setView(inflater.inflate(R.layout.dialog_login,null));
//
//        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//                Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//
//                //初始化控件
//                EditText et_login_name = (EditText) customView.findViewById(R.id.et_login_name);
//                EditText et_login_password = (EditText) customView.findViewById(R.id.et_login_password);
//
//                //得到账号和密码
//                String name = et_login_name.getText().toString();
//                String password = et_login_password.getText().toString();
//
//                Toast.makeText(DialogActivity.this, name+","+password, Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//
//        builder.show();

        final View customView = View.inflate(this, R.layout.dialog_login, null);
        //setView:设置视图
        new AlertDialog.Builder(this).setView(customView)
                .setNegativeButton(R.string.cancle, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(DialogActivity.this, getString(R.string.cancle), Toast.LENGTH_SHORT).show();
                    }
                }).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //初始控件
                EditText et_login_name = (EditText) customView.findViewById(R.id.et_login_name);
                EditText et_login_password = (EditText) customView.findViewById(R.id.et_login_password);
                //得到内容
                String name = et_login_name.getText().toString();
                String password = et_login_password.getText().toString();
                Toast.makeText(DialogActivity.this, name + "," + password, Toast.LENGTH_SHORT).show();
            }
        }).show();


    }


    /**
     * 显示圆形进度ProgressDialog
     *
     * @param v
     */
    public void showPD(View v) {
        final ProgressDialog dialog = ProgressDialog.show(this, "数据加载", "数据加载中...");
        Log.e("TAG", Thread.currentThread().getName());

        //不能直接在主线中休眠
        //SystemClock.sleep(2000);
        //第一种创建线程的方式
        new Thread() {
            @Override
            public void run() {
                super.run();
                //两秒后隐藏对话框
                SystemClock.sleep(2000);
                //取消显示
                dialog.dismiss();
            }
        }.start();

        //第二种创建线程的方式
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();


    }


    /**
     * 显示水平进度ProgressDialog
     *
     * @param v
     */
    public void showPD2(View v) {

        final ProgressDialog dialog = new ProgressDialog(DialogActivity.this);
        //设置水平样式
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //显示
        dialog.show();

        final int appCoun = 50;
        dialog.setMax(appCoun);


//        Toast.makeText(DialogActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
        //主线程
//        Log.e("TAG", "showPD2-start--" + Thread.currentThread().getName());
//
        new Thread(new Runnable() {
            @Override
            public void run() {


                Log.e("TAG", "Thread--run()--" + Thread.currentThread().getName());

                //执行for循环
                for (int i = 0; i < appCoun; i++) {
                    //设置进度
                    dialog.setProgress(i + 1);//进度跟新
                    SystemClock.sleep(50);
                }


                //把对话框消掉
                dialog.dismiss();


                //跟新UI界面或者更新页面一定要在主线程中
                //在子线程不能更新UI
                //Android4.0后，如果在主线请求网络，直接报错。
                //在主线程不能做耗时的操作
                //在这里提示，才是真正下载完成---子线程


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("TAG", "Thread--run()--runOnUiThread_" + Thread.currentThread().getName());
                        //主线程
                        Toast.makeText(DialogActivity.this, "下载完成", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        }).start();


        //主线程
        Log.e("TAG", "showPD2-end--" + Thread.currentThread().getName());


    }


    /**
     * 显示DatePickerDialog
     *
     * @param v
     */
    public void showDateAD(View v) {
        //得到当前Android系统时间
        Calendar instance = Calendar.getInstance();
        //得到年
        int year = instance.get(Calendar.YEAR);
        //得到月
        int month = instance.get(Calendar.MONTH);
        //得到日
        int day = instance.get(Calendar.DAY_OF_MONTH);
        //输入默认日期
        Log.e("TAG", "year==" + year + ",month==" + (month + 1) + ",day==" + day);

        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            //当点击确定的时候，回调该方法，并且发设置的日期回传
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.e("TAG", "year==" + year + ",month==" + (month + 1) + ",dayOfMonth==" + dayOfMonth);
            }
        }, year, month, day).show();

    }


    /**
     * 显示TimePickerDialog
     *
     * @param v
     */
    public void showTimeAD(View v) {
        Calendar instance = Calendar.getInstance();
        //小时
        int hourOfDay = instance.get(Calendar.HOUR_OF_DAY);
        //分
        int minute = instance.get(Calendar.MINUTE);
        Log.e("TAG", "hourOfDay==" + hourOfDay + ",minute==" + minute);
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.e("TAG", "hourOfDay==" + hourOfDay + ",minute==" + minute);
            }
        }, hourOfDay, minute, true).show();


    }
}
