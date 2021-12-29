package com.example.code.conttroller;
import com.example.code.Codes.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class hello {
    Database b=Database.getInstance();
    @PostMapping("/name")
    public void setname(@RequestBody String s){
        b.set(s);
    }

    @GetMapping("/supsUser")
    public ArrayList<String> getsups(){
       return b.getSuspUser();
    }
    @GetMapping("/getRide")
    public ArrayList<Request>getride(){
      Driver d=new Driver("jo","jo@","123","010","147","159",5);
      Area a1=new Area("helwan");
      Area a2=new Area("Dokki");
      Client c=new Client("joker","Joker@","123","0128");
      Request r=new Request(a1,a2,c,2);
      d.AddReq(r);
      return d.getReqs();
    }
}
