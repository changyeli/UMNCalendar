package umn.umncalendar;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * User event interest
 * Created by Changye on 4/5/17.
 */


public class InterestHelper extends SQLiteOpenHelper {
    private static final int database_version = 1;
    private static final String databaseName = "UserInterest";
    private static final String key_email = "email";
    private ArrayList<String> interest = new ArrayList<>(5); // up to 5 interests

    private String key_interest1 = "interest1";
    private String key_interest2 = "interest2";
    private String key_interest3 = "interest3";
    private String key_interest4 = "interest4";
    private String key_interest5 = "interest5";


    /**
     * constructor
     * @param context:
     */
    public InterestHelper(Context context) {
        super(context, databaseName, null, database_version);
    }

    /**
     * create database
     * @param db: user interest database
     */
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" + databaseName + "(" + key_email + "TEXT PRIMARY KEY," +
                key_interest1 + "TEXT," + key_interest2 + "TEXT," + key_interest3 + "TEXT," +
                key_interest4 + "TEXT," + key_interest5 + "TEXT);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + databaseName);
        onCreate(db);
    }

    /**
     * create new entry of user event interest
     * @param uei: variable that has InterestDatabase type
     */
    public void createInterest(InterestDatabase uei){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_email, uei.getEmail());
        values.put(key_interest1, uei.getInterests().get(0));
        values.put(key_interest2, uei.getInterests().get(1));
        values.put(key_interest3, uei.getInterests().get(2));
        values.put(key_interest4, uei.getInterests().get(3));
        values.put(key_interest5, uei.getInterests().get(4));
        db.insert(databaseName, null, values);
        db.close();
    }

}
