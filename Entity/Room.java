/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author manhchelsea
 */
public class Room {

    private String roomID;
    private Roomtype type;
    private Service ser;

    public Room(String roomID, Roomtype type, Service ser) {
        this.roomID = roomID;
        this.type = type;
        this.ser = ser;
    }
    
    public Room(){
        
    }
    public String getroomID(){
        return roomID;
    }
    public void setroomID(String room){
        roomID = room;
    }
    public Roomtype getroomtype(){
        return type;
    }
    public void setroomtype(Roomtype room){
        type = room;
    }
    public Service getservice(){
        return ser;
    }
    public void setservice(Service room){
        ser = room;
    }

}

