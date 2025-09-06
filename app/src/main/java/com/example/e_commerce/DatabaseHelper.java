package com.example.e_commerce;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "EcommerceDB";
    private static final int DB_VERSION = 1;

    private static final String TABLE_USERS = "users";
    private static final String COL_ID = "id";
    private static final String COL_USERNAME = "username";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_USERS + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USERNAME + " TEXT UNIQUE, " +
                COL_EMAIL + " TEXT UNIQUE, " +
                COL_PASSWORD + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Register User
    public boolean registerUser(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_USERNAME, username);
        values.put(COL_EMAIL, email);
        values.put(COL_PASSWORD, password);

        long result = db.insert(TABLE_USERS, null, values);
        return result != -1;
    }

    // Check Login
    // Check Login with username OR email
    public boolean checkUser(String userOrEmail, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS +
                        " WHERE (" + COL_USERNAME + "=? OR " + COL_EMAIL + "=?) AND " + COL_PASSWORD + "=?",
                new String[]{userOrEmail, userOrEmail, password});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

}
