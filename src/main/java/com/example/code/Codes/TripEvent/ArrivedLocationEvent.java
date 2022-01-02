package com.example.code.Codes.TripEvent;
import java.time.LocalDateTime;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;
public class ArrivedLocationEvent implements Event{
    private String Ename;
    private LocalDateTime date;
    private String Edriver;
    private String userName;

    public ArrivedLocationEvent(String ename, LocalDateTime date, String edriver, String userName) {
        Ename = ename;
        this.date = date;
        Edriver = edriver;
        this.userName = userName;
    }

    @Override
    public String getEname() {
        return Ename;
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public void setEname(String ename) {
        Ename = ename;
    }

    @Override
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setEdriver(String edriver) {
        Edriver = edriver;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEdriver() {
        return Edriver;
    }

    public String getUserName() {
        return userName;
    }
}
