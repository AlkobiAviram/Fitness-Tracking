package com.games.aviramalkobi.fitness_tracking;

/**
 * Created by ilandbt on 15/11/2015.
 */
public class Tables {

    public Tables() {};

    public static abstract class UserTable {

        // table name
        public static final String TABLE_NAME = "User";

        // ID column automatically
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String FULL_NAME = "username";
        public static final String AGE = "age";
        public static final String HEIGHT = "height";
        public static final String WEIGHT = "weight";
    }


    public static abstract class ManagerTable{

        // table name
        public static final String TABLE_NAME = "Managers";
    }


}