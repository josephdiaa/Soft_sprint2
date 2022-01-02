package com.example.code.Codes.DriverproperiesSubSystem;

import com.example.code.Codes.ActorSubSystem.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @class com.example.code.Codes.DriverproperiesSubSystem.Driver
 * @author joseph diaa
 */
public class Driver extends User {
    private GeneralDatabase d=Database.getInstance() ;
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
     * com.example.code.Codes.DriverproperiesSubSystem.Driver's constructor that takes all data
     * @param userName com.example.code.Codes.DriverproperiesSubSystem.Driver's UserName
     * @param email com.example.code.Codes.DriverproperiesSubSystem.Driver's email
     * @param password com.example.code.Codes.DriverproperiesSubSystem.Driver's Password
     * @param mobileNumber com.example.code.Codes.DriverproperiesSubSystem.Driver's MobileNumber
     * @param NationalId com.example.code.Codes.DriverproperiesSubSystem.Driver's NationalId
     * @param DriverLicense com.example.code.Codes.DriverproperiesSubSystem.Driver's DriverLicense
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
     * com.example.code.Codes.DriverproperiesSubSystem.Driver's constructor to take username and password for log in
     * @param email com.example.code.Codes.DriverproperiesSubSystem.Driver's email
     * @param password com.example.code.Codes.DriverproperiesSubSystem.Driver's Password
     */
    public Driver(String email, String password) {
        super(email, password);
    }

    /**
     * This function to add favorite Area For com.example.code.Codes.DriverproperiesSubSystem.Driver
     * @param area ,com.example.code.Codes.DriverproperiesSubSystem.Driver's favorite Area
     */
    public String addFavArea(Area area) {
        favArea.add(area);
        return "successful Add Area";
    }

    /**
     * This function to Change com.example.code.Codes.DriverproperiesSubSystem.Driver Status
     * @param c com.example.code.Codes.DriverproperiesSubSystem.Driver's status True or False
     */
    public String changeDriverStatus(boolean c) {
        this.driverStatus = c;
        if (c) {
            d.getDriverList().add(this);
            d.getPenDriver().remove(this);
        }
        return "Successful Change com.example.code.Codes.DriverproperiesSubSystem.Driver Status";
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
     * This function makes com.example.code.Codes.DriverproperiesSubSystem.Driver Show all own ratings from Client
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
            return "Login failed,Suspended com.example.code.Codes.DriverproperiesSubSystem.Driver";
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
     * This function to Display all com.example.code.Codes.DriverproperiesSubSystem.Driver's Data
     * @return com.example.code.Codes.DriverproperiesSubSystem.Driver's Data
     */
    @Override
    public String toString() {
        return "com.example.code.Codes.DriverproperiesSubSystem.Driver:" + '\n'
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
     * This function to set com.example.code.Codes.DriverproperiesSubSystem.Driver Status
     * @param driverStatus com.example.code.Codes.DriverproperiesSubSystem.Driver's Status
     */
    public void setDriverStatus(boolean driverStatus) {
        this.driverStatus = driverStatus;
    }

    /**
     * This Function to set com.example.code.Codes.DriverproperiesSubSystem.Driver National ID
     * @param nationalId com.example.code.Codes.DriverproperiesSubSystem.Driver's National ID
     */
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    /**
     * This function to set com.example.code.Codes.DriverproperiesSubSystem.Driver's list of Favorite Area
     * @param favArea com.example.code.Codes.DriverproperiesSubSystem.Driver's list of Favorite Area
     */
    public void setFavArea(ArrayList<Area> favArea) {
        this.favArea = favArea;
    }

    /**
     * This function to Set com.example.code.Codes.DriverproperiesSubSystem.Driver's Rate
     * @param rate com.example.code.Codes.DriverproperiesSubSystem.Driver's Rate
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
     * This Function to get Rate fof com.example.code.Codes.DriverproperiesSubSystem.Driver
     * @return com.example.code.Codes.DriverproperiesSubSystem.Driver's Rate
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