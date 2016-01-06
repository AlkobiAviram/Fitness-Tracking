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


public class Register extends AppCompatActivity {


    private TextView Email ;
    private TextView FullName ;
    private TextView Password ;
    private TextView Email_2 ;
    private TextView Password_2;

    DAL dal;
    public static final String emailKey = "EmailKey";
    public static final String fullNameKey = "FullNameKey";
    public static final String passwordKey = "PasswordKey";
    private final int MIN_FULL_NAME_LENGTH = 5 ;
    private final int MIN_PASSWORD_LENGTH = 6 ;
    private boolean errorRegister ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Email = (TextView)findViewById(R.id.Email);
        Email_2 = (TextView)findViewById(R.id.Email2);
        Password = (TextView)findViewById(R.id.Password);
        Password_2 = (TextView)findViewById(R.id.Password2);
        FullName = (TextView)findViewById(R.id.FullName);



        Button ButtonNext = (Button)findViewById(R.id.buttonNext);
        ButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorRegister = false ;
                // testes for full name
                String stringTest = FullName.getText().toString();
                if(stringTest.isEmpty()){
                    errorRegister = true;
                    FullName.setError("please enter full name");

                }
                else if(stringTest.length() < MIN_FULL_NAME_LENGTH){
                    errorRegister = true;
                    FullName.setError("full name must be least " + MIN_FULL_NAME_LENGTH + " characters");
                }

                // testes for email address
                stringTest = Email.getText().toString();
                if(stringTest.isEmpty()){
                    errorRegister = true;
                    Email.setError("please enter email");
                }
                else if( !(android.util.Patterns.EMAIL_ADDRESS.matcher(stringTest).matches()) ){
                    errorRegister = true;
                    Email.setError("email address is incorrect");
                }
                else if( !(Email_2.getText().toString().equals(stringTest))){
                    errorRegister = true;
                    Email.setError("email address is wrong");
                    Email_2.setError("email address is wrong");
                }


                // testes for Password
                stringTest = Password.getText().toString();
                if(stringTest.isEmpty()){
                    errorRegister = true;
                    Password.setError("please enter password");
                }
                else if(stringTest.length() > MIN_PASSWORD_LENGTH){
                    errorRegister = true;
                    FullName.setError("password name must be least " + MIN_PASSWORD_LENGTH + " characters");
                }
                else if( !(Password_2.getText().toString().equals(stringTest))){
                    errorRegister = true;
                    Password.setError("password is wrong");
                    Password_2.setError("password is wrong");
                }


                if(!errorRegister) {
                    Intent intent = new Intent(Register.this, NextRegister.class);
                    intent.putExtra(emailKey, Email.getText().toString());
                    intent.putExtra(fullNameKey, FullName.getText().toString());
                    intent.putExtra(passwordKey, Password.getText().toString());
                    startActivity(intent);
                }



            }
        });


        Button ButtonBack = (Button)findViewById(R.id.buttonBack);
        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, HomePageLogin.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
