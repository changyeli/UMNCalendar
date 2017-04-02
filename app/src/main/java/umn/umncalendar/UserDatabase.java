package umn.umncalendar;

/**
 * Created by Changye on 4/1/17.
 * user info of the account
 */

public class UserDatabase {
    private String username;
    private String password;
    private int uid;

    /**
     * constructor
     * @param uid: user id in the database
     * @param username: username of the account
     * @param password: password of the account
     */
    public UserDatabase(int uid, String username, String password){
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    /**
     * get username of the account
     * @return: username string
     */
    public String getUsername(){
        return username;
    }

    /**
     * get password of the account
     * @return password string
     */
    public String getPassword(){
        return password;
    }

    /**
     * get uid of the account
     * @return user id in the database
     */
    public int getUid(){
        return uid;
    }


}
