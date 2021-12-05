package com.example.tugas7_1918066_zulfaizramadhan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_kampus";
    private static final String tb_crypto = "tb_crypto";
    private static final String tb_crypto_id = "id";
    private static final String tb_crypto_jenis = "jenis";
    private static final String tb_crypto_pengertian = "pengertian";
    private static final String CREATE_TABLE_CRYPTO = "CREATE TABLE " +
            tb_crypto +"("
            + tb_crypto_id + " INTEGER PRIMARY KEY ,"
            + tb_crypto_jenis + " TEXT ,"
            + tb_crypto_pengertian + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CRYPTO);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void Createcrypto (crypto data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_crypto_id, data.get_id());
        values.put(tb_crypto_jenis, data.get_jenis());
        values.put(tb_crypto_pengertian, data.get_pengertian());
        db.insert(tb_crypto, null, values);
        db.close();
    }
    public List<crypto> ReadCrypto() {
        List<crypto> listPr = new ArrayList<crypto>();
        String selectQuery = "SELECT * FROM " + tb_crypto;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                crypto data = new crypto();
                data.set_id(cursor.getString(0));
                data.set_jenis(cursor.getString(1));
                data.set_pengertian(cursor.getString(2));
                listPr.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listPr;
    }
    public int Updatecrypto (crypto data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_crypto_jenis, data.get_jenis());
        values.put(tb_crypto_pengertian, data.get_pengertian());
        return db.update(tb_crypto, values, tb_crypto_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteParfum(crypto data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_crypto,tb_crypto_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
