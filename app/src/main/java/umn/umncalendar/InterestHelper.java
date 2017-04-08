package umn.umncalendar;

import java.util.ArrayList;
import java.util.HashMap;


/** rewrite, and without SQL.
 * User event interest
 * Created by Changye on 4/5/17.
 */


public class InterestHelper {
    private ArrayList<String> interests = new ArrayList<>();
    private String email;
    private HashMap<String, ArrayList<String>> userInterest = new HashMap<>();


    /**
     * add new entry to the database
     * @param email: user account
     * @param interest: user event interest
     */
    public void addEntry(String email, ArrayList<String> interest){
        userInterest.put(email, interest);
    }

    public ArrayList<String> getInterests(String email){
        return userInterest.get(email);
    }

    /**
     * add user selected interest into database
     * @param interest: the selected user event interest
     */
    public void addInterest(String interest){
        interests.add(interest);
    }


}
