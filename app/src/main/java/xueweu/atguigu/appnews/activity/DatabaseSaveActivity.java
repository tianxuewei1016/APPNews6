package xueweu.atguigu.appnews.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import xueweu.atguigu.appnews.R;
import xueweu.atguigu.appnews.db.DBHelper;

public class DatabaseSaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_save);
    }

    /**
     * Create DB 创建数据库
     *
     * @param v
     */
    public void testCreateDB(View v) {
        //1.实例化SQLiteOpenHelper类
        DBHelper dbHelper = new DBHelper(this, 1);
        //2.连接数据库
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        //3.关闭数据库
        database.close();
    }

    /**
     * Update DB  数据库升级
     *
     * @param v
     */
    public void testUpdateDB(View v) {
        //1.实例化SQLiteOpenHelper类
        DBHelper dbHelper = new DBHelper(this, 3);
        //2.连接数据库
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        //3.关闭数据库
        database.close();

    }

    /**
     * Insert 插入数据
     *
     * @param v
     */
    public void testInsert(View v) {

        //1.实例化SQLiteOpenHelper类
        DBHelper dbHelper = new DBHelper(this, 2);
        //2.连接数据库
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        //3.方式一：使用Sql语句
//        database.execSQL("insert into user(name,money) values('atguigu',100000)");

        //方式二：使用Android提供的方法插入数据
        ContentValues values = new ContentValues();
        values.put("name", "zhangsan");
        values.put("money", "200");
        long id = database.insert("user", null, values);
        Log.e("TAG", "id==" + id);

        //4.关闭数据库
        database.close();
        Toast.makeText(DatabaseSaveActivity.this, "插入数据成功", Toast.LENGTH_SHORT).show();

    }

    /**
     * Delete 删除数据
     *
     * @param v
     */
    public void testDelete(View v) {
        //1.实例化SQLiteOpenHelper类
        DBHelper dbHelper = new DBHelper(this, 2);
        //2.连接数据库
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        //3.方式一：使用Sql语句
//        database.execSQL("delete from user where _id = 5");

        //方式二：使用Android提供的方法删除数据
//        int delete = database.delete("user", "_id=?", new String[]{"4"});
        int delete = database.delete("user", "_id>=4", null);//返回删除的条数

        //关闭数据库
        database.close();
        Toast.makeText(DatabaseSaveActivity.this, "删除数据成功==" + delete + "-条数据", Toast.LENGTH_SHORT).show();

    }

    /**
     * Update 更新数据
     *
     * @param v
     */
    public void testUpdate(View v) {
        //1.实例化SQLiteOpenHelper的实现类
        DBHelper dbHelper = new DBHelper(this, 3);

        //2.连接数据库
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        //3.使用sql语句更新数据
//        database.execSQL("update user set money = 50000 where _id = 1");

        //使用Android提供的api删除数据
        ContentValues values = new ContentValues();
        values.put("money", 50000);
        int updateCount = database.update("user", values, "_id >= ?", new String[]{"1"});
        Toast.makeText(DatabaseSaveActivity.this, "跟新了多少条数据==" + updateCount, Toast.LENGTH_SHORT).show();

        //关闭数据库
        database.close();

    }


    /**
     * query 查询数据
     *
     * @param view
     */
    public void testQuery(View view) {

        //1.实例化SQLiteOpenHelper的实现类
        DBHelper dbHelper = new DBHelper(this, 3);

        //2.连接数据库
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        //3.使用系统的API查询数据
        Cursor cursor = database.query("user", null, null, null, null, null, null);
        while (cursor.moveToNext()) {//1.判断是否有下一条数据；2.如果有下一条数据，光标移动到下一条的前面
//            int _id = cursor.getInt(0);
//            String name = cursor.getString(1);
//            double money = cursor.getDouble(2);

            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            double money = cursor.getDouble(cursor.getColumnIndex("money"));
            Log.e("TAG", "_id==" + _id + ",name==" + name + ",money==" + money);
        }


        //4.查询完成后记得关闭光标
        cursor.close();
        database.close();


    }

    /**
     * Test Transaction 事务
     *
     * @param v
    举例：Tom给jerry转账1000元。
    过程一：update user set money = money - 1000  where name = 'Tom'
    过程二：update user set money = money +1000  where name = 'Jerry'


     */
    public void testTransaction(View v) {
        //1.实例化SQLiteOpenHelper的实现类
        DBHelper dbHelper = new DBHelper(this, 3);
        SQLiteDatabase database = null;

        try {
            //2.连接数据库
            database = dbHelper.getReadableDatabase();
            //开启事务
            database.beginTransaction();

            //3.使用Sql语句执行
            database.execSQL("update user set money = money - 1000  where name = 'Tom'");
            //模拟转账的过程中出错了
//            String text = null;
//            text.toString();
            database.execSQL("update user set money = money +1000  where name = 'Jerry'");

            //执行成功-代表两个过程都执行成功
            database.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //1.如果两个过程都执行成功，提交数据；2.如果只指执行一个过程，事务回滚
            database.endTransaction();

            //4.关闭数据库
            database.close();
        }



    }

}
