package xueweu.atguigu.appnews.activity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import xueweu.atguigu.appnews.R;

public class InternalFileSaveActivity extends AppCompatActivity {

    private ImageView iv_if;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_file_save);
        //1.初始化控件
        iv_if = (ImageView) findViewById(R.id.iv_if);
    }

//    /**
//     * 保存图片
//     * 从assets目录下的图片以流的方式读取到内存中；
//     * 把内存中的图片保存到手机内部（data/data/包名/files）
//     *
//     * @param v
//     */
//    public void save(View v) {
//        FileOutputStream fos = null;
//        InputStream is = null;
//        try {
//            //1.得到AssetsMange
//            AssetManager assets = getAssets();
//            is = assets.open("atguigu.png");
//
//            //2.以某种流把图片往外写数据
//            File filesDir = getFilesDir();//data/data/包名/files
//            //data/data/包名/files/test1.png
//            File file = new File(filesDir, "test1.png");
//            // //data/data/包名/files/test1.png
//            fos = new FileOutputStream(file);//把流输出到
//
//            //循环写数据-从内存保存到手机内部
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = is.read(buffer)) != -1) {
//                fos.write(buffer, 0, length);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fos != null) {
//                try {
//                    fos.flush();
//                    //3.关流
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//
//    }
//
//    /**
//     * 从手机内部（data/data/包名/files）读取图片并且显示
//     *
//     * @param v
//     */
//    public void read(View v) {
//
//        //1.得到手机内存-图片所存储的绝对位置
//        //data/data/包名/files
//        File filesDir = getFilesDir();
//        //data/data/包名/files/test1.png
//        File file = new File(filesDir, "test1.png");
//        //判断文件是否存在
//        if (file.exists()) {
//            //2.使用BitmapFactory获取Bitmap
//            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//            //3.把Bitmap设置ImageView上，就可以显示
//            iv_if.setImageBitmap(bitmap);
//        } else {
//            Toast.makeText(InternalFileSaveActivity.this, "图片文件不存在", Toast.LENGTH_SHORT).show();
//        }
//
//
//    }


    /**
     * 保存图片
     * 从assets目录下的图片以流的方式读取到内存中；
     * 把内存中的图片保存到手机内部（data/data/包名/files）
     *
     * @param v
     */
    public void save(View v) {
        FileOutputStream fos = null;
        InputStream is = null;
        try {
            //1.得到AssetsMange
            AssetManager assets = getAssets();
            is = assets.open("atguigu.png");

            //2.以某种流把图片往外写数据
            // //data/data/包名/files/test2.png
            fos = openFileOutput("test2.png",MODE_PRIVATE);//把流输出到
            //循环写数据-从内存保存到手机内部
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.flush();
                    //3.关流
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 从手机内部（data/data/包名/files）读取图片并且显示
     *
     * @param v
     */
    public void read(View v) {

        //1.得到手机内存-图片所存储的绝对位置
        FileInputStream fis = null;
        try {
            //data/data/包名/files/test1.png
            fis = openFileInput("test1.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //判断文件是否存在
        //2.使用BitmapFactory获取Bitmap
//            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        //参数：输入流
        Bitmap bitmap =  BitmapFactory.decodeStream(fis);
        //3.把Bitmap设置ImageView上，就可以显示
        iv_if.setImageBitmap(bitmap);


    }


}
