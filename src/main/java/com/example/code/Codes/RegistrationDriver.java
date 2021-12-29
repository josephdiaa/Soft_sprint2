
package com.example.code.Codes;
/**
 * @ Class RegistrationDriver
 * @author joseph diaa
 */
public class RegistrationDriver {
    private boolean status;
    private Driver driver;

    /**
     * to get the driver who want to register
     * @param driver to set the driver
     * @param status to set the status
     */
    public RegistrationDriver( Driver driver,boolean status) {
        this.status = status;
        this.driver = driver;
    }

    /**
     * change status of the registeration
     * @param check to change the status
     */
    public void changeStatus(boolean check){
        this.status=check;
        if(check){
            driver.changeDriverStatus(true);
        }
    }

    /**
     * to print the registeration driver data
     * @return the registeration driver data
     */
    @Override
    public String toString() {
        return "RegistrationDriver{" +'\n'+
                "status=" + status +'\n'+
                driver ;
    }
}