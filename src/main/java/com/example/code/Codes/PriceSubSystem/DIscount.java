package com.example.code.Codes.PriceSubSystem;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;

import com.example.code.Codes.ActorSubSystem.Client;
import com.example.code.Codes.DataBaseSubSystem.Database;
import com.example.code.Codes.DataBaseSubSystem.GeneralDatabase;
import com.example.code.Codes.PriceSubSystem.Offer;
import com.example.code.Codes.RequestTripmangerSubSystem.Area;
import com.example.code.Codes.RequestTripmangerSubSystem.Request;

import java.util.ArrayList;
import java.time.LocalDateTime;

public  class DIscount {
      GeneralDatabase database = Database.getInstance();
      private Request r;
      private LocalDateTime date;
      private Driver dri;


    public DIscount(Request r,int d,int m,Driver dr) {
        this.r = r;
        this.dri=dr;
        DiscountfirstRide(r.getClient(),r.getListOffer());
        DiscountBirthdate(r.getClient(),r.getListOffer());
        DiscountNumPass(r);
        DiscountHoliDay(d,m,r);
        DiscountArea(r.getDestination(),r.getListOffer());
    }
    public void DiscountfirstRide(Client c, ArrayList<Offer> of){
        if(c.isFirstRide()){
            for(int i=0;i<of.size();i++){
                if(dri.getID()==of.get(i).getDriver().getID()){
                    of.get(i).setDiscountedPrice(of.get(i).getDiscountedPrice()-(of.get(i).getPrice()*0.1));
                }
            }
        }
    }
    public void DiscountBirthdate(Client c,ArrayList<Offer> of){
        if(c.getDay()==date.now().getDayOfMonth()&&c.getMonth()==date.now().getMonthValue()){
            for(int i=0;i<of.size();i++){
                if(dri.getID()==of.get(i).getDriver().getID()){
                    of.get(i).setDiscountedPrice(of.get(i).getDiscountedPrice()-(of.get(i).getPrice()*0.1));
                }
            }
        }
    }
    public void DiscountNumPass(Request r1){
        if(r1.getNumPassenger() == 2){
            for(int i=0;i<r1.getListOffer().size();i++){
                if(dri.getID()==r1.getListOffer().get(i).getDriver().getID()){
                    r1.getListOffer().get(i).setDiscountedPrice(r1.getListOffer().get(i).getDiscountedPrice()-(r1.getListOffer().get(i).getPrice()*0.05));
                }
            }
        }
    }
    public void DiscountHoliDay(int d,int m,Request r1){
        if(date.now().getDayOfMonth()==d&&date.now().getMonthValue()==m){
            for(int i=0;i<r1.getListOffer().size();i++){
                if(dri.getID()==r1.getListOffer().get(i).getDriver().getID()){
                    r1.getListOffer().get(i).setDiscountedPrice(r1.getListOffer().get(i).getDiscountedPrice()-(r1.getListOffer().get(i).getPrice()*0.05));
                }
            }
        }
    }
    public void DiscountArea(Area des, ArrayList<Offer> of){
        if(checkDisArea(des)){
            for(int i=0;i<of.size();i++){
                if(dri.getID()==of.get(i).getDriver().getID()){
                    of.get(i).setDiscountedPrice(of.get(i).getDiscountedPrice()-(of.get(i).getPrice()*0.1));
                }
            }
        }
    }
    double applyDis(double price){return 0;}
    boolean checkDisArea(Area a) {
          for(Area b : database.getDiscountAreas() )
          {
              if(a.getName() == b.getName())
              {
               return  true;
              }
          }
          return  false;
      }

}
