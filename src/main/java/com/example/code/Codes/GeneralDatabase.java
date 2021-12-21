
package com.example.code.Codes;
/**
 * @ InterFace GeneralDatabase
 * @author Renad
 */
public interface GeneralDatabase {
    /**
     * update to database
     */
    public void update();


    /**
     * delete from database
     */
    public void delete();

    /**
     * set to database
     */
    public void set(String name);

    /**
     * get from database
     */
    public void get();
}
