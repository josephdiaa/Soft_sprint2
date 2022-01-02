
package com.example.code.Codes.PriceSubSystem;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;

/**
 * @ Class Offer
 * @author Mina
 */
public class Offer  {
    private double price;
    private Driver driver;
    private boolean accept;
    private double discountedPrice=0;
    static private int num=0;
    private int id;
    DIscount dis;

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    /**
     * Default Constructor To set Accept false
     */
    public Offer(){
        accept=false;
        num++;
        id=num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * This function to make offer
     * @param p Offer's Price
     * @param d Offer's com.example.code.Codes.DriverproperiesSubSystem.Driver
     */
    public void makeOffer(double p,Driver d){
        this.price=p;
        discountedPrice=p;
        this.driver=d;
    }

    /**
     * This function to Display All Data of offer
     * @return Offer's Data
     */
    @Override
    public String toString() {
        return "Offer:" +'\n'+
                "   price=" + price +'\n'+
                "com.example.code.Codes.DriverproperiesSubSystem.Driver:"+'\n'+
                 "  com.example.code.Codes.DriverproperiesSubSystem.Driver name="+ driver.getUserName() +'\n'
                +"  com.example.code.Codes.DriverproperiesSubSystem.Driver mobile ="+driver.getMobileNumber()+'\n'
                +"  com.example.code.Codes.DriverproperiesSubSystem.Driver license="+driver.getDriverLicense()+'\n'
                +"  com.example.code.Codes.DriverproperiesSubSystem.Driver national ID ="+driver.getNationalId()+'\n'
                +"  com.example.code.Codes.DriverproperiesSubSystem.Driver rate = "+driver.getRate().getAvgRate();
    }

    /**
     * This Function To get Price of Offer
     * @return Offer's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * This Function to get Offer's com.example.code.Codes.DriverproperiesSubSystem.Driver
     * @return Offer's com.example.code.Codes.DriverproperiesSubSystem.Driver
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * This Function to Get Offer's Status
     * @return Offer's Status
     */
    public boolean isAccept() {
        return accept;
    }

    /**
     * This Function to set Offer's Price
     * @param price Offer's Price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This Function to Set Offer's com.example.code.Codes.DriverproperiesSubSystem.Driver
     * @param driver Offer's com.example.code.Codes.DriverproperiesSubSystem.Driver
     */
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    /**
     * This Function to Set Offer's Status
     * @param accept Offer's Status
     */
    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}
