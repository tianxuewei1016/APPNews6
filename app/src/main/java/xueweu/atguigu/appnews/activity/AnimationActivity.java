package xueweu.atguigu.appnews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import xueweu.atguigu.appnews.R;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
    }
    /**
     * Test View Animation
     * @param v
     */
    public void viewAnimation(View v) {
        startActivity(new Intent(this,TestViewAnimationActivity.class));

    }
}
