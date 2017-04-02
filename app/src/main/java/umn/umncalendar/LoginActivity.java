package umn.umncalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


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
    public void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }// onCreate()

    

    /*
        log in process
     */
    public void login(){

    }// login





}