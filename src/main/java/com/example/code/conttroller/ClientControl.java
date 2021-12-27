package com.example.code.conttroller;
import com.example.code.Codes.Client;
import org.springframework.web.bind.annotation.*;
import com.example.code.Codes.*;
import java.util.ArrayList;


@RestController
public class ClientControl {
    Client Fristclient=new Client("joseph","joseph.diaa@gami.com","123","012");

    @GetMapping("/Client/Register")
    public String RegisterClient(){
        return Fristclient.Register();
    }

    @PostMapping("/Client/RequestRide/{s}/{d}")
    public String RequestRide(@PathVariable String s, @PathVariable String d){
        return Fristclient.requestRide(s,d);
    }
    @GetMapping("/Client/viewOffer")
    public ArrayList<Offer> viewoff()
    {
        return Fristclient.ViewOfferList();
    }
    @PostMapping("/Client/acceptOff")
    public  String acceptoff(@RequestBody int n)
    {
       return Fristclient.AcceptOffer(n);
    }
}
