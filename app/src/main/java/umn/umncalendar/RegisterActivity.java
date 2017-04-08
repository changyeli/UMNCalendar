package umn.umncalendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    private EditText fullnameTag;
    private EditText emailTag;
    private EditText passwordTag;
    private EditText passwordCon;
    private RadioButton radio_student;
    private RadioButton radio_host;

    private Button signupBtn;
    private TextView signinBtn;
    private DatabaseHelper dbHelper;
    private UserDatabase user;

    private String email;
    private String name;
    private String password;
    private String passwordC;
    private String userType;

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
                    Toast.makeText(getApplicationContext(), "Register Failed", Toast.LENGTH_LONG)
                            .show();

                }
                itemClicked(v);
                user = new UserDatabase(email, name, password, userType);
                dbHelper.createUser(user);
                Toast.makeText(getApplicationContext(), "Register Successful", Toast.LENGTH_LONG)
                        .show();
            }
        });// signupBtn

        signinBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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
        fullnameTag = (EditText) findViewById(R.id.input_name);
        emailTag = (EditText) findViewById(R.id.input_email);
        passwordTag = (EditText) findViewById(R.id.input_password);
        passwordCon = (EditText) findViewById(R.id.input_password_con);
        signupBtn = (Button) findViewById(R.id.btn_signup);
        signinBtn = (TextView) findViewById(R.id.link_login);
        radio_student = (RadioButton) findViewById(R.id.radio_student);
        radio_host = (RadioButton) findViewById(R.id.radio_host);

        email = emailTag.getText().toString();
        name = fullnameTag.getText().toString();
        password = passwordTag.getText().toString();
        passwordC = passwordCon.getText().toString();


        dbHelper = new DatabaseHelper(this);

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

    /**
     * check which box is checked
     * @param v
     * @return return user type
     */
    public void itemClicked(View v){
        boolean checked = ((RadioButton)v).isChecked();

        switch (v.getId()){
            case R.id.radio_host:
                if (checked){
                    userType = typeHost;
                    radio_student.setChecked(false); // can check one box only
                }
                break;
            case R.id.radio_student:
                if (checked){
                    userType = typeStudent;
                    radio_host.setChecked(false);
                }
                break;
        }
    }


}// class end