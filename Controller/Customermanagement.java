/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Customer;
import Entity.Person;
import Entity.Service;
import Interface.Action;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manhchelsea
 */
public class Customermanagement implements Action<Customer> {

    @Override
    public Customer AddItem(ArrayList<Customer> items) {
        Customer cus = new Customer();
        Scanner s = new Scanner(System.in);
        boolean check = false;
        String id;
        do{
            System.out.println("Enter ID Customer: ");
            id = s.nextLine();
            for (int i = 0; i < items.size(); i++) {
                if((items.get(i).getId()).equals(id)){
                    System.out.println("ID already exists, please enter another ID!");
                    check = true;
                }
                else{
                    check = false;
                }
            }
        }while(check);
        cus.setId(id);
        System.out.println("Enter name of customer: ");
        cus.setFullame(s.nextLine());
        System.out.println("Enter phone number of customer: ");
        cus.setPhone(s.nextLine());
        System.out.println("Enter email of customer: ");
        cus.setEmail(s.nextLine());
        System.out.println("Enter date of customer: ");
        SimpleDateFormat sdate = new SimpleDateFormat("dd/MM/yyyy");
                 try {
                  cus.setDoB(sdate.parse(s.nextLine()));
                 } catch (ParseException ex) {
                  Logger.getLogger(BookingRoommanagement.class.getName()).log(Level.SEVERE, null, ex);
                 }
        System.out.println("Enter address of customer: ");
        cus.setAddress(s.nextLine());
        return cus;
    }

    @Override
    public boolean editItem(ArrayList<Customer> items) {
        Scanner s = new Scanner(System.in);
        System.out.println("Select an ID to edit: ");
        String id = s.nextLine();
        for (int i = 0; i < items.size(); i++) {
            Customer cus = items.get(i);
            if(items.get(i).getId().equals(id)){
                boolean check = true;
                while(check){
                    System.out.println("========== Select the function you want to edit ==========");
                    System.out.println("|          1. Edit your name                             |");
                    System.out.println("|          2. Edit your phone number                     |");
                    System.out.println("|          3. Edit yoour email                           |");
                    System.out.println("|          4. Edit your address                          |");
                    System.out.println("|          5. Edit your date of birth                    |");
                    System.out.println("|          6. Exit                                       |");
                    System.out.println("==========================================================");
                    System.out.print("Please choose a function: ");
                    int choose = s.nextInt();
                    s = new Scanner(System.in);
                    switch(choose){
                        case 1:
                            System.out.println("Edit your name");
                            cus.setFullame(s.nextLine());
                            break;
                        case 2:
                            System.out.println("Edit your phone number");
                            cus.setPhone(s.nextLine());
                            break;
                        case 3:
                            System.out.println("Edit your email");
                            cus.setEmail(s.nextLine());
                            break;
                        case 4:
                            System.out.println("Edit your address");
                            cus.setAddress(s.nextLine());
                            break;
                        case 5:
                            System.out.println("Edit your date of birth");
                            SimpleDateFormat sdate = new SimpleDateFormat("dd/MM/yyyy");
                            try {
                                cus.setDoB(sdate.parse(s.nextLine()));
                            } catch (ParseException ex) {
                             Logger.getLogger(BookingRoommanagement.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        case 6:
                            check = false;
                            break;
                        default:
                            System.out.println("You have entered wrong, please re-enter!");
                            break;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteItem(ArrayList<Customer> items) {
        Scanner s = new Scanner(System.in);
//        Bill bill = new Bill();
        System.out.println("Choose an ID to delete!");
        String id = s.nextLine();
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getId().equals(id)){
                items.remove(i);
                return true;
            }
        }
        System.out.println("Can't find the ID!");
        return false;
    }

    @Override
    public void show(ArrayList<Customer> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getId()+"\t"+items.get(i).getFullame()+"\t"+items.get(i).getPhone()+"\t"+items.get(i).getEmail()+"\t"+items.get(i).getAddress()+"\t"+items.get(i).getDoB());
        }
    }
    
}
