package umn.umncalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    private EditText emailTag;
    private EditText passwordTag;
    private Button signinBtn;
    private TextView signupBtn;
    private DatabaseHelper dbHelper = new DatabaseHelper();
    private InterestHelper itHelper = new InterestHelper();


    /**
     * activity is created
     **/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        define();

        // create dummy database for this app
        // create dummy user database for this app
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

        // create dummy user event interest database for this app
        // Changye
        ArrayList<String> interest_changye = new ArrayList<>();
        interest_changye.add("Photography");
        interest_changye.add("Movie");
        interest_changye.add("Social");
        interest_changye.add("Free Food");
        itHelper.addEntry("lixx3013@umn.edu", interest_changye);
        // Chris
        ArrayList<String> interest_chris = new ArrayList<>();
        interest_chris.add("Academics");
        interest_chris.add("Sport");
        interest_chris.add("Recreation");
        interest_chris.add("Social");
        itHelper.addEntry("fanxx332@umn.edu", interest_chris);
        // James
        ArrayList<String> interest_james = new ArrayList<>();
        interest_james.add("Movie");
        interest_james.add("Academics");
        interest_james.add("Free Food");
        interest_james.add("Sport");
        itHelper.addEntry("smit7082@umn.edu", interest_james);
        // Seth
        ArrayList<String> interest_seth = new ArrayList<>();
        interest_seth.add("Music");
        interest_seth.add("Sport");
        interest_seth.add("Free Food");
        interest_seth.add("Social");
        itHelper.addEntry("silv2991@umn.edu", interest_seth);
        // Thomas
        ArrayList<String> interest_thomas = new ArrayList<>();
        interest_thomas.add("Academics");
        interest_thomas.add("Photography");
        interest_thomas.add("Social");
        interest_thomas.add("Recreation");
        itHelper.addEntry("neyx0019@umn.edu", interest_thomas);
        // Jia
        ArrayList<String> interest_jia = new ArrayList<>();
        interest_jia.add("Movie");
        interest_jia.add("Photography");
        interest_jia.add("Free Food");
        interest_jia.add("Recreation");
        itHelper.addEntry("zhong240@umn.edu", interest_jia);
        // Aarti
        ArrayList<String> interest_aarti = new ArrayList<>();
        interest_aarti.add("Music");
        interest_aarti.add("Movie");
        interest_aarti.add("Social");
        interest_aarti.add("Academics");
        itHelper.addEntry("sunda134@umn.edu", interest_aarti);
        // Anushree
        ArrayList<String> interest_anushree = new ArrayList<>();
        interest_anushree.add("Academics");
        interest_anushree.add("Sport");
        interest_anushree.add("Recreation");
        interest_anushree.add("Movie");
        itHelper.addEntry("jagra001@umn.edu", interest_anushree);
        // Dianna
        ArrayList<String> interest_dianna = new ArrayList<>();
        interest_dianna.add("Movie");
        interest_dianna.add("Music");
        interest_dianna.add("Recreation");
        interest_dianna.add("Free Food");
        itHelper.addEntry("nguy2152@umn.edu", interest_dianna);
        // David
        ArrayList<String> interest_david = new ArrayList<>();
        interest_david.add("Social");
        interest_david.add("Sport");
        interest_david.add("Photography");
        interest_david.add("Free Food");
        itHelper.addEntry("gilm7783@umn.edu", interest_david);


        signinBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (login()) {
                    // TODO: receive user email in main activity
                    String email = emailTag.getText().toString();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtra("email", email);
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
     * log in validation process
     * @return: return true if all inputs are correct, otherwise return false;
     */
    public boolean login() {
        boolean loginChecked = true;
        String email = emailTag.getText().toString();
        String password = passwordTag.getText().toString();

        // check if user is registered
        if (dbHelper.matched(email)) {
            // check if user has correct password
            if (password.equals(dbHelper.getPassword(email))) {
                Toast.makeText(LoginActivity.this, "Congrats: Login Successful", Toast.LENGTH_LONG)
                        .show();
            }
            else{
                Toast.makeText(LoginActivity.this, "Username or password does not match", Toast
                        .LENGTH_LONG).show();
                passwordTag.setError("");
                emailTag.setError("");
                loginChecked = false;
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