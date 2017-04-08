package umn.umncalendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


public class RegisterActivity extends AppCompatActivity {
    private EditText fullnameTag;
    private EditText emailTag;
    private EditText passwordTag;
    private EditText passwordCon;

    private Button signupBtn;
    private TextView signinBtn;
    private DatabaseHelper dbHelper;

    private String email;
    private String name;
    private String password;
    private String passwordC;

    private static final String typeHost = "host";
    private static final String typeStudent = "student";


    /**
     *  activity is created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        define();

        signupBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!inputCorrect(email, password, name, passwordC)) {
                    Toast.makeText(RegisterActivity.this, "Register Failed", Toast.LENGTH_LONG)
                            .show();
                    // go back to previous activity
                    Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(i);

                }
                dbHelper = new DatabaseHelper();
                dbHelper.createUser(email, name, password, typeStudent);

                Toast.makeText(RegisterActivity.this, "Register Successful", Toast.LENGTH_LONG)
                        .show();
                // go to next activity
                Intent i = new Intent(getApplicationContext(), UserInterest.class);
                i.putExtra("email", email);// pass the email for future use
                startActivity(i);
            }
        });// signupBtn

        signinBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // go back to login page
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

    }

    /**
     * define all clickable resources in the register page
     */
    public void define() {
        fullnameTag = (EditText) findViewById(R.id.input_name_register);
        emailTag = (EditText) findViewById(R.id.input_email_register);
        passwordTag = (EditText) findViewById(R.id.input_password_register);
        passwordCon = (EditText) findViewById(R.id.input_password_con);
        signupBtn = (Button) findViewById(R.id.btn_signup_register);
        signinBtn = (TextView) findViewById(R.id.link_login_register);

        email = emailTag.getText().toString();
        name = fullnameTag.getText().toString();
        password = passwordTag.getText().toString();
        passwordC = passwordCon.getText().toString();


    }

    /**
     * check if the input is correct and valid
     *
     * @param email:       email of a new account
     * @param password:    password of a new account
     * @param name:        new account name
     * @param passwordCon: the repeated password from the new user
     * @return if the input is valid
     */
    public boolean inputCorrect(String email, String password, String name, String passwordCon) {
        boolean valid = true;

        if (!email.endsWith("umn.edu")) {
            emailTag.setError("This email address is invalid.");
            valid = false;
        }

        if (email.equals("") || password.equals("") || passwordCon.equals("") || name.equals("")) {
            emailTag.setError("This is required field.");
            valid = false;
        }

        if (!password.equals(passwordCon)) {
            passwordTag.setError("This password is invalid.");
            valid = false;
        }

        return valid;
    }


}// class end