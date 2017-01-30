package isetch.sem.tn.app1.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import isetch.sem.tn.app1.model.Etudiant;

/**
 * Created by Med Melek on 12/10/2016.
 */

public class Base extends SQLiteOpenHelper {

    public Base(Context context) {
        super(context,"data.db",null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table IF NOT EXISTS base (nom varchar(20), prenom varchar(20) , age varchar(5))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        if (oldVersion != newVersion) {
            db.execSQL("Drop table IF EXISTS  base ");
            onCreate(db);
        }

    }



    public void InsertRow(String nom , String prenom , int age ) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nom",nom);
        contentValues.put("prenom",prenom);
        contentValues.put("age",age);
        db.insert("base", null, contentValues);
    }




    public ArrayList<Etudiant> getAllrecord() {
        ArrayList<Etudiant> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from base", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            //list.add(res.getString(res.getColumnIndex("rec")));
            list.add(new Etudiant(

                    res.getString(res.getColumnIndex("nom")),
                    res.getString(res.getColumnIndex("age")),
                    res.getString(res.getColumnIndex("prenom"))


            ));
            res.moveToNext();
        }
        return list;

    }


}
