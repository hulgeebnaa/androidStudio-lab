package com.example.lab3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydb.db";
    private static final String TABLE_NAME = "lab13";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ROWID = "id";
    private static final String KEY_INCOMEEXPENSE = "incomeexpense";
    private static final String KEY_BUDGETTYPE = "budgettype";
    private static final String KEY_BUDGETDESC = "budgetdesc";
    private static final String KEY_BUDGETVALUE = "budgetvalue";
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"(" +KEY_ROWID+ " integer primary key autoincrement, " + KEY_INCOMEEXPENSE + " varchar, "+ KEY_BUDGETTYPE + " varchar, "+ KEY_BUDGETDESC + " varchar, "+ KEY_BUDGETVALUE + " varchar)";
    private static final String DROP_TABLE = "drop table if exists " + TABLE_NAME;
    private Context context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        Toast.makeText(context, "constructor called",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            //String CreateTableSql = "CREATE TABLE Customer(Id INTEGER PRIMARY KEY, Name VARCHAR, Email VARCHAR, Address VARCHAR);";
            //db.execSQL(CreateTableSql);
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "oncreate called",Toast.LENGTH_LONG).show();
        }catch(SQLException e){
            Toast.makeText(context, ""+e,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Toast.makeText(context, "onUpdate called",Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch(SQLException e){
            Toast.makeText(context, ""+e,Toast.LENGTH_LONG).show();
        }
    }

    public boolean addData(String incomeexpense, String budgettype, String budgetdesc, String budgetvalue){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("incomeexpense" , incomeexpense);
        contentValues.put("budgettype" , budgettype);
        contentValues.put("budgetdesc" , budgetdesc);
        contentValues.put("budgetvalue" , budgetvalue);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1){
            return  false;
        }
        else{
            return true;
        }
    }

    public void update(String id,String incomeexpense, String budgettype, String budgetdesc, String budgetvalue){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + KEY_INCOMEEXPENSE + " = '" + incomeexpense + "', " + KEY_BUDGETTYPE +
                " = '" + budgettype + "', " + KEY_BUDGETDESC + " = '" + budgetdesc + "', " +KEY_BUDGETVALUE + " = '" + budgetvalue + "' WHERE " + KEY_ROWID + " = '" + id + "';";
        db.execSQL(query);
    }
    public void delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_ROWID + " = '" + id + "';";
        db.execSQL(query);
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }
}
