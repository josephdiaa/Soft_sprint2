
package com.example.code.Codes.ActorSubSystem;
import com.example.code.Codes.RequestTripmangerSubSystem.Area;
import com.example.code.Codes.PriceSubSystem.Offer;
import com.example.code.Codes.RequestTripmangerSubSystem.Request;
import com.example.code.Codes.TripEvent.acceptEvent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.code.Codes.DriverproperiesSubSystem.Driver;

import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @Class Client
 * @author Renad
 */
public class Client extends User implements SignUp {
    private Request request=new Request();
    private LocalDateTime date;
    private int day;
    private int month;
    private int year;
    private boolean firstRide=true;

    public boolean isFirstRide() {
        return firstRide;
    }

    public void setFirstRide(boolean firstRide) {
        this.firstRide = firstRide;
    }

    public Client() {}
    @JsonIgnore
    @JsonProperty(value = "request")
    public Request getRequest() {
        return request;
    }

    /**
     * CLient's constructor that takes all data
     * @param userName Client's  username
     * @param email Client's email
     * @param password Client's password
     * @param mobileNumber Client's mobile number
     */
    public Client(String userName, String email, String password, String mobileNumber,int da,int mo,int ye) {
        super(userName, email, password, mobileNumber);
        this.setDay(da);
        this.setMonth(mo);
        this.setYear(ye);
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    /**
     * Client's constructor to take username and password for log in
     * @param email Client's email
     * @param password Client's password
     */
    public Client(String email, String password) {
        super(email, password);
    }

    /**
     * Client uses requestRide function to request a new ride
     * @param source source area for the requested ride
     * @param destination destination area for the requested ride
     */

    public String requestRide(String source, String destination,int np) {
        Area src = new Area(source);
        Area dest = new Area(destination);
        request = new Request(src, dest, this,np);
        return "Request Ride Created";
    }

    /**
     * Client uses rateDriver method to rate the Ride's com.example.code.Codes.DriverproperiesSubSystem.Driver
     * @param d ride's com.example.code.Codes.DriverproperiesSubSystem.Driver
     * @param rate the rate that the user will set it to the com.example.code.Codes.DriverproperiesSubSystem.Driver
     */
    public String rateDriver(Driver d, double rate) {
       return d.addRate(rate);

    }

    /**
     * This is Function Registration To Register Client
     * @return true: if Registration is successful
     *         false: if this Client is suspended
     */
    public String Register() {
        boolean check = false;
        for(int i=0;i<d.getClientList().size();i++){
            if(d.getClientList().get(i).getEmail().equals(this.getEmail())){
                return "This email already used";
            }
        }
        for (int i = 0; i < d.getSuspUser().size(); i++) {
            if (d.getSuspUser().get(i) == this.getEmail()) {
                check = true;
            }
        }
        if (!check) {
            Client c=new Client(this.getUserName(),this.getEmail(),this.getPassword(),this.getMobileNumber(),this.getDay(),this.getMonth(),this.getYear());
            d.addClient(c);
            return "Successful Registration";
        } else {
            return "suspended e-mail !";
        }
    }

    /**
     * This is Function To LogIn Client
     * @return 1: if this client is suspended
     *         2: if this client login successful
     *         3: if this client not registered
     */
    public String logIn() {
        boolean check = true;
        for (int i = 0; i < d.getSuspUser().size(); i++) {
            if (d.getSuspUser().get(i) == this.getEmail()) {
                check = false;
            }
        }
        boolean flag = false;
        int index=-1;
        for (int i = 0; i < d.getClientList().size(); i++) {
            if (this.getEmail().equals(d.getClientList().get(i).getEmail()) ){
                index=i;
                if(this.getPassword().equals(d.getClientList().get(i).getPassword())){
                    flag = true;
                }
            }
        }
        if (check == false && flag == false) {
            return "Login failed,Suspended client";
        } else if (check == true && flag == true) {

            return "Login Successful";
        } else {
            if(index==-1){
                return "You must Register first or Wrong Email";
            }
            else if(this.getEmail().equals(d.getDriverList().get(index).getEmail())){
                return "Your password Wrong";
            }
        }
        return "";
    }

    /**
     *This Function to Get list of Request's Offers
     * @throws NullPointerException if there is no offer list
     */


    public String AcceptOffer(int id) throws NullPointerException {
        if(request.getListOffer().size()>=1){
            for(int i=0 ; i<request.getListOffer().size();i++)
            {
                if( request.getListOffer().get(i).getId() == id)
                {
                   request.getListOffer().get(i).setAccept(true);
                    request.getListOffer().get(i).getDriver().setCurrentRequest(request);

                    request.addToTripEvent(new acceptEvent("Accept Event",date.now(),this.getUserName()));
                    d.addTripEvent(request.getrEvent());
                }
            }
            this.setFirstRide(false);
            request.getListOffer().clear();
            return"Offer Accepted";
        }
        else{
            return"No Offer now :(";
        }
    }
    public ArrayList<Offer> ViewOfferList(){
        return request.getListOffer();
    }
    /**
     * This Function to makes Client to rate Drivers
     * @throws IndexOutOfBoundsException if the client chooses the id greater than list of the driver
     */

   @Override
    public String toString() {
        return "Client{" +
                "request=" +request +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", firstRide=" + firstRide+
                '}';
    }

    /**
     *This is Function to Get all Client's Data
     * @return client's data
     */



    public String logOutCleint(Client u){
        d.removeClient(this);
        return"log out Successful";
    }

}