package com.games.aviramalkobi.fitness_tracking;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class NextRegister extends AppCompatActivity {

    private DAL dal;
    private TextView Age ;
    private TextView Height ;
    private TextView Weight ;
    private final int MAX_AGE = 100 ;
    private final int MAX_HEIGHT = 250 ;
    private final int MAX_WEIGHT = 150 ;
    private final int EMAIL_CODE_LENGHT = 8;
    private String EmailCodString;
    private final String EMAIL_ADDRESS_SUPPORT = "sos.fitness.tracking@gmail.com";
    private boolean errorRegister ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_register);

        Intent intent = getIntent();
        final String Email = intent.getStringExtra(Register.emailKey);
        final String Password = intent.getStringExtra(Register.passwordKey);
        final String FullName = intent.getStringExtra(Register.fullNameKey);


        Age = (TextView)findViewById(R.id.Age);
        Height = (TextView)findViewById(R.id.Height);
        Weight = (TextView)findViewById(R.id.Weight);






        Button ButtonNext = (Button)findViewById(R.id.buttonNext2);
        ButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorRegister = false;

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
                    dal = new DAL(v);


                    // TODO : !!!!!!!! send email with key string
                    final UUID uuidRandom = UUID.randomUUID();
                    EmailCodString = uuidRandom.toString();
                    EmailCodString = EmailCodString.substring( (EMAIL_CODE_LENGHT-EMAIL_CODE_LENGHT) , EMAIL_CODE_LENGHT);
                    System.out.println("!!" + EmailCodString);


                    final AlertDialog.Builder inputAlert = new AlertDialog.Builder(v.getContext());
                    inputAlert.setTitle("Please Confirm Your Register");
                    inputAlert.setMessage("A message send to your email please enter the confirm code");
                    final EditText userInput = new EditText(v.getContext());
                    inputAlert.setView(userInput);
                    inputAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String userInputValue = userInput.getText().toString();
                            if(userInputValue.equals(EmailCodString)) {
                                // string to int
                                int age = Integer.parseInt(Age.getText().toString());
                                int hei = Integer.parseInt(Height.getText().toString());
                                int wei = Integer.parseInt(Weight.getText().toString());

                                // add to DB
                                dal.addUser(Email, Password, FullName, age, hei , wei );
                                System.out.println("!! add to db");

                                // go to profile
                                Intent intent = new Intent(NextRegister.this, Profile.class);
                                startActivity(intent);
                             }
                             else{
                                 // TODO : export error message
                            }
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

    private void sendEmail(String to , String subject , String text) {
        Log.d("D", "Send email");

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("06/01/2016"));
        emailIntent.setType("text");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, EMAIL_ADDRESS_SUPPORT);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, text);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.d("D", "Finished sending email...");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(NextRegister.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
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
