package com.example.code.Codes.TripEvent;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;
import java.time.LocalDateTime;

public class acceptEvent implements Event{
    private String Ename;
    private LocalDateTime date;
    private String client;

    public acceptEvent(String ename, LocalDateTime date, String client) {
        Ename = ename;
        this.date = date;
        this.client = client;
    }

    public String getEname() {
        return Ename;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getClient() {
        return client;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
