package com.games.aviramalkobi.fitness_tracking;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class HomePageLogin extends AppCompatActivity {

    private Button SignInButton;
    private Button RegisterButton;
    private TextView Email;
    private TextView Password;
    private static boolean connectToParse = false ;

    private boolean errorSignIn = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        if (!connectToParse){
            Parse.initialize(this, "6KZ1YtNX6suqBrNVYOhImz4Q6RyzkusH3pf2JGtL", "6efWZSUIdWz9dLkT2PUMsQK9jnH40v1rmg9oqIWS");
            ParseInstallation.getCurrentInstallation().saveInBackground();
            connectToParse = true ;
        }


        SignInButton = (Button)findViewById(R.id.buttonLogin);
        RegisterButton = (Button)findViewById(R.id.buttonRegister);
        Email = (TextView)findViewById(R.id.signInEmail);
        Password = (TextView)findViewById(R.id.signInPassword);


        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorSignIn = false;

                // testes for email address
                String stringTest = Email.getText().toString();
                if (stringTest.isEmpty()) {
                    errorSignIn = true;
                    Email.setError("please enter email");
                } else if (!(android.util.Patterns.EMAIL_ADDRESS.matcher(stringTest).matches())) {
                    errorSignIn = true;
                    Email.setError("email address is incorrect");
                }

                // testes for Password
                stringTest = Password.getText().toString();
                if (stringTest.isEmpty()) {
                    errorSignIn = true;
                    Password.setError("please enter password");
                }


                ParseUser.logInInBackground(Email.getText().toString(), Password.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            Intent intent = new Intent(HomePageLogin.this, Profile.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        } else {
                            Toast.makeText(HomePageLogin.this, "this user is not exist please registering", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });



        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageLogin.this, Register.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

   /* @Override
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
