package com.diazs.market.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "market";
    private static final String TABLE_NAME = "item";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESC = "description";
    private static final String KEY_DATE = "date_created";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_NAME + " TEXT, " +
                KEY_DESC + " TEXT, " +
                KEY_DATE + " TEXT )";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS" + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public void insert(Item item){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, item.getId());
        values.put(KEY_NAME, item.getName());
        values.put(KEY_DESC, item.getDescription());
        values.put(KEY_DATE, item.getDate());

        db.insert(TABLE_NAME,null,values);
    }

    public void update(Item item){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, item.getName());
        values.put(KEY_DESC, item.getDescription());

        String whereClause = KEY_ID + " = '" + item.getId() + "'";
        db.update(TABLE_NAME, values, whereClause, null);
    }

    public ArrayList<Item> fetch(){
        ArrayList<Item> arrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {KEY_ID, KEY_NAME, KEY_DESC, KEY_DATE};
        Cursor c = db.query(TABLE_NAME, columns, null, null, null, null,  null);

        while (c.moveToNext()){
            int id = c.getInt(0);
            String name = c.getString(1);
            String description = c.getString(2);
            String date = c.getString(3);

            Item item = new Item();
            item.setId(id);
            item.setName(name);
            item.setDescription(description);
            item.setDate(date);

            arrayList.add(item);
        }

        return arrayList;
    }

    public void delete(int id){
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = KEY_ID + " = " +id;
        db.delete(TABLE_NAME, whereClause, null);
    }
}
