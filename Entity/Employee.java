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
public class Employee extends Person {

    private String role;

//    public Employee(String role, Date startdate, Date numberofworkings, String id, String fullame, String phone, Date DoB, String email) {
//        super(id, fullame, phone, DoB, email);
//        this.role = role;
//        this.startdate = startdate;
//        this.numberofworkings = numberofworkings;
//    }
    

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}