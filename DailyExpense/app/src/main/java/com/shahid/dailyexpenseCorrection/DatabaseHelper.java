package com.shahid.dailyexpenseCorrection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.sql.Time;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "Expense.db";
    public static String TABLE_NAME = "Expense";
    public static String COL_ID = "Id";
    public static String COL_AMOUNT = "Amount";
    public static String COL_DATE ="Date";
    public static String COL_TIME = "Time";
    //public static String COL_TYPE = "Type";
    public static int VERSION = 1;
    public String CREATE_TABLE = "create table Expense(Id INTEGER primary key autoincrement,Amount TEXT,Date TEXT,Time TEXT,Type TEXT)";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertData(String amount, String date,String time){

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_AMOUNT,amount);
        contentValues.put(COL_DATE,date);
        contentValues.put(COL_TIME,time);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        long id = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return id;

    }



    public Cursor showData(){

        String show_all = "Select * From "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(show_all,null);
        return cursor;
    }

    public boolean updateData(String id,String amount,String date,String time,String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID,id);
        contentValues.put(COL_AMOUNT,amount);
        contentValues.put(COL_DATE,date);
        contentValues.put(COL_TIME,time);
        db.update(TABLE_NAME, contentValues, "Id = ?",new String[] { id });
        return true;
    }

    public Integer deleteData(int id){
        SQLiteDatabase db = this.getWritableDatabase();

       return db.delete(TABLE_NAME, "Id=?", new String[]{String.valueOf(id)});


    }
}
