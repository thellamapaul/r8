package com.example.thellamapaul.r8;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thellamapaul on 1/9/2018.
 */

public class SQLiteHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SQLiteDatabase.db";
    public static final String TABLE_NAME = "REVIEWS";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_ARTIST = "ARTIST";
    public static final String COLUMN_ALBUM = "ALBUM";
    public static final String COLUMN_GENRE = "GENRE";
    public static final String COLUMN_SCORE = "SCORE";
    public static final String COLUMN_ARTWORK_ADDRESS = "ARTWORK_ADDRESS";
    public static final String COLUMN_OPINION = "OPINION";
    private SQLiteDatabase database;

    public SQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " ( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_ARTIST + " VARCHAR, " +
                COLUMN_ALBUM + " VARCHAR, " +
                COLUMN_GENRE + " VARCHAR, " +
                COLUMN_SCORE + " INTEGER, " +
                COLUMN_ARTWORK_ADDRESS + " VARCHAR, " +
                COLUMN_OPINION + " VARCHAR );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertRecord(ReviewModel review) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ARTIST, review.getArtist());
        contentValues.put(COLUMN_ALBUM, review.getAlbum());
        database.insert(TABLE_NAME, null, contentValues);
        database.close();
    }

    public void updateRecord(ReviewModel review) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ARTIST, review.getArtist());
        contentValues.put(COLUMN_ALBUM, review.getAlbum());
        database.update(TABLE_NAME, contentValues, COLUMN_ID + " = ?", new String[]{review.getID()});
        database.close();
    }

    public void deleteRecord(ReviewModel review) {
        database = this.getReadableDatabase();
        database.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{review.getID()});
        database.close();
    }

}
