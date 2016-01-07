package com.games.aviramalkobi.fitness_tracking;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import java.util.UUID;

public class NextRegister extends AppCompatActivity {

    private TextView Age ;
    private TextView Height ;
    private TextView Weight ;

    private String Email ;
    private String Password ;
    private String FullName ;
    private View viewMassage ;
    private final int MAX_AGE = 100 ;
    private final int MAX_HEIGHT = 250 ;
    private final int MAX_WEIGHT = 150 ;
    private final int EMAIL_CODE_LENGHT = 8;
    private String EmailCodString;
    private final String EMAIL_ADDRESS_SUPPORT = "sos.fitness.tracking@gmail.com";
    private boolean errorRegister ;
    private ProgressDialog progress;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_register);


        Intent intent = getIntent();
        Email = intent.getStringExtra(Register.emailKey);
        Password = intent.getStringExtra(Register.passwordKey);
        FullName = intent.getStringExtra(Register.fullNameKey);


        Age = (TextView)findViewById(R.id.Age);
        Height = (TextView)findViewById(R.id.Height);
        Weight = (TextView)findViewById(R.id.Weight);






        Button ButtonNext = (Button)findViewById(R.id.buttonNext2);
        ButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorRegister = false;
                viewMassage = v ;

                // testes for age
                String stringTest = Age.getText().toString();
                if(stringTest.isEmpty()){
                    errorRegister = true;
                    Age.setError("please enter age");

                }
                else if(Integer.parseInt(stringTest) > MAX_AGE){
                    errorRegister = true;
                    Age.setError("maximum age is " + MAX_AGE);
                }


                // testes for height
                stringTest = Height.getText().toString();
                if(stringTest.isEmpty()){
                    errorRegister = true;
                    Height.setError("please enter height");

                }
                else if(Integer.parseInt(stringTest) > MAX_HEIGHT){
                    errorRegister = true;
                    Height.setError("maximum height is " + MAX_HEIGHT);
                }


                // testes for weight
                stringTest = Weight.getText().toString();
                if(stringTest.isEmpty()){
                    errorRegister = true;
                    Weight.setError("please enter weight");

                }
                else if(Integer.parseInt(stringTest) > MAX_WEIGHT){
                    errorRegister = true;
                    Weight.setError("maximum weight is " + MAX_WEIGHT);
                }

                if(!errorRegister) {
                    //dal = new DAL(v);

                    progress = ProgressDialog.show(v.getContext(), "sending..", "send email", true);


                    // TODO : !!!!!!!! send email with key string

                    int age = Integer.parseInt(Age.getText().toString());
                    int hei = Integer.parseInt(Height.getText().toString());
                    int wei = Integer.parseInt(Weight.getText().toString());

                    ParseUser userDB = new ParseUser();

                    // add to table
                    userDB.setUsername(FullName);
                    userDB.setPassword(Password);
                    userDB.setEmail(Email);


                    userDB.put(Tables.UserTable.AGE, age);
                    userDB.put(Tables.UserTable.HEIGHT, hei);       // TODO : only number and not mor 3 digits
                    userDB.put(Tables.UserTable.WEIGHT, wei);        // TODO : only number and not mor 3 digits


                    userDB.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                // Hooray! Let them use the app now.

                                progress.cancel();
                                massage("Please Confirm Your Register", "A message send to your email please press on confirm");
                            }
                            else {

                                // there is a same exception
                                //Toast.makeText(NextRegister.this, "email exist !  please sign in.", Toast.LENGTH_LONG).show();
                                progress.cancel();
                                massage("email exist !", "please sign in.");
                                Intent intent = new Intent(NextRegister.this, HomePageLogin.class);
                                startActivity(intent);
                            }
                        }

                    });
                }
                else{

                }

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


    // add User to DB  (good !)
    public void addUser(String Email , String Password , String FullName , int Age , int Height , int Weight ){



    }


    private void massage(String tittle , String text){

        final AlertDialog.Builder inputAlert = new AlertDialog.Builder(viewMassage.getContext());
        inputAlert.setTitle(tittle);
        inputAlert.setMessage(text);
        inputAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent(NextRegister.this, HomePageLogin.class);
                startActivity(intent);
            }
        });
        /*inputAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });*/
        AlertDialog alertDialog = inputAlert.create();
        alertDialog.show();
    }



    @Override
    public void onBackPressed() {
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
