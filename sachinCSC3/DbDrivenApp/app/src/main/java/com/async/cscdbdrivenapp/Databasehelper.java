package com.async.cscdbdrivenapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pc77 on 16/5/18.
 */

class Databasehelper extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME = "stdb";
    public static final String TABLE_NAME = "stud";
    public static final String col_1 = "name";
    public static final String col_2 = "last";
    public static final String col_3 ="course";

    public Databasehelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+"(NAME TEXT,LAST TEXT,COURSE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean insertData(String name,String last,String  course){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,name);
        contentValues.put(col_2,last);
        contentValues.put(col_3,course);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
