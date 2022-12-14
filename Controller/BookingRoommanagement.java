/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.BookingRoom;
import Entity.Customer;
import Entity.Room;
import Interface.ActionRoom;
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
public class BookingRoommanagement implements ActionRoom<BookingRoom,Customer,Room> {

    @Override
    public BookingRoom AddItem(ArrayList<BookingRoom> item1, ArrayList<Customer> item2, ArrayList<Room> item3) {
        BookingRoom book = new BookingRoom();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter ID booking: ");
        book.setBrid(s.nextLine());
        System.out.println("Enter ID customer:  ");
        String customerid = s.nextLine();
        int countid = 0;
        for (int i = 0; i < item2.size(); i++){
            if (customerid.equals(item2.get(i).getId())) {
                book.setCustomer(item2.get(i));
            }
            else{
                countid++;
            }
        }
        if(countid==item2.size()){
            System.out.println("Can't find the ID!");
        }
        System.out.println("Enter ID room: ");
        String roomid = s.nextLine();
        int countroom = 0;
        for (int i = 0; i < item3.size(); i++){
            if (roomid.equals(item3.get(i).getroomID())) {
                book.setRoom(item3.get(i));
            }
            else{
                countroom++;
            }
        }
        if(countroom==item3.size()){
            System.out.println("Can't find the ID!");
        }
        System.out.println("Enter start date");
            SimpleDateFormat sdate = new SimpleDateFormat("dd/MM/yyyy");
                 try {
                  book.setStartDate(sdate.parse(s.nextLine()));
                 } catch (ParseException ex) {
                  Logger.getLogger(BookingRoommanagement.class.getName()).log(Level.SEVERE, null, ex);
                 }
        System.out.println("Enter end date");
            SimpleDateFormat edate = new SimpleDateFormat("dd/MM/yyyy");
                 try {
                  book.setEndDate(edate.parse(s.nextLine()));
                 } catch (ParseException ex) {
                  Logger.getLogger(BookingRoommanagement.class.getName()).log(Level.SEVERE, null, ex);
                 }
        return book;
    }

    @Override
    public boolean editItem(ArrayList<BookingRoom> item1, ArrayList<Customer> item2, ArrayList<Room> item3) {
        BookingRoom book = new BookingRoom();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter ID booking room: ");
        String roomid = s.nextLine();
        for (int i = 0; i < item1.size(); i++) {
            if(roomid.equals(item1.get(i).getBrid())){
                boolean check = true;
                BookingRoom book1 = item1.get(i);
                while(check){
                    System.out.println("========== Select an option to edit ==========");
                    System.out.println("|          1. Customer                       |");
                    System.out.println("|          2. Room                           |");
                    System.out.println("|          3. Exit                           |");
                    System.out.println("==============================================");
                    int a = s.nextInt();
                    switch(a){
                        case 1: 
                            s = new Scanner(System.in);
                            System.out.println("Enter ID customer: ");
                            String cusid = s.nextLine();
                            int countcus = 0;
                            for (int j = 0; j < item2.size(); j++){
                                if (cusid.equals(item2.get(j).getId())) {
                                    book1.setCustomer(item2.get(j));
                                    break;
                                }
                                else{
                                    countcus++;
                                }
                            }
                            if(countcus==item2.size()){
                                System.out.println("Not found customer in the list");
                            }
                            System.out.println("Edit successfully!");
                            break;
                        case 2:
                            s = new Scanner(System.in);
                            System.out.println("Enter ID room: ");
                            String serid = s.nextLine();
                            int countser = 0;
                            for (int j = 0; j < item3.size(); j++){
                                if (serid.equals(item3.get(j).getroomID())) {
                                    book1.setRoom(item3.get(j));
                                    break;
                                }
                                else{
                                    countser++;
                                }
                            }
                            if(countser==item3.size()){
                                System.out.println("Not found room in the list");
                            }
                            System.out.println("Edit successfully!");
                            break;
                        case 3:
                            check = false;
                            break;
                        default:
                            System.out.println("You have entered wrong, please re-enter!");
                            break;
                    }
                }
                
            }
        }

        return true;
    }

    @Override
    public boolean deleteItem(ArrayList<BookingRoom> items) {
        Scanner s = new Scanner(System.in);
//        Bill bill = new Bill();
        System.out.print("Select an ID to delete: ");
        String id = s.nextLine();
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getBrid().equals(id)){
                items.remove(i);
                System.out.println("Deleted succesfully!");
                return true;
            }
        }
        System.out.println("Can't find the ID!");
        return false;
    }

    @Override
    public void show(ArrayList<BookingRoom> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("| %-3s | %-20s | %-30s | %-30s | %-40s | %-40s |%n",i+1,items.get(i).getBrid(),items.get(i).getCustomer().getFullname(),items.get(i).getRoom().getroomtype().gettypeName(),items.get(i).getStartDate(),items.get(i).getEndDate());
        }
    }

    @Override
    public Object AddItem(ArrayList<BookingRoom> items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editItem(ArrayList<BookingRoom> items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
