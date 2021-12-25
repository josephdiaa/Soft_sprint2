package com.example.code.Codes;
import java.time.LocalDateTime;

public class arrivedDestinationEvent implements Event {

    private String Ename;
    private LocalDateTime date;
    private Driver Edriver;
    private String userName;

    public arrivedDestinationEvent(String Ename, LocalDateTime date, Driver Edriver, String userName) {
        this.Ename = Ename;
        this.userName = userName;
        this.Edriver = Edriver;
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
}