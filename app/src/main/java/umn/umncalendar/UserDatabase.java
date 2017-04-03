package umn.umncalendar;

/**
 * Created by Changye on 4/1/17.
 * user info of the account
 */

public class UserDatabase {
    private String username;
    private String password;
    private int uid;
    private String email;

    /**
     * constructor
     * @param uid: user id in the database
     * @param username: username of the account
     * @param password: password of the account
     * @param email: email of the account
     */
    public UserDatabase(int uid, String email, String username, String password){
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
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

    /**
     * get email of the account
     * @return user email in the database
     */
    public String getEmail(){
        return email;
    }


}
