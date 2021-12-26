package com.example.code.Codes;

import java.util.ArrayList;

public class TripEvent {
    private ArrayList<Event>arr;

    public TripEvent(){
        arr=new ArrayList<Event>(4);
    }

    public void setArr(ArrayList<Event> arr) {
        this.arr = arr;
    }

    public ArrayList<Event> getArr() {
        return arr;
    }
}
