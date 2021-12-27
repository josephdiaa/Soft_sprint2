
/**
 * @Class Admin
 * @author Mina
 */
package com.example.code.Codes;
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

    protected String email;
    protected String password;
    Database d=Database.getInstance();
    protected ArrayList<RegistrationDriver> list;

    /**
     *Admin's constructor to set his email and password
     * @param e Admin's email
     * @param p Admin's password
     */
    public Admin(String e,String p) {
        this.email=e;
        this.password=p;
    }

    /**
     * this function to view the list of registeration drivers
     */
    public void viweListRegDriver(){
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<d.getRegDriversList().size();i++){
            System.out.println(d.getRegDriversList().get(i));
        }
        while(d.getRegDriversList().size() >= 1){
            System.out.println("Please Enter Driver ID You want to verify ");
            int s=sc.nextInt();
            verify(s);
            System.out.println("Do You want to Continue ? (Yes/No)");
            String st=sc.next();
            if(st.equalsIgnoreCase("yes")){
                continue;
            }
            else if(st.equalsIgnoreCase("No")){
                System.out.println("Thank You For verify");
                break;
            }
            else{
                System.out.println("Wrong Input");
            }
        }
        if(d.getRegDriversList().size()==0){
            System.out.println("This is Last Registration Thank You Admin :)");
        }
    };

    /**
     *this function to verify the driver's account
     * @param id Driver's ID to verify the account
     */
    public void verify(int id){
        for(int i=0;i<d.getRegDriversList().size();i++){
            if(d.getRegDriversList().get(i).driver.ID==id){
                d.getRegDriversList().get(i).changeStatus(true);
                d.getRegDriversList().remove(d.getRegDriversList().get(i));
                break;
            }
        }
    }

    /**
     *this function to suspend user
     * @param id User's ID(Driver/Client) to be suspended
     */
    public void suspend(int id){
        for(int i=0;i<d.getDriverList().size();i++){
            if(d.getDriverList().get(i).ID==id){
                d.getSuspUser().add(d.getDriverList().get(i).email);
                d.getDriverList().remove(d.getDriverList().get(i));
            }
            if(d.getClientList().get(i).ID==id){
                d.getSuspUser().add(d.getClientList().get(i).email);
                d.getClientList().remove(d.getClientList().get(i));
            }
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
    public String logIn() {
        boolean flag = false;
        for(int i=0; i< d.getAdminList().size() ;i++)
        {
            if(this.email.equals(d.getAdminList().get(i).email)&& this.password.equals(d.getAdminList().get(i).password))
                flag = true;
        }
        if(flag==true){
            return "Successful login";
        }
        else{
            return "You are not admin";
        }
    }

}