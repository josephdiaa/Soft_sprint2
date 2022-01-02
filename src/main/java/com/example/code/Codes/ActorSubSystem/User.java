
package com.example.code.Codes.ActorSubSystem;

import com.example.code.Codes.DataBaseSubSystem.Database;
import com.example.code.Codes.DataBaseSubSystem.GeneralDatabase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;

/**
 * @ Class User
 * @author joseph
 */
public abstract class User implements SignIn, SignUp {
    static GeneralDatabase d = Database.getInstance();
    private String userName;
    private String email;
    private String password;
    private String mobileNumber;
    private long ID;
    private static long count = 0;
    public User(){}
    /**
     * Parameterize Constructor Take all Data of user and set it
     * @param userName User's Name
     * @param email User's Email
     * @param password User's Password
     * @param mobileNumber User's MobileNumber
     */
    public User(String userName, String email, String password, String mobileNumber) {
        count++;
        this.ID = count;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    /**
     * Parameterize Constructor Take User's Email and Password
     * @param email User's Email
     * @param password User's Password
     */
    public User(String email ,String password){
    this.email = email;
    this.password = password;
    }

    /**
     * This function to Get Data Base
     * @return
     */
    public static GeneralDatabase getD() {
        return d;
    }

    /**
     * This Function To get UserName
     * @return UserName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This Function to Get User's Email
     * @return User's Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This is Function to Get User's Password
     * @return User's Password
     */
    @JsonIgnore
    @JsonProperty(value = "password")
    public String getPassword() {
        return password;
    }

    /**
     * This is Function to Get User's MobileNumber
     * @return User's MobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * This is Function to Get User's ID
     * @return User's ID
     */
    public long getID() {
        return ID;
    }

    /**
     * This Function to number of user in Program
     * @return number of user in Program
     */
    public static long getCount() {
        return count;
    }

    /**
     * This Funcation to set DataBase
     * @param d DataBase
     */
    public static void setD(Database d) {
        User.d = d;
    }

    /**
     * This function to Set userName
     * @param userName userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This Function to Set User's Email
     * @param email User's Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This Function to Set User's Password
     * @param password User's Password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This Function to Set User's MobileNumber
     * @param mobileNumber User's MobileNumber
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * This Function to Set User's ID
     * @param ID User's ID
     */
    public void setID(long ID) {
        this.ID = ID;
    }

    /**
     * This Function to set number of user in Program
     * @param count number of user in Program
     */
    public static void setCount(long count) {
        User.count = count;
    }

    /**
     * This Function to get all User's Data
     * @return User's Data
     */
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName+ '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", ID=" + ID +
                '}';
    }
}