package umn.umncalendar;

/**
 * Created by Changye on 4/1/17.
 * the database used by this app
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int database_version = 1;

    private static final String databaseName = "userDatabase";
    private static final String userTable = "users";
    private static final String key_uid = "uid";
    private static final String key_username = "username";
    private static final String key_password = "password";

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, database_version);
    }

    /**
     * create the database for this app
     *
     * @param db: database
     */
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" + userTable + "(" + key_uid + "INTEGER PRIMARY KEY " +
                "AUTOINCREMENT," + key_username + "TEXT," + key_password + "TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + userTable);
        onCreate(db);
    }


    /**
     * create a new entry into the database
     *
     * @param user: user info
     */
    public void createUser(UserDatabase user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_username, user.getUsername());
        values.put(key_password, user.getPassword());
        db.insert(userTable, null, values);
        db.close();
    }

    /**
     * delete an entry from the database
     *
     * @param user: user info
     */
    public void deleteUser(UserDatabase user) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(userTable, key_uid + " =? ", new String[]{String.valueOf(user.getUid())});
        db.close();
    }

    /**
     * get user info based on user id in the database
     *
     * @param username: username in the database
     * @return user info
     */
    public UserDatabase getUser(String username) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT " + key_username + "FROM " + userTable + "WHERE" +
                username + "=?", new String[]{key_uid, key_username, key_password});
        if (c != null) {
            c.moveToFirst();
        }

        UserDatabase user = new UserDatabase(Integer.parseInt(c.getString(0)), c
                .getString(1), c.getString(2));
        db.close();
        c.close();

        return user;

    }


}// class end
