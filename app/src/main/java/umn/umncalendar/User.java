package umn.umncalendar;

/** user info class
 * Created by Changye on 4/9/17.
 */
import java.util.*;

public class User {
    private String user_email;
    private String user_name;
    private ArrayList<String> user_friends = new ArrayList<>();

    /**
     * constructor
     * @param email: user email
     * @param name: user name;
     * @param friends: user friend list
     */
    public User(String email, String name, ArrayList<String> friends){
        this.user_email = email;
        this.user_name = name;
        this.user_friends = friends;
    }

    /**
     * get user email;
     * @return: user email
     */
    public String getUser_email(){
        return user_email;
    }

    /**
     * get user name
     * @return: user name
     */
    public String getUser_name(){
        return user_name;
    }

    /**
     * get user friend list
     * @return: a list contains all user's friends
     */
    public ArrayList<String> getUser_friends() {
        return user_friends;
    }


    /**
     * add friend
     * @param otherEmail: the friend's email that user wants to add
     */
    public void addFriends(String otherEmail){
        user_friends.add(otherEmail);
    }

    /**
     * delete friend
     * @param otheremail: the friend's email that user thats to delete
     */
    public void deleteFriends(String otheremail){
        if (user_friends.contains(otheremail)){
            user_friends.remove(otheremail);
        }
        else{
            // error message here
        }

    }


}