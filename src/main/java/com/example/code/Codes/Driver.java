
package com.example.code.Codes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @class Driver
 * @author joseph diaa
 */
public class Driver extends User {

    private String driverLicense;
    private boolean driverStatus;
    private String nationalId;
    private int carCapcity;
    private ArrayList<Area> favArea = new ArrayList<Area>();
    private Rating rate = new Rating();
    private ArrayList<Request> Reqs = new ArrayList<Request>();
    private LocalDateTime date;
    private DIscount dis;
    //private Boolean inRide;
    private Request currentRequest=new Request();
    public Driver(){}
    @JsonIgnore
    @JsonProperty(value = "currentRequest")
    public Request getCurrentRequest() {
        return currentRequest;
    }

    public void setCurrentRequest(Request currentRequest) {
        this.currentRequest = currentRequest;
    }

    /**
     * Driver's constructor that takes all data
     * @param userName Driver's UserName
     * @param email Driver's email
     * @param password Driver's Password
     * @param mobileNumber Driver's MobileNumber
     * @param NationalId Driver's NationalId
     * @param DriverLicense Driver's DriverLicense
     */

    public Driver(String userName, String email, String password, String mobileNumber, String NationalId, String DriverLicense,int capCar ) {
        super(userName, email, password, mobileNumber);
        this.nationalId = NationalId;
        this.driverLicense = DriverLicense;
        this.driverStatus = false;
        this.carCapcity=capCar;
        RegistrationDriver r = new RegistrationDriver(this, false);
        //this.inRide=false;
        d.addInRegDriversList(r);
    }


    public int getCarCapcity() {
        return carCapcity;
    }

    public void setCarCapcity(int carCapcity) {
        this.carCapcity = carCapcity;
    }
    public void addReq(Request r){
        Reqs.add(r);
    }
    /**
     * Driver's constructor to take username and password for log in
     * @param email Driver's email
     * @param password Driver's Password
     */
    public Driver(String email, String password) {
        super(email, password);
    }

    /**
     * This function to add favorite Area For Driver
     * @param area ,Driver's favorite Area
     */
    public String addFavArea(Area area) {
        favArea.add(area);
        return "successful Add Area";
    }

    /**
     * This function to Change Driver Status
     * @param c Driver's status True or False
     */
    public String changeDriverStatus(boolean c) {
        this.driverStatus = c;
        if (c) {
            d.getDriverList().add(this);
            d.getPenDriver().remove(this);
        }
        return "Successful Change Driver Status";
    }

    public void setReqs(ArrayList<Request> reqs) {
        Reqs = reqs;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * This function makes the driver make offer
     * @param id This is the ID of the customer who owns the ٌRequest
     * @param price This is Offer's Price
     */
    public String DriverOffer(int id, double price) {
        Offer off = new Offer();
        off.makeOffer(price, this);
        for (int i = 0; i < this.Reqs.size(); i++) {
            if (this.Reqs.get(i).getId() == id) {
                this.Reqs.get(i).getListOffer().add(off);
                dis=new DIscount(this.Reqs.get(i),date.now().getDayOfMonth(), date.now().getMonthValue(),this);
                this.Reqs.get(i).addToTripEvent(new priceEvent("priceEvent",this.getUserName(), date.now(), price ));
                this.Reqs.remove(Reqs.get(i));
            }
        }
        return "Successful Make Offer";
    }

    /**
     * This function makes Driver Show all own ratings from Client
     */
    public ArrayList<Double> showRates() {
        return this.rate.viewRatingsList();
    }

    /**
     * This is function Register
     * @return True if Registration Complete
     * @return False if Registration inComplete
     */
    public String Register() {
        boolean check = false;
        for(int i=0 ; i<d.getDriverList().size() ;i++)
        {
            if(this.getEmail().equalsIgnoreCase(d.getDriverList().get(i).getEmail()))
                return " Already exits email !";
        }
        for (int i = 0; i < d.getSuspUser().size(); i++) {
            if (d.getSuspUser().get(i) == this.getEmail()) {
                check = true;
            }
        }
        if (!check) {
            Driver dr=new Driver(this.getUserName(),this.getEmail(),this.getPassword(),this.getMobileNumber(),this.getNationalId(),this.getDriverLicense(),this.getCarCapcity());
            d.addtoPenlist(dr);
            return "Successful Register We wait verify from admin";
        } else {
            return "This account has Suspended";
        }
    }

    /**
     * This function Login
     * @return True if LogIn Complete
     * @return False if LogIn inComplete
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
        for (int i = 0; i < d.getDriverList().size(); i++) {
            if (this.getEmail().equals(d.getDriverList().get(i).getEmail())) {
                index=i;
                if(this.getPassword().equals(d.getDriverList().get(i).getPassword())){
                    flag = true;
                }
            }
        }
        if (check == false && flag == false) {
            return "Login failed,Suspended Driver";
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
     * This function to Display all Driver's Data
     * @return Driver's Data
     */
    @Override
    public String toString() {
        return "Driver:" + '\n'
                + "   userName=" + getUserName() + '\n'
                + "   email=" + getEmail() + '\n'
                + "   mobileNumber=" + getMobileNumber() + '\n'
                + "   ID=" + getID() + '\n'
                + "   driverLicense=" + driverLicense + '\n'
                + "   driverStatus=" + driverStatus + '\n'
                + "   nationalId=" + nationalId + '\n'
                + "   favArea=" + favArea + '\n'
                + "   AvgRate=" + rate.getAvgRate() + '\n'
                + '}' + '\n';
    }

    /**
     * This function to set DriverLicense
     * @param driverLicense This is DriverLicense
     */
    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    /**
     * This function to set Driver Status
     * @param driverStatus Driver's Status
     */
    public void setDriverStatus(boolean driverStatus) {
        this.driverStatus = driverStatus;
    }

    /**
     * This Function to set Driver National ID
     * @param nationalId Driver's National ID
     */
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    /**
     * This function to set Driver's list of Favorite Area
     * @param favArea Driver's list of Favorite Area
     */
    public void setFavArea(ArrayList<Area> favArea) {
        this.favArea = favArea;
    }

    /**
     * This function to Set Driver's Rate
     * @param rate Driver's Rate
     */
    public void setRate(Rating rate) {
        this.rate = rate;
    }

    /**
     * This function to get DriverLicense
     * @return DriverLicense
     */
    public String getDriverLicense() {
        return driverLicense;
    }


    @JsonIgnore
    @JsonProperty(value = "Reqs")
    public ArrayList<Request> getReqs() {
        return Reqs;
    }

    public LocalDateTime getDate() {
        return date;
    }

    /**
     * This Function to get DriverStatus
     * @return DriverStatus
     */
    public boolean isDriverStatus() {
        return driverStatus;
    }

    /**
     * This function to get National ID
     * @return National ID
     */
    public String getNationalId() {
        return nationalId;
    }

    /**
     * This function to get list Favorite Area
     * @return List Favorite Area
     */
    @JsonIgnore
    @JsonProperty(value = "favArea")
    public ArrayList<Area> getFavArea() {
        return favArea;
    }

    /**
     * This Function to get Rate fof Driver
     * @return Driver's Rate
     */
    public Rating getRate() {
        return rate;
    }
    public void AddReq(Request r){
        this.Reqs.add(r);
    }
    public  double showAvgRate(){return  this.rate.getAvgRate();}
    public String ArriveLocation(Request currentRequest)
    {
        currentRequest.addToTripEvent(new ArrivedLocationEvent("Arrived Location",date.now(),this.getUserName(),currentRequest.getClient().getUserName()));
        return "Arrived Location";
    }
    public String endRide(Request currentRequest)
    {
        currentRequest.addToTripEvent(new arrivedDestinationEvent("Arrived Destination",date.now(),this.getUserName(),currentRequest.getClient().getUserName()));
        currentRequest.setrEvent(null);
        currentRequest=null;
        return "Arrived Destination";
    }
    public String addRate(double rate) {
        this.rate.addRate(rate);
        return "Thank you !";
    }

}