package com.example.code.Codes.RequestTripmangerSubSystem;

import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;
import com.example.code.Codes.DataBaseSubSystem.Database;



/**
 * @ Class TripManager
 * @author Renad
 */
public class TripManager{
    /**
     * this function notify all drivers has the same source Area of Request and don't have a Current ride and car capacity equals num of a passenger
     * @param cr , this is client Request
     */
    public void noftifyDrivers(Request cr){
       Database d=Database.getInstance();
        for (int i=0; i<d.getDriverList().size(); i++){
            for(int j=0; j<d.getDriverList().get(i).getFavArea().size(); j++){
                if(d.getDriverList().get(i).getFavArea().get(j).getName().equalsIgnoreCase(cr.getSource().getName())
                        &&d.getDriverList().get(i).getCarCapcity()>=cr.getNumPassenger()){
                    if(d.getDriverList().get(i).getCurrentRequest()!=null){
                        d.getDriverList().get(i).addReq(cr);
                        break;
                    }
                }
            }
        }
    }
}