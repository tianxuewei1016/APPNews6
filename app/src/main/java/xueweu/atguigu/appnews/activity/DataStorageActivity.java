package xueweu.atguigu.appnews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import xueweu.atguigu.appnews.R;

public class DataStorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
    }

    /**
     * SharedPreference存储
     *
     * @param view
     */
    public void onClickSP(View view) {
        startActivity(new Intent(this,SharedPreferenceActivity.class));

    }
    /**
     * 内部文件存储
     *
     * @param view
     */
    public void onClickIF(View view) {
        startActivity(new Intent(this,InternalFileSaveActivity.class));
    }


    /**
     * 外部文件存储
     * @param view
     */
    public void onClickOF(View view) {
        startActivity(new Intent(this,ExternalFileSaveActivity.class));
    }

    /**
     * 数据库存储
     * @param view
     */
    public void onClickDB(View view){
        startActivity(new Intent(this,DatabaseSaveActivity.class));
    }

}
