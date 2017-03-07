package com.blogspot.itechcream.databasetest;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button, button2;
    ListView listView;
    ArrayList<String> arrayList;
    ArrayList<String> arrayList1;
    ArrayList<String> arrayList2;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBAdapter db = new DBAdapter(this);

        arrayList = new ArrayList<String>();
        arrayList1 = new ArrayList<String>();
        arrayList2 = new ArrayList<String>();

        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);

// Defined Array values to show in ListView
      /*  String[] values = new String[]{"Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"*//*
        };*/
/*
        adapter = (new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values));
        listView.setAdapter(adapter);*/
        listView.setTextFilterEnabled(true);


//        textView = (TextView) findViewById(R.id.text);
//---add a contact---
/*

        db.open();
        long id = db.insertContact("Wei-Meng Lee", "weimenglee@learn2develop.net");
        id = db.insertContact("Mary Jackson", "mary@jackson.com");
        db.close();
*/
        showAll(db);

        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = editText.getText().toString();
                    String x = editText2.getText().toString();

                    db.open();
                    db.insertContact(s, x);

                    db.close();

                    editText.setText("");
                    editText2.setText("");
                }
            });
        }
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAll(db);
            }
        });
    }

    private void showAll(DBAdapter db) {

        //---get all contacts---
        db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst()) {
            do {
                DisplayContact(c);
            } while (c.moveToNext());
        }
        db.close();

//        arrayList1.clear();

        adapter = (new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, arrayList2));
        listView.setAdapter(adapter);


    }

    public void DisplayContact(Cursor c) {

        String s = "id: " + c.getString(0) + "\n" +
                "Name: " + c.getString(1) + "\n" +
                "Email: " + c.getString(2);

        arrayList.add(c.getString(0));
        arrayList1.add(c.getString(1));
        arrayList2.add(c.getString(2));

        /*Toast.makeText(this,
                s,
                Toast.LENGTH_LONG).show();*/
//        String[] strings = s.toCharArray();
//        ArrayList arrayList = new ArrayList(Integer.parseInt(s));
//        textView.setText(s);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        /*searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        Toast.makeText(MainActivity.this, newText, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
        );
        */
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        searchView.setIconifiedByDefault(true);
//        searchView.

        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doSearch(query);
        }
    }

    private void doSearch(String query) {

        adapter.getFilter().filter(query);

        Toast.makeText(MainActivity.this,
                "Searching for: '"+query+"'",
                Toast.LENGTH_LONG).show();
    }

}



