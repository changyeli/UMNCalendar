package umn.umncalendar;

/**
 * Created by Changye on 4/1/17.
 * user info of the account
 */

public class UserDatabase {
    private String username;
    private String password;
    private String email;
    private String type;

    /**
     * constructor
     * @param username: username of the account
     * @param password: password of the account
     * @param email: email of the account
     */
    public UserDatabase(String email, String username, String password, String type){
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;
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
     * get email of the account
     * @return user email in the database
     */
    public String getEmail(){
        return email;
    }

    /**
     * get type of the account
     * @return either "student" or "host"
     */
    public String getType(){
        return type;
    }



}
