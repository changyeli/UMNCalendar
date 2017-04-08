package umn.umncalendar;

/**
 * the database that records user's event interest
 * Created by Changye on 4/7/17.
 */

import java.util.ArrayList;

public class InterestDatabase {
    private String email;
    private ArrayList<String> interests;


    /**
     * constructor of In
     * @param email: account email
     * @param interest: a list of user event interest
     */
    public InterestDatabase(String email, ArrayList<String> interest) {
        this.email = email;
        this.interests = interest;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }
}
