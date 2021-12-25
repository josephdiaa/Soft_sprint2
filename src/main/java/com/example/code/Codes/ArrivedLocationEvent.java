package com.example.code.Codes;
import java.time.LocalDateTime;
public class ArrivedLocationEvent implements Event{
    private String Ename;
    private LocalDateTime date;
    private Driver Edriver;
    private String userName;

    public ArrivedLocationEvent(String ename, LocalDateTime date, Driver edriver, String userName) {
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

    public void setEdriver(Driver edriver) {
        Edriver = edriver;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Driver getEdriver() {
        return Edriver;
    }

    public String getUserName() {
        return userName;
    }
}
