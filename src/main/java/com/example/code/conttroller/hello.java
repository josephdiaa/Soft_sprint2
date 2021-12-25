package com.example.code.conttroller;
import com.example.code.Codes.Database;
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
}
