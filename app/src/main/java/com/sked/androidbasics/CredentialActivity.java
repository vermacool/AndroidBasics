package com.sked.androidbasics;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.sked.androidbasics.database.DataBase;
import com.sked.androidbasics.database.Table;

import java.util.ArrayList;
import java.util.List;


public class CredentialActivity extends Activity {
    EditText email;
    EditText password;
    Button submit;
    DataBase db;
    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;
    List<String> userCredentials;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credential);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().contains("@")) {
                    email.setError("Email is not valid !");
                    return;
                }
                if (password.length() < 6) {
                    password.setError("Password Should must be of 6 characters!");
                    return;
                }

                insertData();
                email.setError(null);
                email.setText("");
                password.setError(null);
                password.setText("");
                select();
            }
        });
        ListView listView = (ListView) findViewById(R.id.listView);
        userCredentials = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userCredentials);
        listView.setAdapter(adapter);
        select();
        listView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

    }

    private void insertData() {
        db = new DataBase(this);
        sqLiteDatabase = db.getReadableDatabase();
        contentValues = new ContentValues();
        contentValues.put(Table.Credential.EMAIL, email.getText().toString());
        contentValues.put(Table.Credential.PASSWORD, password.getText().toString());
        sqLiteDatabase.insert(Table.Credential.TABLE_NAME, null, contentValues);

    }

    private void updateData() {
        db = new DataBase(this);
        sqLiteDatabase = db.getReadableDatabase();
        contentValues = new ContentValues();
        sqLiteDatabase.update(Table.Credential.TABLE_NAME, contentValues, Table.Credential.ID + " = ?", new String[]{"1"});

    }

    private void delete() {
        DataBase db = new DataBase(this);
        sqLiteDatabase = db.getReadableDatabase();

        sqLiteDatabase.delete(Table.Credential.TABLE_NAME, Table.Credential.ID + " = ?", new String[]{"1"});
    }

    private void select() {
        userCredentials.clear();
        db = new DataBase(this);
        sqLiteDatabase = db.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(Table.Credential.TABLE_NAME, null, null, null, null, null, Table.Credential.EMAIL + " ASC ");
        while (cursor.moveToNext()) {
            int indexOfEmail = cursor.getColumnIndex(Table.Credential.EMAIL);
            String emailValue = cursor.getString(indexOfEmail);
            int indexOfPassword = cursor.getColumnIndex(Table.Credential.PASSWORD);
            String passwordValue = cursor.getString(indexOfPassword);
            userCredentials.add(emailValue + " : " + passwordValue);
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_credential, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
