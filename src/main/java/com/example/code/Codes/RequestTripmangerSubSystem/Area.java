
package com.example.code.Codes.RequestTripmangerSubSystem;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;
import java.util.ArrayList;
import java.util.*;
/**
 * @Class Area
 * @author Abanoub
 */
public class Area {

    private String name;

    /**
     * Area's constructor
     * @param name to set the area
     */
    public Area(String name){
        this.name = name;
    }

    /**
     * to set Area's name
     * @param name to set area's name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * to get the name of the area
     * @return name of the area
     */
    public String getName(){
        return name;
    }

    /**
     *this function to print the Area's data
     * @return the area's name
     */
    @Override
    public String toString() {
        return name;
    }
}