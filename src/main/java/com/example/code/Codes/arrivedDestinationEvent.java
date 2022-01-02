package com.example.code.Codes;
import java.time.LocalDateTime;

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
}