package xueweu.atguigu.appnews.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import xueweu.atguigu.appnews.R;

public class DrawableActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView iv_da_mm;
    private Button btn_da_start;
    private Button btn_da_stop;
    private AnimationDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);

        iv_da_mm = (ImageView)findViewById(R.id.iv_da_mm);
        btn_da_start = (Button)findViewById(R.id.btn_da_start);
        btn_da_stop = (Button)findViewById(R.id.btn_da_stop);

        btn_da_start.setOnClickListener(this);
        btn_da_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_da_start:
                drawable= (AnimationDrawable) iv_da_mm.getBackground();
                drawable.start();
                break;
            case R.id.btn_da_stop:
                drawable.stop();
                break;
        }
    }
}
