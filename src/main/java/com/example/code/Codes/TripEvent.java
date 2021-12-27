package com.example.code.Codes;

import java.util.ArrayList;

public class TripEvent {
    private ArrayList<Event>arr;

    public TripEvent(){
        arr=new ArrayList<Event>();
    }

    public void setArr(ArrayList<Event> arr) {
        this.arr = arr;
    }

    public ArrayList<Event> getArr() {
        return arr;
    }
    public void AddEvent(Event e){
        this.arr.add(e);
    }
}
