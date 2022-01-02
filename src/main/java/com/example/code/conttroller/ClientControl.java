package com.example.code.conttroller;
import com.example.code.Codes.ActorSubSystem.Client;
import com.example.code.Codes.DataBaseSubSystem.Database;
import com.example.code.Codes.DataBaseSubSystem.GeneralDatabase;
import com.example.code.Codes.PriceSubSystem.Offer;
import org.springframework.web.bind.annotation.*;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;

import java.util.ArrayList;


@RestController
public class ClientControl {
    GeneralDatabase b= Database.getInstance();
    Client Fristclient=null;

    @PostMapping("/Client/login/{email}/{pass}/")
    public String login(@PathVariable String email, @PathVariable String pass) {
        Client c = new Client(email, pass);
        if(c.logIn().equalsIgnoreCase("LogIn Successful")){
            Fristclient=b.matchClient(email,pass);
            b.addLoginCLient(Fristclient);
            return Fristclient.logIn();
        }
        else
        {
            return c.logIn();
        }

    }
    @GetMapping("/Client/Register")
    public String RegisterClient(@RequestBody Client c){
        return c.Register();
    }
    @GetMapping("/Client/ViewList")
    public ArrayList<Client> viewListClient(){
        return  b.getClientList();
    }
    @PostMapping("/Client/{id}/RequestRide/{s}/{d}")
    public String RequestRide(@PathVariable String s, @PathVariable String d,@PathVariable int id){
        Fristclient=b.searchLogClient(id);
        if(Fristclient!=null){
            return Fristclient.requestRide(s,d,2);
        }
        else{
            return "You are not login";
        }
    }
    @GetMapping("/Client/{id}/viewOffer")
    public ArrayList<Offer> viewoff(@PathVariable int id) {
        Fristclient=b.searchLogClient(id);
        if(Fristclient!=null){
            return Fristclient.ViewOfferList();
        }
        else{
            return null;
        }

    }
    @PostMapping("/Client/{id}/acceptOff")
    public  String acceptoff(@RequestBody int n,@PathVariable int id) {
        Fristclient=b.searchLogClient(id);
        if(Fristclient!=null){
            return Fristclient.AcceptOffer(n);
        }
        else{
            return "You are not login";
        }

    }

    @GetMapping("/Client/{id}/viewClient")
    public String logOutClient(@PathVariable int id) {
        Fristclient=b.searchLogClient(id);
        if(Fristclient!=null){
            return Fristclient.logOutCleint(Fristclient);
        }
        else{
            return "You are not login";
        }
    }
    @GetMapping("/Client/{id}/view")
    public Client view(@PathVariable int id){
        Fristclient=b.searchLogClient(id);
        if(Fristclient!=null){
            return Fristclient;
        }
        else{
            return null;
        }
    }
    @GetMapping("/Client/{idC}/showAvgrate/{idD}")
    public double showAvg(@PathVariable int idc , @PathVariable int idD)
    {
        return b.matchDriver(idD).showAvgRate();
    }
    @GetMapping("/Client/{idC}/rateDriver/{idD}/{rate}")
    public String rateDriver(@PathVariable int idC ,@PathVariable int idD , @PathVariable double rate)
    {
        Fristclient=b.searchLogClient(idC);
        if(Fristclient!=null){
            return Fristclient.rateDriver(b.matchDriver(idD) , rate);        }
        else{
            return null;
        }

    }

}
