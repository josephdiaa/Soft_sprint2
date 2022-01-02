package com.example.code.conttroller;


import com.example.code.Codes.*;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminControl {
    Admin bob = new Admin("bob", "bob123");


    @PostMapping("/Admin/verification/{id}")
    public String verifyDriver(@PathVariable int id) {
        if(check){
            return bob.verify(id);
        }
        else{
            return "You are not Login";
        }
    }

    @GetMapping("/Admin/viweListRegDriver/")
    public ArrayList<RegistrationDriver> viweListRegDriver() {
        if(check){
            return bob.viweListRegDriver();
        }
        else{
            return null;
        }
    }

    @PostMapping("/Admin/Susbend/{id}")
    public String SusbendUser(@PathVariable int id) {
        if(check){
            return bob.suspend(id);
        }
        else{
            return "You are Not logIn";
        }
    }
    @GetMapping("/Driver/viewtrip/{id}")
    public  TripEvent viewTrip(@PathVariable int id)
    {return  bob.viewEvent(id);}
}
