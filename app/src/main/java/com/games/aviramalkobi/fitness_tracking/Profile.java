package com.games.aviramalkobi.fitness_tracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    ArrayList<Exercise> MyExercisesList ;
    ArrayList<Exercise> AllExercisesList ;

    private static boolean inEditPosition = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        final Button AllExercises = (Button)findViewById(R.id.ButtonAllExercises);
        final Button MyExercises = (Button)findViewById(R.id.ButtonMyExercises);
        //Button Edit = (Button)findViewById(R.id.ButtonEdit);

        final EditText Age = (EditText)findViewById(R.id.editAge);
        final EditText Height = (EditText)findViewById(R.id.editHeight);
        final EditText Weight = (EditText)findViewById(R.id.editWeight);


        AllExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // save  button
                if(inEditPosition) {
                    // TODO ::  to SAVE CHANGES in DB !!

                    Age.setEnabled(false);
                    Height.setEnabled(false);
                    Weight.setEnabled(false);

                    inEditPosition = false;
                    MyExercises.setVisibility(View.VISIBLE);
                    AllExercises.setText("All Exercises");
                }
                // all Exercises Button
                else {
                    Intent intent = new Intent(Profile.this,ExercisesActivity.class);
                    startActivity(intent);
                }
            }
        });

        MyExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this,ExercisesActivity.class);
                startActivity(intent);
            }
        });

        /*Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllExercises.setText("Save");
                MyExercises.setVisibility(View.INVISIBLE);
                inEditPosition = true ;

                Age.setEnabled(true);
                Height.setEnabled(true);
                Weight.setEnabled(true);
            }
        });*/
    }


    @Override
    public void onBackPressed() {
        if(inEditPosition){
            inEditPosition = false ;
            Intent intent = new Intent(Profile.this,Profile.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(Profile.this,HomePageLogin.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_profile, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.settings) {
            Intent intent = new Intent(Profile.this,SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.EditProfile) {

            Intent intent = new Intent(Profile.this,EditProfile.class);
            startActivity(intent);
            return true;
        }



        return super.onOptionsItemSelected(item);
    }
}
