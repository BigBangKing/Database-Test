
package com.blogspot.itechcream.databasetest;
/*
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

*/
/**
 * Created by RAM on 2/26/2017.
 */
public class ListViewActivity {
/*
    SQLiteHelper SQLITEHELPER;
    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;
    SQLiteListAdapter ListAdapter ;

    ArrayList<String> ID_ArrayList = new ArrayList<String>();
    ArrayList<String> NAME_ArrayList = new ArrayList<String>();
    ArrayList<String> PHONE_NUMBER_ArrayList = new ArrayList<String>();
    ArrayList<String> SUBJECT_ArrayList = new ArrayList<String>();
    ListView LISTVIEW;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        LISTVIEW = (ListView) findViewById(R.id.listView1);

        SQLITEHELPER = new SQLiteHelper(this);
*/

/*
    }

    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

//        SQLITEDATABASE = SQLITEHELPER.getWritableDatabase();

        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM demoTable", null);

        ID_ArrayList.clear();
        NAME_ArrayList.clear();
        PHONE_NUMBER_ArrayList.clear();
        SUBJECT_ArrayList.clear();
*/
/*

        if (cursor.moveToFirst()) {
            do {
                ID_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_ID)));

                NAME_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_Name)));

                PHONE_NUMBER_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_PhoneNumber)));

                SUBJECT_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_Subject)));

            } while (cursor.moveToNext());
        }

        ListAdapter = new SQLiteListAdapter(ListViewActivity.this,

                ID_ArrayList,
                NAME_ArrayList,
*/
/*                PHONE_NUMBER_ArrayList,
                SUBJECT_ArrayList

        );

        LISTVIEW.setAdapter(ListAdapter);

        cursor.close();
*
    }*/
}