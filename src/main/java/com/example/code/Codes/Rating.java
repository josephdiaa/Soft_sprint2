
package com.example.code.Codes;

import java.util.ArrayList;

/**
 * @ Class Rating
 * @author Mina
 */
class Rating {
    private ArrayList<Double> arr = new ArrayList<>();
    private double rate;
    private double avgRate;

    /**
     * constructor of rating to set rate
     * @param rate to set the rate
     */
    public Rating(double rate) {
        this.rate = rate;
    }

    /**
     * default constructor
     */
    public Rating() {}

    /**
     * to add the rate in the list of rates
     * @param rate the rate that we want to add it
     */
    public void addRate(double rate)
    {
        if(rate<1) {
            arr.add(0.0);
            updateRating();
        }
        else if(rate>5)
        {
            arr.add(5.0);
            updateRating();
        }
        else
        {
            arr.add(rate);
            updateRating();
        }
    }

    /**
     * to set the array
     * @param arr to set in the array
     */
    public void setArr(ArrayList<Double> arr) {
        this.arr = arr;
    }

    /**
     * to set rate
     * @param rate to set the rate
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * to set the average rate
     * @param avgRate to set the average rate
     */
    public void setAvgRate(double avgRate) {
        this.avgRate = avgRate;
    }

    /**
     * to get the arraye of ratings
     * @return the array of ratings
     */
    public ArrayList<Double> getArr() {
        return arr;
    }

    /**
     * to get rate
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * to get average rate
     * @return the average rate
     */
    public double getAvgRate() {
        return avgRate;
    }

    /**
     * to update the exist rate
     */
    void updateRating(){
        double sum =0;
        for(double r : this.arr)
        {
            sum+= r;
        }
        this.setAvgRate(sum/this.arr.size());
    }
    /**
     * to view the list of the ratings
     */
    public ArrayList<Double> viewRatingsList()
    {
        return  this.arr;
    }
}
