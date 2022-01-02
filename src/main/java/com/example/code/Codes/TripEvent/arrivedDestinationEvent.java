package com.example.code.Codes.TripEvent;
import java.time.LocalDateTime;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;

public class arrivedDestinationEvent implements Event {

    private String Ename;
    private LocalDateTime date;
    private String Edriver;
    private String userName;

    public arrivedDestinationEvent(String Ename, LocalDateTime date, String edriver, String UserName) {
        this.Ename = Ename;
        this.userName = UserName;
        this.Edriver = edriver;
        this.date = date;
    }
    @Override
    public String getEname() {
        return this.Ename;
    }

    @Override
    public LocalDateTime getDate() {
        return this.date;
    }

    @Override
    public void setEname(String ename) {
        Ename=ename;
    }

    @Override
    public void setDate(LocalDateTime date) {
        this.date=date;
    }


    public String getEdriver() {
        return Edriver;
    }

    public String getUserName() {
        return userName;
    }
}