package xueweu.atguigu.appnews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import xueweu.atguigu.appnews.R;

public class ComponentActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_main_test1;
    private Button btn_main_test2;
    private Button btn_main_test3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);

        //初始化控件
        btn_main_test1 = (Button) findViewById(R.id.btn_main_test1);
        btn_main_test2 = (Button) findViewById(R.id.btn_main_test2);
        btn_main_test3 = (Button) findViewById(R.id.btn_main_test3);

        //设置点击事件
        btn_main_test1.setOnClickListener(this);
        btn_main_test2.setOnClickListener(this);
        btn_main_test3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btn_main_test1){
//            Toast.makeText(this, "btn_main_test1", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,SimpleComponentActivity.class));
        }else if(v==btn_main_test2){
//            Toast.makeText(this, "btn_main_test2", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,ProgressActivity.class));
        }else if(v==btn_main_test3){
//            Toast.makeText(this, "btn_main_test3", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,DialogActivity.class));

        }
    }
}
