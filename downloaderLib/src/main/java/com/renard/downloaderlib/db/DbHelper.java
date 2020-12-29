package com.renard.downloaderlib.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

/**
 * Created by Riven_rabbit on 12/25/20
 *
 * @author suyanan
 */
public class DbHelper extends SQLiteOpenHelper {


    public static final String TABLE_NAME = "file_info";
    private static final String CREATE_TABLE = "create table file_info ( "
            + "id integer primary key autoincrement, "
            + "url text, "
            + "name text, "
            + "path text, "
            + "loadBytes integer, "
            + "totalBytes integer, "
            + "status integer)";
    private static final String DROP_TABLE = "drop table if exists file_info";


    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }
}
