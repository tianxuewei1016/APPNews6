package xueweu.atguigu.appnews.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import xueweu.atguigu.appnews.R;

public class PhoneActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private EditText et_call_number;
    private EditText et_sms_content;
    private Button btn_call_phone;
    private Button btn_send_sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        //初始化控件
        et_call_number = (EditText) findViewById(R.id.et_call_number);
        et_sms_content = (EditText) findViewById(R.id.et_sms_content);
        btn_call_phone = (Button) findViewById(R.id.btn_call_phone);
        btn_send_sms = (Button) findViewById(R.id.btn_send_sms);

        //设置点击事件
        btn_call_phone.setOnClickListener(this);
        btn_send_sms.setOnClickListener(this);

        //设置长按事件
        btn_call_phone.setOnLongClickListener(this);
        btn_send_sms.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btn_call_phone){
            Toast.makeText(PhoneActivity.this, "拨打电话-进入拨号器", Toast.LENGTH_SHORT).show();

            //拨打电话-隐式意图
            //第一种写法：
//                Intent intent = new Intent(Intent.ACTION_DIAL);
            Intent intent = new Intent("android.intent.action.DIAL");//参数是动作
            //从输入框得到电话号码
            String number = et_call_number.getText().toString().trim();
            Uri uri = Uri.parse("tel:"+number);
            //设置数据
            intent.setData(uri);
            startActivity(intent);

        }else if(v==btn_send_sms){
            Toast.makeText(PhoneActivity.this, "发短信-编辑页面", Toast.LENGTH_SHORT).show();

            //隐式意图
            Intent intent = new Intent(Intent.ACTION_SENDTO);

            //得到电话号码
            String number = et_call_number.getText().toString().trim();
            //转换成uri
            Uri uri = Uri.parse("smsto:"+number);
            //携带数据
            intent.setData(uri);
            //短信的内容
            String smsContent = et_sms_content.getText().toString().trim();
            intent.putExtra("sms_body",smsContent);
            //启动Activity
            startActivity(intent);
        }
    }


    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.btn_call_phone:
                Toast.makeText(this, "直接拨打电话", Toast.LENGTH_SHORT).show();
                //拨打电话-隐式意图
                //第一种写法：
//                Intent intent = new Intent(Intent.ACTION_CALL);
                Intent intent = new Intent("android.intent.action.CALL");//参数是动作
                //从输入框得到电话号码
                String number = et_call_number.getText().toString().trim();
                Uri uri = Uri.parse("tel:"+number);
                //设置数据
                intent.setData(uri);
                startActivity(intent);

                break;
            case R.id.btn_send_sms:

                SmsManager smsManager = SmsManager.getDefault();
                //发短信
                String phoneNumber = et_call_number.getText().toString().trim();
                //短信内容
                String smsContent = et_sms_content.getText().toString().trim();
                /**
                 * 第一参数：是要发到短信的电话号码
                 * 第三个参数：短信内容
                 */
                smsManager.sendTextMessage(phoneNumber,null,smsContent,null,null);

                //加上权限
                Toast.makeText(this, "发短信成功！", Toast.LENGTH_SHORT).show();
                finish();

                break;
        }
        return true;//对事件进行消费，没有事件了
    }
}
