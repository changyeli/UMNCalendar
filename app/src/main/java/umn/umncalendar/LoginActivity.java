package umn.umncalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    private EditText emailTag;
    private EditText passwordTag;
    private Button signinBtn;
    private TextView signupBtn;
    private DatabaseHelper dbHelper;
    private UserDatabase user;


    /**
     * activity is created
     **/
    public void OnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        define();

        signinBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                login();
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }// onCreate()


    /**
     * define all clickable tags in login page
     */
    public void define() {
        emailTag = (EditText) findViewById(R.id.input_email);
        passwordTag = (EditText) findViewById(R.id.input_password);
        signinBtn = (Button) findViewById(R.id.btn_login);
        signupBtn = (TextView) findViewById(R.id.link_signup);
        dbHelper = new DatabaseHelper(this);
    }

    /**
     * log in process
     */
    public void login() {
        String username = emailTag.getText().toString();
        String password = passwordTag.getText().toString();
        user = dbHelper.getUser(username);

        // log in succeed
        if (password.equals(user.getPassword())) {
            Toast.makeText(LoginActivity.this, "Congrats: login Successful", Toast.LENGTH_LONG)
                    .show();
        }
        // log in failed
        else {
            Toast.makeText(LoginActivity.this, "Username or password does not match", Toast
                    .LENGTH_LONG).show();
        }


    }


}