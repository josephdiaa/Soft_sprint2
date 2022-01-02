
package com.example.code.Codes.DataBaseSubSystem;


import com.example.code.Codes.ActorSubSystem.Admin;
import com.example.code.Codes.ActorSubSystem.Client;
import com.example.code.Codes.DriverproperiesSubSystem.RegistrationDriver;
import com.example.code.Codes.RequestTripmangerSubSystem.Area;
import com.example.code.Codes.TripEvent.TripEvent;
import com.example.code.Codes.DriverproperiesSubSystem.Driver;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;

import java.util.ArrayList;

/**
 * @author Abanoub
 * @Class DataBase
 */
public class Database implements GeneralDatabase {
    private static Database inst;
    private ArrayList<Client> ClientList = new ArrayList<Client>();
    private ArrayList<Driver> DriverList = new ArrayList<Driver>();
    private ArrayList<Admin> AdminList = new ArrayList<Admin>();
    private ArrayList<RegistrationDriver> regDriversList = new ArrayList<RegistrationDriver>();
    private ArrayList<Driver> penDriver = new ArrayList<Driver>();
    private ArrayList<String> SuspUser = new ArrayList<String>();
    private ArrayList<TripEvent> EventList = new ArrayList<TripEvent>();
    private ArrayList<Area> DiscountAreas = new ArrayList<Area>();
    private ArrayList<Client> loginClient = new ArrayList<Client>();
    private ArrayList<Driver> loginDriver = new ArrayList<Driver>();


    public void addtoPenlist(Driver d) {
        this.penDriver.add(d);
    }

    public void addDisArea(Area a) {
        DiscountAreas.add(a);
    }

    public void addLoginCLient(Client u) {
        loginClient.add(u);
    }

    public void addLoginDriver(Driver d) {
        loginDriver.add(d);
    }

    public void removeClient(Client c) {
        loginClient.remove(c);
    }

    public void removeDriver(Driver d) {
        loginDriver.remove(d);
    }

    public String logOutDriver(Driver u) {
        loginDriver.remove(u);
        return "log out Successful";
    }

    public ArrayList<Area> getDiscountAreas() {
        return DiscountAreas;
    }

    public ArrayList<TripEvent> getEventList() {
        return EventList;
    }

    public ArrayList<Client> getLoginClient() {
        return loginClient;
    }

    public ArrayList<Driver> getLoginDriver() {
        return loginDriver;
    }

    private Database() {
    }

    public static Database getInstance() {
        if (inst == null) {
            inst = new Database();
        }
        return inst;
    }

    /**
     * to get client list
     *
     * @return list of clients
     */
    public ArrayList<Client> getClientList() {
        return ClientList;
    }

    public void addClient(Client c) {
        ClientList.add(c);
    }

    /**
     * to get com.example.code.Codes.DriverproperiesSubSystem.Driver's list
     *
     * @return list of drivers
     */
    public ArrayList<Driver> getDriverList() {
        return DriverList;
    }

    /**
     * to get list of admins
     *
     * @return list of admins
     */
    public ArrayList<Admin> getAdminList() {
        return AdminList;
    }

    /**
     * to get registeration Drivers list
     *
     * @return list of registeration driver
     */
    public ArrayList<RegistrationDriver> getRegDriversList() {
        return regDriversList;
    }

    /**
     * to get list of pending drivers
     *
     * @return list of pending drivers
     */
    public ArrayList<Driver> getPenDriver() {
        return penDriver;
    }

    /**
     * to get suspended user
     *
     * @return suspended user
     */
    public ArrayList<String> getSuspUser() {
        return SuspUser;
    }

    public Client searchLogClient(int id) {
        for (int i = 0; i < this.getLoginClient().size(); i++) {
            if (this.getLoginClient().get(i).getID() == id) {
                return this.getLoginClient().get(i);
            }
        }
        return null;
    }

    public Driver searchLogDriver(int id) {
        for (int i = 0; i < this.getLoginDriver().size(); i++) {
            if (this.getLoginDriver().get(i).getID() == id) {
                return this.getLoginDriver().get(i);
            }
        }
        return null;
    }

    public Client matchClient(String em, String pas) {
        for (int i = 0; i < this.getClientList().size(); i++) {
            if (this.getClientList().get(i).getEmail().equals(em)) {
                if (this.getClientList().get(i).getPassword().equals(pas)) {
                    return this.getClientList().get(i);
                }
            }
        }
        return null;
    }

    public Driver matchDriver(String em, String pas) {
        for (int i = 0; i < this.getDriverList().size(); i++) {
            if (this.getDriverList().get(i).getEmail().equals(em)) {
                if (this.getDriverList().get(i).getPassword().equals(pas)) {
                    return this.getDriverList().get(i);
                }
            }
        }
        return null;
    }

    public Driver matchDriver(int id) {
        for (int i = 0; i < this.getDriverList().size(); i++) {
            if (this.getDriverList().get(i).getID() == id) {
                return this.getDriverList().get(i);
            }
        }
        return null;
    }

    public void addTripEvent(TripEvent t) {
        EventList.add(t);
    }

    public void addInRegDriversList(RegistrationDriver r) {
        regDriversList.add(r);
    }
}

