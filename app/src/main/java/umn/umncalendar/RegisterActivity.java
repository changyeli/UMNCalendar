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
    private EditText fullnameTag;
    private EditText emailTag;
    private EditText passwordTag;
    private EditText passwordCon;
    private Button signupBtn;
    private TextView signinBtn;
    private DatabaseHelper dbHelper;
    private UserDatabase user;

    /*
        activity is created
     */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        define();

        signinBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(){
                if (!valid){

                }
            }
        });

    }

    /**
     * define all clickable resources in the register page
     */
    public void define(){
        fullnameTag = (EditText)findViewById(R.id.input_name);
        emailTag = (EditText)findViewById(R.id.input_email);
        passwordTag = (EditText)findViewById(R.id.input_password);
        passwordCon = (EditText)findViewById(R.id.input_password);
        signupBtn = (Button)findViewById(R.id.btn_signup);
        signinBtn = (TextView) findViewById(R.id.link_login);
        dbHelper = new DatabaseHelper(this);
    }

    /**
     * check if the input is correct and valid
     * @param email: email of a new account
     * @param password: password of a new account
     * @param name: new account name
     * @param passwordCon: the repeated password from the new user
     * @return
     */
    public boolean inputCorrect(String email, String password, String name, String passwordCon){
        boolean valid = true;

        if (email.endsWith("umn.edu")) {
            emailTag.setError("This email address is invalid.");
            valid = false;
        }

        if (email.equals("") || password.equals("") || passwordCon.equals("") || name.equals("")){
            emailTag.setError("This is required field.");
            valid = false;
        }

        if (!password.equals(passwordCon)) {
            passwordTag.setError("This password is invalid.");
        }

    }





}// class end