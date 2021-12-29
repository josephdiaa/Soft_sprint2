package com.example.code.conttroller;
import com.example.code.Codes.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class DrvierConttrol {
    Driver FirstDriver=new Driver("abdo","abdo@gmail.com","147","010","789","174",5);
    Database b=Database.getInstance();

    @GetMapping("/Driver/Register")
    public String RegisterDriver(){
        return FirstDriver.Register();
    }
    @PostMapping("/Driver/addFave/{a}")
    public void add(@PathVariable String a){
        FirstDriver.addFavArea(new Area(a));
    }
    @GetMapping("/Driver/Login")
    public String Login(){
        return FirstDriver.logIn();
    }
    @GetMapping("/Driver/showRequests")
    public ArrayList<Request> show(){
        return FirstDriver.getReqs();
    }

    @PostMapping("/Driver/makeOffer/{id}/{pr}")
    public String makeOff(@PathVariable int id, @PathVariable double pr){
        return FirstDriver.DriverOffer(id,pr);
    }

    @GetMapping("/Driver/viewtrip")
    public  ArrayList<TripEvent> viewTrip()
    {return  b.getEventList();}

}
