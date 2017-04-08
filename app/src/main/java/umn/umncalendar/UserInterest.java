package umn.umncalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.view.View;

public class UserInterest extends AppCompatActivity {
    // tags
    private static final String music = "music";
    private static final String movie = "movie";
    private static final String game = "game";
    private static final String sport = "sport";
    private static final String career = "career";
    private static final String recreation = "recreation";
    private static final String late_night = "late night";
    private static final String talk = "talk";
    private InterestHelper itHelper = new InterestHelper();
    private String userEmail;

    // clickable variables
    private CheckBox checkbox_music;
    private CheckBox checkbox_movie;
    private CheckBox checkbox_game;
    private CheckBox checkbox_sport;
    private CheckBox checkbox_career;
    private CheckBox checkbox_recreation;
    private CheckBox checkbox_late_night;
    private CheckBox checkbox_talk;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interest);
        Bundle extra = getIntent().getExtras();
        getInfo(extra);
        define();
    }

    /**
     * get user email from previous page
     */
    public void getInfo(Bundle extra){
        if (extra != null){
            userEmail = extra.getString("email");
        }
    }

    /**
     * define all clickable variables
     */
    public void define(){
        checkbox_music = (CheckBox)findViewById(R.id.checkbox_music);
        checkbox_movie = (CheckBox)findViewById(R.id.checkbox_movie);
        checkbox_game = (CheckBox)findViewById(R.id.checkbox_game);
        checkbox_sport = (CheckBox)findViewById(R.id.checkbox_sport);
        checkbox_career = (CheckBox)findViewById(R.id.checkbox_career);
        checkbox_recreation = (CheckBox)findViewById(R.id.checkbox_recreation);
        checkbox_late_night = (CheckBox)findViewById(R.id.checkbox_late_night);
        checkbox_talk = (CheckBox)findViewById(R.id.checkbox_talk);

    }

    public void itemClicked(View v){

    }
}
