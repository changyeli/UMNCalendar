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

    private EditText emailTag;
    private EditText passwordTag;
    private Button signinBtn;
    private TextView signupBtn;
    private DatabaseHelper dbHelper = new DatabaseHelper();


    /**
     * activity is created
     **/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        define();

        signinBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (login()) {
                    // TODO: add home activity after finished
                    //Intent i = new Intent(getApplicationContext(), )
                }
                // go back to previous page
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
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
    }

    /**
     * log in process
     */
    public boolean login() {
        boolean loginChecked = true;
        String email = emailTag.getText().toString();
        String password = passwordTag.getText().toString();

        // check if user is registered
        if (dbHelper.matched(email)) {
            // check if user has correct password
            if (password.equals(dbHelper.getPassword(email))) {
                Toast.makeText(LoginActivity.this, "Congrats: login Successful", Toast.LENGTH_LONG)
                        .show();
            }

        }
        // login failed
        else {
            Toast.makeText(LoginActivity.this, "Username or password does not match", Toast
                    .LENGTH_LONG).show();
            loginChecked = false;
        }

        return loginChecked;
    }


}