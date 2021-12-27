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
    public String verifyDriver(@PathVariable int id)
    {
        return bob.verify(id);
    }
}
