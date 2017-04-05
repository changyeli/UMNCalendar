package umn.umncalendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by Changye on 4/3/17.
 * determine if the user is student of host
 */

public class UserType extends AppCompatActivity {
    private CheckBox boxStudent;
    private CheckBox boxHost;
    private Button continueBtn;
    private final static String typeStudent = "student";
    private final static String typeHost = "host";

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        define();
        continueBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }

        });

    }

    public void define(){
        boxHost = (CheckBox)findViewById(R.id.checkBox_host);
        boxStudent = (CheckBox)findViewById(R.id.checkBox_student);
        continueBtn = (Button)findViewById(R.id.button_continue);
    }

}
