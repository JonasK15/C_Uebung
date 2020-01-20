package com.example.c_uebung;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private  static final int DATABASE_VERSION=1;

    private static final String DATABASE_NAME="Personenverwaltung";

    private static final String TABLE_NAME="Person";
    //Attribute
    private static final String COLUMN_ID ="PERSONEN_ID";
    private static final String COLUMN_AGE = "Age";
    private static final String COLUMN_VORNAME ="Vorname";
    private static final String COLUMN_NACHNAME = "Nachname";
    private static final String COLUMN_STREET = "Street";
    private static final String COLUMN_CITY = "City";
    private static final String COLUMN_ZIPCODE = "ZIP_CODE";

    public DatabaseHandler( Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String temp = "CREATE TABLE "+TABLE_NAME+" ( "+COLUMN_ID+" INTEGER PRIMARY KEY,"  +
                COLUMN_AGE+" TEXT, " + " "+COLUMN_VORNAME+" TEXT, "+COLUMN_NACHNAME+" TEXT, "
                +COLUMN_STREET+" TEXT, "+COLUMN_CITY+" TEXT, "+COLUMN_ZIPCODE+" TEXT) ";
        db.execSQL(temp);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
