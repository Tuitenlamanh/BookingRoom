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
public class Roomtype {

    String typeID;
    String typeName;
    Double price;

    public Roomtype(String typeID, String typeName, Double price) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.price = price;
    }

    public Roomtype() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public String gettypeID(){
        return typeID;
    }
    public void settypeID(String t){
        typeID = t;
    }
    public String gettypeName(){
        return typeName;
    }
    public void settypeName(String t){
        typeName = t;
    }
    public Double getprice(){
        return price;
    }
    public void setprice(Double t){
        price = t;
    }
    
}
