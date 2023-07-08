package com.example.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.os.Bundle;

import java.util.Random;

public class LihatMatkul extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    TextView text1,text2,text3,text4,text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_matkul);
        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView4);
        text5 = (TextView) findViewById(R.id.textView5);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM matakuliah WHERE kode = '" + getIntent().getStringExtra("kode") + "'",null);
        cursor.moveToFirst();

        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0); text1.setText("No. "+cursor.getString(0).toString()); text2.setText(cursor.getString(1).toString()); text3.setText(cursor.getString(2).toString()); text4.setText(cursor.getString(3).toString()+" SKS"); text5.setText(cursor.getString(4).toString());
        }

        int[] images = {R.drawable.image1,R.drawable.image2};
        Random rand = new Random();
        ((ImageView)findViewById(R.id.imageKuliah)).setImageResource(images[rand.nextInt(images.length)]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu: this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}