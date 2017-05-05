package xueweu.atguigu.appnews.activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import xueweu.atguigu.appnews.R;

public class ExternalFileSaveActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_file_save);
        //初始化视图
        et_name = (EditText) findViewById(R.id.et_name);
        et_content = (EditText) findViewById(R.id.et_content);
    }

    /**
     * 保存文本到/storage/sdcard/Android/data/包名/files目录
     *
     * @param v
     */
    public void save1(View v) {

        //得到文件名称和要保存的内容
        String name = et_name.getText().toString().trim();
        String content = et_content.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(content)) {
            Toast.makeText(ExternalFileSaveActivity.this, "文件名和内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        //1.判断手机sdcard是否挂载
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            FileOutputStream fos = null;
            try {
                //2.得到要保存的路径
                //storage/sdcard/Android/data/包名/files
                File externalFilesDir = getExternalFilesDir(null);
                //storage/sdcard/Android/data/包名/files/xxx.txt
                File file = new File(externalFilesDir, name);
                //3.写入文本

                fos = new FileOutputStream(file);
                fos.write(content.getBytes("UTF-8"));

                //保存成功
                Toast.makeText(this,"保存成功",Toast.LENGTH_LONG).show();
                et_name.setText("");
                et_content.setText("");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //4.关流
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        } else {
            Toast.makeText(ExternalFileSaveActivity.this, "当前sdcard还没有挂载好", Toast.LENGTH_SHORT).show();
        }


    }

    /**
     * 从/storage/sdcard/Android/data/包名/files目录读取文本内容
     *
     * @param v
     */
    public void read1(View v) {
        //得到文件名称
        String name = et_name.getText().toString().trim();
        //1.判断sdcard是否挂载好
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            //得到的文件的路径
            ///storage/sdcard/Android/data/包名/files
            File externalFilesDir = getExternalFilesDir(null);
            File file = new File(externalFilesDir, name);

            if (file.exists()) {

                //2.用相应的输入流读取数据
                FileInputStream fis = null;
                ByteArrayOutputStream baos = null;
                try {
                    fis = new FileInputStream(file);
                    byte[] buffer = new byte[1024];//数据到这里来
                    //解决乱码问题
                    baos = new ByteArrayOutputStream();//存放所有数据
                    int length;
                    while ((length = fis.read(buffer)) != -1) {
                        baos.write(buffer, 0, length);
                    }

                    String content = baos.toString();
                    //4.把读取的内容显示出来
                    //设置到EditText
                    et_content.setText(content);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //3.关流
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (baos != null) {
                        try {
                            baos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


            } else {
                Toast.makeText(ExternalFileSaveActivity.this, "该文件不存在", Toast.LENGTH_SHORT).show();
            }


        } else {
            Toast.makeText(ExternalFileSaveActivity.this, "sdcard没有挂载好", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 保存文本到/storage/sdcard/xxx目录
     *
     * @param v
     */
    public void save2(View v) {


        //得到文件名称和要保存的内容
        String name = et_name.getText().toString().trim();
        String content = et_content.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(content)) {
            Toast.makeText(ExternalFileSaveActivity.this, "文件名和内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        //1.判断手机sdcard是否挂载
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            FileOutputStream fos = null;
            try {
                //2.得到要保存的路径
                //storage/sdcard/atguigu/test
                String externalFilesDir = Environment.getExternalStorageDirectory()+"/atguigu/test";
                //创建该目录storage/sdcard/xxx/test
                File filesDir = new File(externalFilesDir);
                if(!filesDir.exists()){
                    filesDir.mkdirs();//创建多个目录
                }
                //storage/sdcard/atguigu/test/xxx.xx
                File file = new File(externalFilesDir, name);
                //3.写入文本

                fos = new FileOutputStream(file);
                fos.write(content.getBytes("UTF-8"));

                //保存成功
                Toast.makeText(this,"保存成功",Toast.LENGTH_LONG).show();
                et_name.setText("");
                et_content.setText("");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //4.关流
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        } else {
            Toast.makeText(ExternalFileSaveActivity.this, "当前sdcard还没有挂载好", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 从storage/sdcard/xxx目录读取文本内容
     *
     * @param v
     */
    public void read2(View v) {

        //得到文件名称
        String name = et_name.getText().toString().trim();
        //1.判断sdcard是否挂载好
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            //2.得到要保存的路径
            //storage/sdcard/atguigu/test
            String externalFilesDir = Environment.getExternalStorageDirectory()+"/atguigu/test";
            //创建该目录storage/sdcard/xxx/test

            //storage/sdcard/atguigu/test/xxx.xx
            File file = new File(externalFilesDir, name);

            if (file.exists()) {

                //2.用相应的输入流读取数据
                FileInputStream fis = null;
                ByteArrayOutputStream baos = null;
                try {
                    fis = new FileInputStream(file);
                    byte[] buffer = new byte[1024];//数据到这里来
                    //解决乱码问题
                    baos = new ByteArrayOutputStream();//存放所有数据
                    int length;
                    while ((length = fis.read(buffer)) != -1) {
                        baos.write(buffer, 0, length);
                    }

                    String content = baos.toString();
                    //4.把读取的内容显示出来
                    //设置到EditText
                    et_content.setText(content);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //3.关流
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (baos != null) {
                        try {
                            baos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


            } else {
                Toast.makeText(ExternalFileSaveActivity.this, "该文件不存在", Toast.LENGTH_SHORT).show();
            }


        } else {
            Toast.makeText(ExternalFileSaveActivity.this, "sdcard没有挂载好", Toast.LENGTH_SHORT).show();
        }


    }
}
