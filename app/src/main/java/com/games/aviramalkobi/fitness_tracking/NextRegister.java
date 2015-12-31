package com.games.aviramalkobi.fitness_tracking;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NextRegister extends AppCompatActivity {

    DAL dal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_register);

        Intent intent = getIntent();
        final String mail = intent.getStringExtra(Register.emailKey);

        final TextView Age = (TextView)findViewById(R.id.Age);
        final TextView Height = (TextView)findViewById(R.id.height);
        final TextView Weight = (TextView)findViewById(R.id.Weight);


        Button ButtonNext = (Button)findViewById(R.id.buttonNext2);
        ButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dal = new DAL(v);


                System.out.println("! befor get key" + mail);
                dal.getKey("WYymjpCIew");
                System.out.println("! after get key" + mail);

                final AlertDialog.Builder inputAlert = new AlertDialog.Builder(v.getContext());
                inputAlert.setTitle("Please Confirm Your Register");
                inputAlert.setMessage("A message send to your email please enter the confirm code");
                final EditText userInput = new EditText(v.getContext());
                inputAlert.setView(userInput);
                inputAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String userInputValue = userInput.getText().toString();
                        //if(userInputValue.equals("test")) {

                        //dal.addUser(Email.getText().toString(), Password.getText().toString(), FullName.getText().toString());
                        //System.out.println("!! add to db" );
                        Intent intent = new Intent(NextRegister.this, Profile.class);
                        startActivity(intent);
                        /*}
                        else{
                            // TODO : export error message
                        }*/
                    }
                });
                inputAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = inputAlert.create();
                alertDialog.show();

                //dal.upDateUser("wrlaFxPlgd" , "test" , "testA" , "testB");
                //dal.removeUserByKey("");

                //dal.upDateUser("wrlaFxPlgd", " ", "", " ");
                //dal.upDateUser("WYymjpCIew", " ", "", " ");







                /*ParseObject userObject = objects.get(0);
                ResultText.setText(userObject.get("whateverColumnName"));*/
                //System.out.println("age = " + Age.getText().toString() + "  H = " + Height.getText().toString()  );
                //int saveAge = Integer.parseInt(Age.getText().toString());
                //int saveHeight = Integer.parseInt(Height.getText().toString());


            }
        });

        Button ButtonBack = (Button)findViewById(R.id.buttonBack2);
        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NextRegister.this, Register.class);
                startActivity(intent);
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registe, menu);
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
}
