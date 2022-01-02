
/**
 * @Class Admin
 * @author Mina
 */
package com.example.code.Codes.ActorSubSystem;
import com.example.code.Codes.RequestTripmangerSubSystem.Area;
import com.example.code.Codes.DataBaseSubSystem.Database;
import com.example.code.Codes.DataBaseSubSystem.GeneralDatabase;
import com.example.code.Codes.DriverproperiesSubSystem.RegistrationDriver;
import com.example.code.Codes.TripEvent.TripEvent;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;

import java.util.ArrayList;

/**
 * @Class Admin
 * @author Mina
 */
public class Admin implements SignIn {

    private String email;
    private String password;
    GeneralDatabase d= Database.getInstance();
    private ArrayList<RegistrationDriver> list;

    public Admin() {}

    public TripEvent viewEvent(int id){
        for(int i=0;i<d.getEventList().size();i++){
            if(d.getEventList().get(i).gettripId()==id){
                return d.getEventList().get(i);
            }
        }
        return null;
    }
    public String addDisArea(Area a)
    {
        d.addDisArea(a);
        return "Area  is added ";
    }

    /**
     *Admin's constructor to set his email and password
     * @param e Admin's email
     * @param p Admin's password
     */
    public Admin(String e,String p) {
        this.email=e;
        this.password=p;
        d.getAdminList().add(this);
    }

    /**
     * this function to view the list of registeration drivers
     */
    public ArrayList<RegistrationDriver> viweListRegDriver(){
        return d.getRegDriversList();
    };

    /**
     *this function to verify the driver's account
     * @param id com.example.code.Codes.DriverproperiesSubSystem.Driver's ID to verify the account
     */
    public String verify(int id){
        for(int i=0;i<d.getRegDriversList().size();i++){
            if(d.getRegDriversList().get(i).getDriver().getID()==id) {
                d.getRegDriversList().get(i).changeStatus(true);
                d.getRegDriversList().remove(d.getRegDriversList().get(i));
                return "com.example.code.Codes.DriverproperiesSubSystem.Driver with id : " + id + " verified";
            }
        }
        return "Not valid id";
    }

    /**
     *this function to suspend user
     * @param id User's ID(com.example.code.Codes.DriverproperiesSubSystem.Driver/Client) to be suspended
     */
    public String suspend(int id){
        boolean checkD=false,checkC=false;
        for(int i=0;i<d.getDriverList().size();i++){
            if(d.getDriverList().get(i).getID()==id){
                d.getSuspUser().add(d.getDriverList().get(i).getEmail());
                d.getDriverList().remove(d.getDriverList().get(i));
                checkD=true;
            }
            if(d.getClientList().get(i).getID()==id){
                d.getSuspUser().add(d.getClientList().get(i).getEmail());
                d.getClientList().remove(d.getClientList().get(i));
                checkC=true;
            }
        }
        if(checkC&&!checkD){
            return "Client with"+id+"Has been Suspended";
        }
        else {
            return "com.example.code.Codes.DriverproperiesSubSystem.Driver with"+id+"Has been Suspended";
        }
    };

    /**
     *this function to set email
     * @param email to set Admin's email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *this function to set password
     * @param password to set Admin's password
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * this function to set array list of registeration Drivers
     * @param list list of registeration Drivers
     */
    public void setList(ArrayList<RegistrationDriver> list) {
        this.list = list;
    }

    /**
     * to add another admin
     * @param e email of the new admin
     * @param p password of the new admin
     */
    public void addAdmin(String e, String p){
        Admin a=new Admin(e,p);
        d.getAdminList().add(a);
    }

    /**
     * this function is created to log in as admin
     * @return 2: if the admin login successfully
     *         3: if the admin not registered
     */
    public  String logIn() {
        boolean flag = false;
        for(int i=0; i< d.getAdminList().size() ;i++)
        {
            if(this.email.equals(d.getAdminList().get(i).email)&& this.password.equals(d.getAdminList().get(i).password)){
                flag = true;
            }
        }
      if(flag){
          return "LogIn Successful";
      }
      else{
          return "You are admin";
      }
    }
 
}