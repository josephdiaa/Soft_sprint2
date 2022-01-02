
package com.example.code.Codes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
/**
 * @ Class Request
 * @author joseph
 */
public class Request  {
    private Area source;
    private Area destination;
    private Client client;
    private Driver driver;
    private int numPassenger;
    private ArrayList<Offer>listOffer=new ArrayList<Offer>();
    private TripEvent rEvent=new TripEvent();
    static private int num=0;
    private int idd;

    /**
     * Default Constructor
     */
    public Request( ){
    }
    public  void addToTripEvent(Event e)
    {
        this.rEvent.AddEvent(e);

    }
    public void addOff(Offer of)
    {
        this.listOffer.add(of);
    }

    public int getId() {
        return idd;
    }

    public Area getSource() {
        return source;
    }

    public void setrEvent(TripEvent rEvent) {
        this.rEvent = rEvent;
    }
    @JsonIgnore
    @JsonProperty(value = "rEvent")
    public TripEvent getrEvent() {
        return rEvent;
    }

    public Area getDestination() {
        return destination;
    }


    public Client getClient() {
        return client;
    }

    @JsonIgnore
    @JsonProperty(value = "driver")
    public Driver getDriver() {
        return driver;
    }
    @JsonIgnore
    @JsonProperty(value = "listOffer")
    public ArrayList<Offer> getListOffer() {
        return listOffer;
    }


    public void setSource(Area source) {
        this.source = source;
    }

    public void setDestination(Area destination) {
        this.destination = destination;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setListOffer(ArrayList<Offer> listOffer) {
        this.listOffer = listOffer;
    }

    /**
     * Parametrize Constructor
     * @param a1 Source Area
     * @param a2 destination Area
     * @param c client
     */
    public Request(Area a1, Area a2 , Client c ,int np){
        this.source = a1;
        this.destination =a2;
        this.client  = c;
        this.numPassenger=np;
        num++;
        idd = num;
        rEvent.settripId(idd);
        notify2();
    }

    public void setNumPassenger(int numPassenger) {
        this.numPassenger = numPassenger;
    }

    public int getNumPassenger() {
        return numPassenger;
    }

    /**
     * This Function To notify Drivers throw Trip Manger
     */
    public void notify2() {
        TripManager tm = new TripManager();
        tm.noftifyDrivers(this);
    }

    /**
     * This function to get Request's Data
     * @return Request's Data
     */
    @Override
    public String toString() {
        return "Request{" +
                "source=" + source +
                        ", destination=" + destination +
                ", idd=" + idd +
                '}';
    }
}