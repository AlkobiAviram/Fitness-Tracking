package com.games.aviramalkobi.fitness_tracking;


public class AppEntryTimeDBHelper/* extends SQLiteOpenHelper*/{

    // values
   /* public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AppTimeEntries.db";


    // constructor
    public AppEntryTimeDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    // create Tables whit 3 row (INTEGER , INTEGER , STRING)
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + AppEntryTimeContract.AppEntryTime.TABLE_NAME  + " ( " +
                        AppEntryTimeContract.AppEntryTime.COMPLEXITY + " INTEGER ," +
                        AppEntryTimeContract.AppEntryTime.LEVEL + " INTEGER ," +
                        AppEntryTimeContract.AppEntryTime.TIME + " TEXT" + ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop table
        db.execSQL("DROP TABLE IF EXIST " + AppEntryTimeContract.AppEntryTime.TABLE_NAME);
        onCreate(db);
    }*/
}