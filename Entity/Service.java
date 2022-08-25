/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manhchelsea
 */
public class Service {

    private String SerID;
    private String SerName;
    private Double prices;

    public Service(String SerID, String SerName, Double prices) {
        this.SerID = SerID;
        this.SerName = SerName;
        this.prices = prices;
    }

    public Service() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSerID() {
        return SerID;
    }

    public void setSerID(String SerID) {
        this.SerID = SerID;
    }

    public String getSerName() {
        return SerName;
    }

    public void setSerName(String SerName) {
        this.SerName = SerName;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }
    
}