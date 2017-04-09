package umn.umncalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;
import java.util.*;

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

    // clickable variables
    private CheckBox checkbox_music;
    private CheckBox checkbox_movie;
    private CheckBox checkbox_game;
    private CheckBox checkbox_sport;
    private CheckBox checkbox_career;
    private CheckBox checkbox_recreation;
    private CheckBox checkbox_late_night;
    private CheckBox checkbox_talk;
    private Button continue_interest;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interest);
        Bundle extra = getIntent().getExtras();
        String userEmail = getInfo(extra);

        define();
        ArrayList<String> interest = new ArrayList<>();
        onClick(interest);
        itHelper.addEntry(userEmail, interest);

        // TODO: add home page
        //continue_interest.setOnClickListener(new View.OnClickListener(){});
    }

    /**
     * get user email from previous page
     */
    public String getInfo(Bundle extra){
        return extra.getString("email");
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
        continue_interest = (Button)findViewById(R.id.continue_interest);

    }

    /**
     * add interest to user's info
     * @param addedInterest: a list that contains user's selection
     */
    public void onClick(ArrayList<String> addedInterest){
        if (checkbox_music.isChecked()){
            addedInterest.add(music);
        }
        if (checkbox_talk.isChecked()){
            addedInterest.add(talk);
        }
        if (checkbox_movie.isChecked()){
            addedInterest.add(movie);
        }
        if (checkbox_late_night.isChecked()){
            addedInterest.add(late_night);
        }
        if (checkbox_recreation.isChecked()){
            addedInterest.add(recreation);
        }
        if (checkbox_career.isChecked()){
            addedInterest.add(career);
        }
        if (checkbox_game.isChecked()){
            addedInterest.add(game);
        }
        if (checkbox_sport.isChecked()){
            addedInterest.add(sport);
        }
    }
}
