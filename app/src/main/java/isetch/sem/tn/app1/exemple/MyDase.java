package isetch.sem.tn.app1.exemple;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Med Melek on 17/09/2016.
 */
public class MyDase extends SQLiteOpenHelper  {


    public MyDase(Context context) {
        super(context,"base",null ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table IF NOT EXISTS base ( rec varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion != newVersion) {
            db.execSQL("Drop table IF EXISTS  base ");
            onCreate(db);
        }
    }

    public void InsertRow(String reclamation ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("rec",reclamation);
        db.insert("base", null, contentValues);
    }
    public ArrayList<String> getAllrecord() {
        ArrayList<String> array_list = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from base", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex("rec")));
            res.moveToNext();
        }
        return array_list;

    }
}
