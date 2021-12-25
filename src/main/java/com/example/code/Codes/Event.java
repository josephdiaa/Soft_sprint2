package com.example.code.Codes;
import java.time.LocalDateTime;
public interface  Event {

    public String getEname();

    public LocalDateTime getDate();

    public void setEname(String ename) ;

    public void setDate(LocalDateTime date) ;
}
