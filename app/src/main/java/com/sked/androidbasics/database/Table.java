package com.sked.androidbasics.database;


public class Table {

    public static class User {
        public static final String TABLE_NAME = "user";
        public static final String _ID = "_id",
                USER_NAME = "user_name",
                EMAIL = "email",
                ADDRESS = "address",
                MOBILE = "mobile";


        public static String CREATE_TABLE = "create table " + TABLE_NAME
                + " ( " + _ID + " integer  primary key autoincrement ,"
                + USER_NAME + " TEXT ,"
                + EMAIL + " TEXT ,"
                + ADDRESS + " TEXT ,"
                + MOBILE + " TEXT )";
    }

    public static class Credential {
        public static final String TABLE_NAME = "credential";
        public static final String ID = "id",
                EMAIL = "email",
                PASSWORD = "password";

        public static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + EMAIL + " TEXT ,"
                + PASSWORD + " TEXT )";


    }

}


