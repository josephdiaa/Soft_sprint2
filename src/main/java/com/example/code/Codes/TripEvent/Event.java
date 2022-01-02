package com.example.code.Codes.TripEvent;
import java.time.LocalDateTime;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;
public interface  Event {

    public String getEname();

    public LocalDateTime getDate();

    public void setEname(String ename) ;

    public void setDate(LocalDateTime date) ;
}
