package umn.umncalendar;

/** user info class
 * Created by Changye on 4/9/17.
 */
import java.util.*;

public class User {
    private String user_email;
    private String user_name;
    private int user_pic;
    private ArrayList<String> user_friends = new ArrayList<>();
    private static ArrayList<User> allUsers = initUserList();

    private static ArrayList<User> initUserList() {
        ArrayList<User> result = new ArrayList<>();
        result.add(new User("Marian",R.mipmap.marian));
        result.add(new User("Thomas",R.mipmap.thomas));
        return result;
    }

    private static List<User> friends = initFriends();

    private static List<User> initFriends() {
        List<User> result = new ArrayList<>();
        result.add(new User("Seth",R.mipmap.seth));
        result.add(new User("James",R.mipmap.james));
        return result;

    }

    public User(String user_name, int user_pic) {
        this.user_name = user_name;
        this.user_pic = user_pic;
    }

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

    public User(String email, String name, ArrayList<String> friends, int pic) {
        this.user_email = email;
        this.user_name = name;
        this.user_friends = friends;
        this.user_pic = pic;
    }
    public int getUser_pic() { return user_pic; }
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

    public static List<User> getFriends() {
        return friends;
    }

    public static List<User> getAllUsers() {
        return allUsers;
    }

    public static void setFriends(List<User> friends) {
        User.friends = friends;
    }
}