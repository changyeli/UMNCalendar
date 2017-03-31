package umn.umncalendar;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    private EditText fullname;
    private EditText email;
    private EditText password;
    private EditText x500;

    /*
        activity is created
     */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        fullname = (EditText)findViewById(R.id.input_name);
        email = (EditText)findViewById(R.id.input_email);
    }






    /*
        make sure that every input is correct
     */
    public boolean inputCorrect(){
        boolean valid = true;

        String email = emailTag.getText().toString();
        String password = passwordTag.getText().toString();

        if(email.isEmpty() || Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailTag.setError("This email address is invalid");
            valid = false;
        }

        if (password.isEmpty() || password.length() <=6){
            passwordTag.setError("This password is too short");
            valid = false;
        }
        return valid;


    }// inputCorrect

    }