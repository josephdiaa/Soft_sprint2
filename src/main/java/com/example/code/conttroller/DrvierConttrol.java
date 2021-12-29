package com.example.code.conttroller;
import com.example.code.Codes.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class DrvierConttrol {
    Driver FirstDriver=new Driver("abdo","abdo@gmail.com","147","010","789","174",5);
    Database b=Database.getInstance();

    @GetMapping("/Driver/Register")
    public String RegisterDriver(){
        //FirstDriver.addFavArea(new Area("dokki"));
        return FirstDriver.Register();
    }
    @GetMapping("/Driver/Login")
    public String Login(){
        return FirstDriver.logIn();
    }
    @GetMapping("/Driver/showRequests")
    public ArrayList<Request> show(){
        return FirstDriver.getReqs();
    }

    @PostMapping("/Driver/makeOffer")
    public String makeOff(@RequestBody int id,@RequestBody double pr){
        return FirstDriver.DriverOffer(id,pr);
    }

    @GetMapping("/Driver/viewtrip")
    public  ArrayList<TripEvent> viewTrip()
    {return  b.getEventList();}
}
