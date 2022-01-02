package com.example.code.conttroller;
import com.example.code.Codes.DataBaseSubSystem.Database;
import com.example.code.Codes.DataBaseSubSystem.GeneralDatabase;
import com.example.code.Codes.RequestTripmangerSubSystem.Area;
import com.example.code.Codes.RequestTripmangerSubSystem.Request;
import org.springframework.web.bind.annotation.*;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;


import java.util.ArrayList;
@RestController
public class DriverControl {
    GeneralDatabase b= Database.getInstance();
    Driver FirstDriver=null;


    @GetMapping("/Driver/Login/{email}/{pass}/")
    public String Login(@PathVariable String email , @PathVariable String pass){
        Driver c = new Driver(email, pass);
        if(c.logIn().equalsIgnoreCase("LogIn Successful")){
            FirstDriver=b.matchDriver(email,pass);
            b.addLoginDriver(FirstDriver);
            return FirstDriver.logIn();
        }
        else
        {
            return c.logIn();
        }
    }

    @GetMapping("/Driver/Register")
    public String RegisterDriver(@RequestBody Driver drive){
        return drive.Register();
    }

    @PostMapping("/Driver/{id}/addFave/{a}")
    public String add(@PathVariable String a,@PathVariable int id){
        FirstDriver=b.searchLogDriver(id);
        if(FirstDriver!=null){
            return FirstDriver.addFavArea(new Area(a));
        }
        else{
            return "You are not login";
        }
    }
    @GetMapping("/Driver/{id}/showRequests")
    public ArrayList<Request> show(@PathVariable int id){
        FirstDriver=b.searchLogDriver(id);
        if(FirstDriver!=null){
            return FirstDriver.getReqs();
        }
        else{
            return null;
        }

    }

    @PostMapping("/Driver/{idD}/makeOffer/{pr}/{idC}")
    public String makeOff(@PathVariable int idD, @PathVariable double pr,@PathVariable int idC){
        FirstDriver=b.searchLogDriver(idD);
        if(FirstDriver!=null){
            return FirstDriver.DriverOffer(idC,pr);
        }
        else{
            return "You are not login";
        }
    }

    @GetMapping("/Driver/{id}/viewRatings")
    public ArrayList<Double>viewRating(@PathVariable int id){
        FirstDriver=b.searchLogDriver(id);
        if(FirstDriver!=null){
            return FirstDriver.showRates();
        }
        else{
            return null;
        }
    }

    @GetMapping("/Driver/{id}/arrivedLocation")
    public String arrivedLocation(@PathVariable int id){
        FirstDriver=b.searchLogDriver(id);
        if(FirstDriver!=null){
            return FirstDriver.ArriveLocation(FirstDriver.getCurrentRequest());
        }
        else{
            return null;
        }
    }
    @GetMapping("/Driver/{id}/arrivedDestination")
    public String arrivedDest(@PathVariable int id){
        FirstDriver=b.searchLogDriver(id);
        if(FirstDriver!=null){
            return FirstDriver.endRide(FirstDriver.getCurrentRequest());
        }
        else{
            return null;
        }
    }


}
