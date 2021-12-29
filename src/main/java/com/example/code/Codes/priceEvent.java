package com.example.code.Codes;
import java.time.LocalDateTime;



public class priceEvent implements Event{
    private String Ename;
    private LocalDateTime date;
    private String Edriver;
    private double price;
    private Request req ;




    public priceEvent(String ename, String driverName, LocalDateTime date, double price)
    {
        Ename = ename;
        Edriver = driverName;
        this.date = date;
        this.price = price;
    }


    public void setEname(String ename) {
        Ename = ename;
    }


    public void setEdriver(String edriver) {
        Edriver = edriver;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public String getEname() {
        return Ename;
    }


    public String getEdriver() {
        return Edriver;
    }


    public LocalDateTime getDate() {
        return date;
    }


    public double getPrice() {
        return price;
    }

}
