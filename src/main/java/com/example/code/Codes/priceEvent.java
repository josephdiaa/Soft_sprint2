package com.example.code.Codes;
import java.time.LocalDateTime;
public class priceEvent implements Event{
    private String Ename;
    private LocalDateTime date;
    private Driver Edriver;
    private double price;

    public priceEvent(String ename, Driver edriver, LocalDateTime date, double price) {
        Ename = ename;
        Edriver = edriver;
        this.date = date;
        this.price = price;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public void setEdriver(Driver edriver) {
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

    public Driver getEdriver() {
        return Edriver;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }
}
