package xueweu.atguigu.appnews.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 作者：杨光福 on 2017/4/21 10:22
 * QQ：541433511
 * 微信：yangguangfu520
 * 作用：
 */

public class DBHelper extends SQLiteOpenHelper {
    /**
     *
     * @param context 构建数据时的上下文
     * @param name 数据库的名称
     * @param factory 游标工厂
     * @param version 数据的版本号
     */
    public DBHelper(Context context, int version) {
        //创建数据库
        super(context, "atguigu.db", null, version);
        Log.e("TAG","DBHelper构造方法");
    }

    /**
     * 当数据库创建成功的时候会回调该方法
     * 适合创建表
     * @param db 数据库连接对象
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("TAG","onCreate");
        //创建表
        db.execSQL("create table user(_id integer primary key autoincrement,name varchar,money double)");
        //插入两条数据
        db.execSQL("insert into user(name,money) values('Tom',1000)");
        db.execSQL("insert into user(name,money) values('Jerry',1000)");

    }

    /**
     * 当数据库升级的时候回调该方法
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("TAG","onUpgrade--oldVersion=="+oldVersion+",newVersion=="+newVersion);
        db.execSQL("create table pserson1(_id integer primary key autoincrement,name varchar)");
    }
}
