package com.sked.androidbasics.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sked.androidbasics.database.Table;

/**
 * Created by manish on 10/21/2015.
 */
public class DataBase extends SQLiteOpenHelper {
    public static String DB = "androidbasics.db";
    public static int version = 1;

    public DataBase(Context context) {
        super(context, DB, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Table.User.CREATE_TABLE);
        //Creating the new table
        db.execSQL(Table.Credential.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}

