package xueweu.atguigu.appnews.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import xueweu.atguigu.appnews.R;

public class SharedPreferenceActivity extends AppCompatActivity {

    private EditText et_key;
    private EditText et_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activity_shared_preference);
        //初始化控件
        et_key = (EditText)findViewById(R.id.et_key);
        et_value = (EditText)findViewById(R.id.et_value);



    }



    /**
     * 保存数据
     *
     * @param view
     */
    public void save(View view) {
        //1.得到SharedPreferences
        SharedPreferences sp = getSharedPreferences("atguigu", MODE_PRIVATE);
        //2.得到编辑器
        SharedPreferences.Editor edit = sp.edit();

        //key
        String key = et_key.getText().toString().trim();
        String value = et_value.getText().toString().trim();
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            Toast.makeText(this, "key和value不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        //3.putXXX
        edit.putString(key, value);
        //4.提交
        edit.commit();

        //把输入框内容清空
        et_key.setText("");
        et_value.setText("");

        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();

    }

    /**
     * 读取数据
     *
     * @param view
     */
    public void read(View view) {
        //1.得到SharedPreferences
        SharedPreferences sp = getSharedPreferences("atguigu",MODE_PRIVATE);

        //key:从文本输入框或者key
        String key = et_key.getText().toString().trim();
        //2.直接获取数据
        String value = sp.getString(key,"no data");

        Toast.makeText(this, "得到内容="+value, Toast.LENGTH_SHORT).show();
        et_value.setText(value);


    }
}
