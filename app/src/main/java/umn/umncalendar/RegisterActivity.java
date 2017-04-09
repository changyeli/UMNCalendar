package umn.umncalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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
                    overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                }

            }
        });// signupBtn

        signinBtn_register.setOnClickListener(new View.OnClickListener() {
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
<<<<<<< HEAD
    public void define() {
        fullnameTag_register = (EditText) findViewById(R.id.input_name_register);
        emailTag_register = (EditText) findViewById(R.id.input_email_register);
        passwordTag_register = (EditText) findViewById(R.id.input_password_register);
        passwordConTag_register = (EditText) findViewById(R.id.input_password_con);
        signupBtn_register = (Button) findViewById(R.id.btn_signup_register);
        signinBtn_register = (TextView) findViewById(R.id.link_login_register);
=======
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            //mAuthTask = new LoginActivity.UserLoginTask(email, password);
            //mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
>>>>>>> 21ddcef2839161c1f4118d71910845c7983c78c4

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
        ArrayList<String> allUsers = new ArrayList<>();
        dbHelper.getAllEmails(allUsers);

        if (allUsers.contains(email)) {
            emailTag_register.setError("");
            Toast.makeText(RegisterActivity.this, "This email is alreardy registered", Toast
                    .LENGTH_LONG).show();
        }
<<<<<<< HEAD

        if (!outputs[1].equals("umn.edu")) {
            emailTag_register.setError("");
            Toast.makeText(RegisterActivity.this, "This email is invalid", Toast.LENGTH_LONG)
                    .show();
            valid = false;
=======
    }

    /*@Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), LoginActivity.ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }*/

    /*@Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(LoginActivity.ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

        addEmailsToAutoComplete(emails);
    }*/

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    /*private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(LoginActivity.this,
                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);

        mEmailView.setAdapter(adapter);
    }*/


    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
>>>>>>> 21ddcef2839161c1f4118d71910845c7983c78c4
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