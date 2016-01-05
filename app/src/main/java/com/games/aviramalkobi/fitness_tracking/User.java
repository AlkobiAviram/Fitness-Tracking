package com.games.aviramalkobi.fitness_tracking;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by AviramAlkobi on 28/12/2015.
 */
@ParseClassName(Tables.UserTable.TABLE_NAME)
public class User extends ParseObject {

    private String FullName ;
    private String Password ;
    private String Email ;
    private int Age ;
    private int Height;
    private int Weight;
    //private ProgramWorkout programWorkout;



    // constructor A
    public User(String fullName, String password, String email, int age, int height, int weight){
        this.FullName = fullName;
        this.Password = password;
        this.Email = email;
        this.Age = age;
        this.Height = height;
        this.Weight = weight;
    }

    // constructor B
    public User(String fullName, String password, String email){
        this.FullName = fullName;
        this.Password = password;
        this.Email = email;
    }

    // set and get
    public void setFullName(String fullName){
        put(Tables.UserTable.FULL_NAME , fullName);
    }
    public String getFullName(){
        return getString(Tables.UserTable.FULL_NAME);
    }

    public void setPassword(String password){
        put(Tables.UserTable.PASSWORD , password);
    }
    public String getPassword(){
        return getString(Tables.UserTable.PASSWORD);
    }

    public void setEmail(String email){
        put(Tables.UserTable.EMAIL , email);
    }
    public String getEmail(){
        return getString(Tables.UserTable.EMAIL);
    }

    public void setAge(int age){
        if(age < Integer.MAX_VALUE)
            put(Tables.UserTable.AGE , age);
    }
    public int getAge(){
        return getInt(Tables.UserTable.AGE);
    }

    public void setHeight(int height){
        if(height < Integer.MAX_VALUE)
            put(Tables.UserTable.HEIGHT , height);
    }
    public int getHeight(){
        return getInt(Tables.UserTable.HEIGHT);
    }

    public void setWeight(int weight){
        if(weight < Integer.MAX_VALUE)
            put(Tables.UserTable.WEIGHT , weight);
    }
    public int getWeight(){
        return getInt(Tables.UserTable.WEIGHT);
    }

    @Override
    public String toString() {
        super.toString();
        return ("E = " + getEmail() + "!!" + "Name = " + getFullName() + "!!"  + "p =" + getPassword());
    }
}
