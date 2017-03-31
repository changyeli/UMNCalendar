package umn.umncalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    private EditText emailTag;
    private EditText passwordTag;
    private Button signinBtn;
    private TextView signupBtn;


    /*
        activity is created
     */
    @Override
    public void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // define clicks on the log in page
        emailTag = (EditText)findViewById(R.id.input_email);
        passwordTag = (EditText)findViewById(R.id.input_password);
        signinBtn = (Button)findViewById(R.id.btn_login);
        signupBtn = (TextView)findViewById(R.id.liunk_signup);

        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        }); // new View.OnClickListener() for signinBtn
        signupBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                // start with new sign-up activity
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        }); // new View.OnClickListener() for signupBtn

    }// onCreate()

    /*
        log in process
     */
    public void login(){

    }// login
    

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


    }// authenticate



}