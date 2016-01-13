package com.games.aviramalkobi.fitness_tracking;

import android.content.ContentValues;
import android.view.View;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;

/**
 * Created by AviramAlkobi on 28/12/2015.
 */

public class DAL {

    private static final int MIN_AGE = 14;
    private static final int MAX_AGE = 90;
    private ParseUser userDB;



    public DAL(View view){
        // connect to DB


    }


    

    // for testes
    public String getKey(String email){

        //DB = new ParseObject(Tables.UserTable.TABLE_NAME);

        // Value input to search field
        //final String searchInput = "9";


        // Initiate ParseQuery
        final ParseQuery<User> query = ParseQuery.getQuery(Tables.UserTable.TABLE_NAME);

        // Look for the username that was typed into the search field
        query.whereEqualTo(Tables.UserTable.EMAIL, email);

        //System.out.println("! in");

        query.findInBackground(new FindCallback<User>() {
            @Override
            public void done(List<User> users, ParseException e) {
                if (e == null) {

                    try {
                        users.get(0).setAge(7);
                        users.get(0).setHeight(5);
                        users.get(0).setWeight(6);
                        System.out.println("Sise = " + users.size());
                        // The query was successful.
                        System.out.println("!! ok");

                    }
                    catch (IndexOutOfBoundsException ex){
                        System.out.println( "DAL - get id not ok ");
                    }

                            /*ParseUser user = objects.get(0);
                            String userId = user.getObjectId();
                            System.out.println("!!" + userId);*/

                    // This works but clearly always loads the exact same user profile. I need this string to be loaded dynamically as a function of the user's search query.


                } else {
                    System.out.println("!! error");
                }
            }
        });
        return "ok";
    }

    // upDate DB (good)
    public void upDateUser(String key , String Email, String Password ,String FullName){
        System.out.println("in update user !");

        ParseUser user = ParseUser.getCurrentUser();
        user.put(Tables.UserTable.EMAIL, Email);
        user.put(Tables.UserTable.PASSWORD, Password);
        user.put(Tables.UserTable.FULL_NAME, FullName);
        user.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                if (e != null) {
                    // Saved successfully
                } else {
                    // ParseException
                }
            }
        });

    }


    // TODO : remove this function  , only for test
    // remove all rows
   /* public  void removeAll(){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(AppEntryTimeContract.AppEntryTime.TABLE_NAME, null, null);
    }*/


    // remove one row
   public  void removeUserByKey(String key){

       ParseObject.createWithoutData(Tables.UserTable.TABLE_NAME, key).deleteEventually();
       System.out.println("remove key");
       /*ParseObject.createWithoutData(Tables.UserTable.TABLE_NAME, "fcSmyC1IK1").deleteEventually();
       ParseObject.createWithoutData(Tables.UserTable.TABLE_NAME, "fcSmyC1IK1").deleteEventually();
       ParseObject.createWithoutData(Tables.UserTable.TABLE_NAME, "eDvxK1G842").deleteEventually();
       ParseObject.createWithoutData(Tables.UserTable.TABLE_NAME, "eDvxK1G842").deleteEventually();*/


        /*ParseQuery query = new ParseQuery(Tables.UserTable.TABLE_NAME);

        query.findInBackground(new FindCallback() {
            @Override
            public void done(List objects, ParseException e) {

            }

            @Override
            public void done(Object o, Throwable throwable) {

            }
        });*/
        /*SQLiteDatabase db = helper.getWritableDatabase();

        // search the correct row
        String selection = AppEntryTimeContract.AppEntryTime.COMPLEXITY + " = " + complexity + " AND "
                + AppEntryTimeContract.AppEntryTime.LEVEL + " = " + level ;

        // remove from DB
        db.delete(AppEntryTimeContract.AppEntryTime.TABLE_NAME, selection, null);*/
    }

    // if there is row with this complexity and level
   /* private Boolean thereIsRow(String Email)  {
        Cursor c = getRow(Email);
        if(c.moveToNext()){
            return true;
        }
        return false;
    }*/

    // get row according to complexity and level
   /* private Cursor getRow(String Email ){

        SQLiteDatabase db = helper.getWritableDatabase();;

        Cursor c = db.rawQuery("SELECT * FROM " + Tables.UserTable.TABLE_NAME + " WHERE "
                + Tables.UserTable.EMAIL + " = " + Email , null);

        return c;
    }*/


   /* // get record according to complexity and level
    public String getRecord(int complexity , int level){

        String timeString = str_init;

        //get cursor on start row
        Cursor c = getRow(complexity, level);

        if (c != null) {
            while (c.moveToNext()) {

                //get column index
                int entryTimeColumnIndex = c.getColumnIndex(AppEntryTimeContract.AppEntryTime.TIME);

                try{
                    timeString = c.getString(entryTimeColumnIndex);
                }
                catch (Exception e){
                }
            }
        }
        return timeString;
    }*/


    /************************************************************************/

   /*// TODO : remove this function  , only for test
    public Cursor getAllDBCursor(){
        SQLiteDatabase db = helper.getWritableDatabase();
        // get all DB
        Cursor c = db.rawQuery("SELECT * FROM " + AppEntryTimeContract.AppEntryTime.TABLE_NAME, null);

        return c;
    }
    // TODO : remove this function , only for test
    // write all DB in ArrayList
    public ArrayList getDb(){

        ArrayList entryTimes = new ArrayList();

        //get cursor
        Cursor c = getAllDBCursor();

        if (c != null) {
            while (c.moveToNext()) {
                //get column index

                int entryTimeColumnIndex = c.getColumnIndex(AppEntryTimeContract.AppEntryTime.COMPLEXITY);

                //get entry
                try{
                    String entryTime = c.getString(entryTimeColumnIndex);
                    entryTimes.add(entryTime);
                }
                //save in array
                catch (Exception e){
                }

                entryTimeColumnIndex = c.getColumnIndex(AppEntryTimeContract.AppEntryTime.LEVEL);

                //get entry
                try{
                    String entryTime = c.getString(entryTimeColumnIndex);
                    entryTimes.add(entryTime);
                }
                //save in array
                catch (Exception e){
                }

                entryTimeColumnIndex = c.getColumnIndex(AppEntryTimeContract.AppEntryTime.TIME);

                //get entry
                try{
                    String entryTime = c.getString(entryTimeColumnIndex);
                    entryTimes.add(entryTime);
                }
                //save in array
                catch (Exception e){

                }

            }

        }
        return entryTimes;
    }
*/

/*****************************************************************/

}
