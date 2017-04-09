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

        // create dummy database for this app
        dbHelper.createUser("lixx3013@umn.edu", "123456", "Changye Li", "student");
        dbHelper.createUser("fanxx332@umn.edu", "654321", "Chris Fan", "student");
        dbHelper.createUser("smit7082@umn.edu", "309802", "James Smith", "student");
        dbHelper.createUser("webber3321@umn.edu", "500032", "Marian Webber", "student");
        dbHelper.createUser("normanr@umn.edu", "379706", "Rachelle Norman", "student");
        dbHelper.createUser("silv2991@umn.edu", "309280", "Seth Silverman", "student");
        dbHelper.createUser("neyx0019@umn.edu", "796981", "Thomas Ney", "student");
        dbHelper.createUser("zhong240@umn.edu", "20170401", "Jia Zhong", "student");
        dbHelper.createUser("sunda134@umn.edu","5324659","Aarti Rajan","student");
        dbHelper.createUser("jagra001@umn.edu","5444099","Anushree Jagrawal","student");
        dbHelper.createUser("nguy2152@umn.edu","986098","Dianna Nguyen","student");
        dbHelper.createUser("gilm7783@umn.edu", "987897","David Gilmnan", "student");

        signinBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (login()) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                    finish();
                }


            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
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
            passwordTag.setError("");
            emailTag.setError("");
            loginChecked = false;
        }

        return loginChecked;
    }


}