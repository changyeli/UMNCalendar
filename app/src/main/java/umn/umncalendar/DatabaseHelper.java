package umn.umncalendar;

/**
 * Created by Changye on 4/1/17.
 * the database used by this app
 */

import java.util.*;



public class DatabaseHelper {
    private String email;
    private String password;
    private String fullName;
    private String userType;
    private HashMap<String, String> userAccount = new HashMap<>();// email and password
    private HashMap<String, String> userInfo = new HashMap<>();// email and fullname
    private HashMap<String, String> userKind = new HashMap<>();// email and user type



    /**
     * add new entry to the database
     * @param email: user account
     * @param password: user password
     * @param fullName: user full name
     */
    public void createUser(String email, String password, String fullName, String userType){
        userAccount.put(email, password);
        userInfo.put(email, fullName);
        userKind.put(email, userType);
    }

    /**
     * allow user to delete account
     * @param email: user account
     */
    public void deleteUser(String email){
        userAccount.remove(email);
        userInfo.remove(email);
    }

    /**
     * get user password
     * @param email: user account
     * @return user password
     */
    public String getPassword(String email){
        return userAccount.get(email);
    }

    /**
     * check if user is registered
     * @param email: user input email
     * @return true if user is registered, false if not.
     */
    public boolean matched(String email){
        return userAccount.containsKey(email);
    }



}// class end
