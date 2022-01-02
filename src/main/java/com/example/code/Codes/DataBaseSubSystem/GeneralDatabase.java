
package com.example.code.Codes.DataBaseSubSystem;

import com.example.code.Codes.ActorSubSystem.Admin;
import com.example.code.Codes.ActorSubSystem.Client;
import com.example.code.Codes.DriverproperiesSubSystem.RegistrationDriver;
import com.example.code.Codes.RequestTripmangerSubSystem.Area;
import com.example.code.Codes.TripEvent.TripEvent;
import com.example.code.Codes.RequestTripmangerSubSystem.*;
import com.example.code.Codes.ActorSubSystem.*;
import com.example.code.Codes.DriverproperiesSubSystem.*;
import com.example.code.Codes.DataBaseSubSystem.*;
import com.example.code.Codes.PriceSubSystem.*;
import com.example.code.Codes.TripEvent.*;

import java.util.ArrayList;

/**
 * @ InterFace GeneralDatabase
 * @author Renad
 */
public interface GeneralDatabase {

    public void addInRegDriversList(RegistrationDriver r);
    public void addTripEvent(TripEvent t);
    public Driver matchDriver(int id);
    public Driver matchDriver(String em, String pas);
    public Client matchClient(String em, String pas);
    public Driver searchLogDriver(int id);
    public Client searchLogClient(int id);
    public ArrayList<String> getSuspUser();
    public ArrayList<Driver> getPenDriver();
    public ArrayList<RegistrationDriver> getRegDriversList();
    public ArrayList<Admin> getAdminList();
    public ArrayList<Driver> getDriverList();
    public ArrayList<Client> getClientList();
    public ArrayList<Driver> getLoginDriver();
    public ArrayList<Client> getLoginClient();
    public ArrayList<TripEvent> getEventList();
    public ArrayList<Area> getDiscountAreas();
    public String logOutDriver(Driver u);
    public void removeDriver(Driver d);
    public void removeClient(Client c);
    public void addLoginDriver(Driver d);
    public void addLoginCLient(Client u);
    public void addDisArea(Area a);
    public void addtoPenlist(Driver d);
    public void addClient(Client c);
}
