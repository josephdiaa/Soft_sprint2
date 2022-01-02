
package com.example.code.Codes.ActorSubSystem;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;
/**
 * @ interface SignUp
 * @author Abanoub
 */
public interface SignUp {
    public default String Register(){
        return "";
    };
}
