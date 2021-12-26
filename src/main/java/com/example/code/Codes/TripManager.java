package com.example.code.Codes;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Objects;
/**
 * @ Class TripManager
 * @author Renad
 */
public class TripManager{
    /**
     * this function notify all drivers has the same source Area of Request
     * @param cr , this is client Request
     */
    public void noftifyDrivers(Request cr){
       Database d=Database.getInstance();
        for (int i=0; i<d.getDriverList().size(); i++){
            for(int j=0; j<d.getDriverList().get(i).favArea.size(); j++){
                if(d.getDriverList().get(i).favArea.get(j).getName().equalsIgnoreCase(cr.getSource().getName())){
                    d.getDriverList().get(i).Reqs.add(cr);
                    break;
                }
            }
        }
    }
}