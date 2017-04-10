package umn.umncalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    private EditText fullnameTag_register;
    private EditText emailTag_register;
    private EditText passwordTag_register;
    private EditText passwordConTag_register;

    private Button signupBtn_register;
    private TextView signinBtn_register;
    private DatabaseHelper dbHelper;


    private static final String typeStudent = "student";


    /**
     * activity is created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        define();


        // TODO: all empty blocks will crash the app
        signupBtn_register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email_register = emailTag_register.getText().toString();
                String name_register = fullnameTag_register.getText().toString();
                String password_register = passwordTag_register.getText().toString();
                String passwordC_register = passwordConTag_register.getText().toString();

                if (!inputCorrect(email_register, password_register, name_register,
                        passwordC_register)) {
                    Toast.makeText(RegisterActivity.this, "Register Failed", Toast.LENGTH_LONG)
                            .show();
                } else {
                    dbHelper = new DatabaseHelper();
                    dbHelper.createUser(email_register, name_register, password_register,
                            typeStudent);

                    Toast.makeText(RegisterActivity.this, "Register Successful", Toast.LENGTH_LONG)
                            .show();
                    // go to next activity
                    Intent i = new Intent(getApplicationContext(), UserInterest.class);
                    i.putExtra("email", email_register);// pass the email for future use
                    i.putExtra("name", name_register);// pass the name for future use
                    startActivity(i);
                    finish();
                    overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                }
            }
        });// signupBtn

        signinBtn_register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // go back to login page
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

    }

    /**
     * define all clickable resources in the register page
     */
    public void define() {
        fullnameTag_register = (EditText) findViewById(R.id.input_name_register);
        emailTag_register = (EditText) findViewById(R.id.input_email_register);
        passwordTag_register = (EditText) findViewById(R.id.input_password_register);
        passwordConTag_register = (EditText) findViewById(R.id.input_password_con);
        signupBtn_register = (Button) findViewById(R.id.btn_signup_register);
        signinBtn_register = (TextView) findViewById(R.id.link_login_register);

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
        String[] outputs = email.split("@");


        if (!outputs[1].equals("umn.edu")) {
            emailTag_register.setError("");
            Toast.makeText(RegisterActivity.this, "This email is invalid", Toast.LENGTH_LONG)
                    .show();
            valid = false;
        }
        if (email.equals("") || password.equals("") ||
                passwordCon.equals("") || name.equals("")) {
            if (email.equals("")) {
                emailTag_register.setError("");
            }

            if (password.equals("")) {
                passwordTag_register.setError("");
            }

            if (passwordCon.equals("")) {
                passwordConTag_register.setError("");
            }

            if (name.equals("")) {
                fullnameTag_register.setError("");
            }

            Toast.makeText(RegisterActivity.this, "Empty Required field/s", Toast.LENGTH_LONG)
                    .show();
            valid = false;
        }
        if (!password.equals(passwordCon)) {
            passwordTag_register.setError("");
            passwordConTag_register.setError("");
            Toast.makeText(RegisterActivity.this, "Passwords are not matched", Toast.LENGTH_LONG)
                    .show();
            valid = false;
        }


        return valid;
    }


}// class end