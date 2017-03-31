package umn.umncalendar;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    private EditText emailTag;
    private EditText passwordTag;
    private Button signinBtn;


    @Override
    public void onCreate(Button savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void LoginButton(){
        emailTag = (EditText) findViewById(R.id.input_email);
        passwordTag = (EditText) findViewById(R.id.input_password);
        signinBtn = (Button) findViewById(R.id.btn_login)
    }

}