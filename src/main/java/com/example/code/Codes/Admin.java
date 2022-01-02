
/**
 * @Class Admin
 * @author Mina
 */
package com.example.code.Codes;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Scanner;
/**
 * @Class Admin
 * @author Mina
 */
public class Admin implements SignIn {

    private String email;
    private String password;
    Database d=Database.getInstance();
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
     * @param id Driver's ID to verify the account
     */
    public String verify(int id){
        for(int i=0;i<d.getRegDriversList().size();i++){
            if(d.getRegDriversList().get(i).getDriver().getID()==id) {
                d.getRegDriversList().get(i).changeStatus(true);
                d.getRegDriversList().remove(d.getRegDriversList().get(i));
                return "Driver with id : " + id + " verified";
            }
        }
        return "Not valid id";
    }

    /**
     *this function to suspend user
     * @param id User's ID(Driver/Client) to be suspended
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
            return "Driver with"+id+"Has been Suspended";
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