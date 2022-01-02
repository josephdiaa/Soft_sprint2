
package com.example.code.Codes.DriverproperiesSubSystem;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;
/**
 * @ Class RegistrationDriver
 * @author joseph diaa
 */
public class RegistrationDriver {
    private boolean status;
    private Driver driver;

    /**
     * to get the driver who want to register
     * @param driver to set the driver
     * @param status to set the status
     */
    public RegistrationDriver( Driver driver,boolean status) {
        this.status = status;
        this.driver = driver;
    }

    /**
     * change status of the registeration
     * @param check to change the status
     */
    public void changeStatus(boolean check){
        this.status=check;
        if(check){
            driver.changeDriverStatus(true);
        }
    }

    /**
     * to print the registration driver data
     * @return the registration driver data
     */
    @Override
    public String toString() {
        return "RegistrationDriver{" +'\n'+
                "status=" + status+'\n'+
                driver;
    }
    public void setDriver(Driver driver){
        this.driver=driver;
    }
    public Driver getDriver(){
        return driver;
    }
    public void setStatus(boolean status){
        this.status=status;
    }
    public boolean getStatus(){
        return status;
    }
}