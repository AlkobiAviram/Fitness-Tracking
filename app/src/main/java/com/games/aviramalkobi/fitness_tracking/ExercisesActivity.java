package com.games.aviramalkobi.fitness_tracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TabHost;

import java.util.ArrayList;

public class ExercisesActivity extends AppCompatActivity {
    public static int chestPicturesNum = 28;
    public static int backPicturesNum = 20;
    public static int shouldersPicturesNum = 30;
    public static int legsPicturesNum = 32;
    public static  int tricepsPicturesNum = 23;
    public static  int bicepsPicturesNum = 15;
    public static  int absPicturesNum = 16;
    public static final String Exercises_Name_Key = "";

    private android.widget.ListView ListView;
    private ListAdapter listAdapter;
    private ArrayList<Exercise> arrayList;
    private  Exercise exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);


        // to list view !
        /*ListView = (ListView) findViewById(R.id.item_list);
        listAdapter = new ListAdapter(ExercisesActivity.this, arrayList);*/

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Chest");
        tabSpec.setContent(R.id.Chest);
        tabSpec.setIndicator("Chest");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Back");
        tabSpec.setContent(R.id.Back);
        tabSpec.setIndicator("Back");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Shoulders");
        tabSpec.setContent(R.id.Shoulders);
        tabSpec.setIndicator("Shoulders");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Legs");
        tabSpec.setContent(R.id.Legs);
        tabSpec.setIndicator("Legs");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Triceps");
        tabSpec.setContent(R.id.Triceps);
        tabSpec.setIndicator("Triceps");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Biceps");
        tabSpec.setContent(R.id.Biceps);
        tabSpec.setIndicator("Biceps");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Abs");
        tabSpec.setContent(R.id.ABS);
        tabSpec.setIndicator("Abs");
        tabHost.addTab(tabSpec);

        Button ShowMeChest[] = new Button[chestPicturesNum];
        setAnimation(ShowMeChest, "SMC", "chest", "C");

        Button ShowMeBack[] = new Button[backPicturesNum];
        setAnimation(ShowMeBack,"SMB","back","B");

        Button ShowMeShoulders[] = new Button[shouldersPicturesNum];
        setAnimation(ShowMeShoulders,"SMS","shoulders","S");

        Button ShowMeLegs[] = new Button[legsPicturesNum];
        setAnimation(ShowMeLegs,"SML","legs","L");

        Button ShowMeTriceps[] = new Button[tricepsPicturesNum];
        setAnimation(ShowMeTriceps,"SMTr","triceps","r");

        Button ShowMeBiceps[] = new Button[bicepsPicturesNum];
        setAnimation(ShowMeBiceps,"SMBi","biceps","i");

        Button ShowMeABS[] = new Button[absPicturesNum];
        setAnimation(ShowMeABS,"SMA","abs","A");

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exercises, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/


    public void setAnimation(Button ShowMeExercises[], String ShowMeExercisesStr, final String muscleName,final String splitKey ){

        for (int i = 0; i<ShowMeExercises.length; i++) {

            String mDrawableName = ShowMeExercisesStr+(i+1);
            final int resID = getResources().getIdentifier(mDrawableName, "id", getPackageName());
            ShowMeExercises[i]=(Button) findViewById(resID);
            ShowMeExercises[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s[],s2[];
                    Intent intent = new Intent(ExercisesActivity.this, ShowExercisesActivity.class);
                    String s1=  v.getResources().getResourceName(resID);
                    s = s1.split("/");
                    s2 = s[s.length-1].split(splitKey);
                    intent.putExtra(Exercises_Name_Key, muscleName + s2[s2.length - 1]);
                    startActivity(intent);

                }
            });
        }

    }




}
