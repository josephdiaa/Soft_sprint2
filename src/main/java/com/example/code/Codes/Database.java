
package com.example.code.Codes;


import javax.xml.crypto.Data;
import java.util.ArrayList;
/**
 * @Class DataBase
 * @author Abanoub
 */
public class Database implements GeneralDatabase {
    private static Database inst;
    private ArrayList<Client> ClientList = new ArrayList<Client>();
    private ArrayList<Driver> DriverList = new ArrayList<Driver>();
    private ArrayList<Admin> AdminList = new ArrayList<Admin>();
    private ArrayList<RegistrationDriver>regDriversList=new ArrayList<RegistrationDriver>();
    private ArrayList<Driver> penDriver=new ArrayList<Driver>();
    private ArrayList<String> SuspUser=new ArrayList<String>();
    private ArrayList<TripEvent> EventList=new ArrayList<TripEvent>();

    public ArrayList<TripEvent> getEventList() {
        return EventList;
    }

    private Database() {}
    public static Database getInstance(){
        if(inst==null){
            inst=new Database();
        }
        return inst;
    }

    /**
     * update to database
     */
     public void update() {
    }

    /**
     * delete from database
     */
    public void delete() {
    }

    /**
     * set to database
     */
    public void set(String name) {
        SuspUser.add(name);
    }

    /**
     * get from database
     */
    public void get() {

    }

    /**
     * to get client list
     * @return list of clients
     */
    public  ArrayList<Client> getClientList() {
        return ClientList;
    }

    /**
     * to get Driver's list
     * @return list of drivers
     */
    public  ArrayList<Driver> getDriverList() {
        return DriverList;
    }

    /**
     * to get list of admins
     * @return list of admins
     */
    public  ArrayList<Admin> getAdminList() {
        return AdminList;
    }

    /**
     * to get registeration Drivers list
     * @return list of registeration driver
     */
    public  ArrayList<RegistrationDriver> getRegDriversList() {
        return regDriversList;
    }

    /**
     * to get list of pending drivers
     * @return list of pending drivers
     */
    public  ArrayList<Driver> getPenDriver() {
        return penDriver;
    }

    /**
     * to get suspended user
     * @return suspended user
     */
    public  ArrayList<String> getSuspUser() {
        return SuspUser;
    }
}

