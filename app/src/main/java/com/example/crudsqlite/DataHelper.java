package com.example.crudsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "matakuliah.db"; private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    //TODO Auto-generate method stub
        String sql = "create table matakuliah(no integer primary key,kode text null,nama text null,sks integer null,dosen text null);";
        Log.d("Data","onCreate: " + sql); db.execSQL(sql);
        sql = "INSERT INTO matakuliah (no,kode,nama,sks,dosen) VALUES ('1','IF22613003','Pengantar Deep Learning','3','I Dewa Made Bayu Atmaja Darmawan,S.Kom.,M.Cs.');"; db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
    //TODO Auto-generated method stub
    }
}
