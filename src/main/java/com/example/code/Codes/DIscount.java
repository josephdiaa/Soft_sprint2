package com.example.code.Codes;


import java.util.ArrayList;
import java.time.LocalDateTime;

public  class DIscount {
      GeneralDatabase database = Database.getInstance();
      private Request r;
      private LocalDateTime date;


    public DIscount(Request r,int d,int m) {
        this.r = r;
        DiscountfirstRide(r.getClient(),r.getListOffer());
        DiscountBirthdate(r.getClient(),r.getListOffer());
        DiscountNumPass(r);
        DiscountHoliDay(d,m,r);
        DiscountArea(r.getDestination(),r.getListOffer());
    }
    public void DiscountfirstRide(Client c,ArrayList<Offer> of){
        if(c.isFirstRide()){
            for(int i=0;i<of.size();i++){
                of.get(i).setDiscountedPrice(of.get(i).getDiscountedPrice()-(of.get(i).getPrice()*0.1));
                //of.get(i).setPrice(of.get(i).getPrice()-(of.get(i).getPrice()*0.1));
            }
            c.setFirstRide(false);
        }
    }
    public void DiscountBirthdate(Client c,ArrayList<Offer> of){
        if(c.getDay()==date.now().getDayOfMonth()&&c.getMonth()==date.now().getMonthValue()){
            for(int i=0;i<of.size();i++){
                of.get(i).setDiscountedPrice(of.get(i).getDiscountedPrice()-(of.get(i).getPrice()*0.1));
                //of.get(i).setPrice(of.get(i).getPrice()-(of.get(i).getPrice()*0.1));
            }
        }
    }
    public void DiscountNumPass(Request r1){
        if(r1.getNumPassenger() == 2){
            for(int i=0;i<r1.getListOffer().size();i++){
                r1.getListOffer().get(i).setDiscountedPrice(r1.getListOffer().get(i).getDiscountedPrice()-(r1.getListOffer().get(i).getPrice()*0.05));
            }
        }
    }
    public void DiscountHoliDay(int d,int m,Request r1){
        if(date.now().getDayOfMonth()==d&&date.now().getMonthValue()==m){
            for(int i=0;i<r1.getListOffer().size();i++){
                r1.getListOffer().get(i).setDiscountedPrice(r1.getListOffer().get(i).getDiscountedPrice()-(r1.getListOffer().get(i).getPrice()*0.05));
            }
        }
    };
    public void DiscountArea(Area des,ArrayList<Offer> of){
        if(checkDisArea(des)){
            for(int i=0;i<of.size();i++){
                of.get(i).setDiscountedPrice(of.get(i).getDiscountedPrice()-(of.get(i).getPrice()*0.1));
            }
        }
    }
    double applyDis(double price){return 0;};
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
