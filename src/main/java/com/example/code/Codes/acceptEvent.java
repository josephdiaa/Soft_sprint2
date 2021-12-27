package com.example.code.Codes;

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
