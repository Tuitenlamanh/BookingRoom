/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Room;
import Entity.Roomtype;
import Entity.Service;
import Interface.Action;
import Interface.ActionRoom;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author manhchelsea
 */
public class Roommanagement implements ActionRoom<Room,Roomtype,Service> {

    @Override
    public Room AddItem(ArrayList<Room> item1, ArrayList<Roomtype> item2, ArrayList<Service> item3) {
        Room room = new Room();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter ID: ");
        room.setroomID(s.nextLine());
        System.out.println("Enter Room Type ID:  ");
        String roomtypeid = s.nextLine();
        int counttype = 0;
        for (int i = 0; i < item2.size(); i++){
            if (roomtypeid.equals(item2.get(i).gettypeID())) {
                room.setroomtype(item2.get(i));
            }
            else{
                counttype++;
            }
        }
        if(counttype==item2.size()){
            System.out.println("Can't find the ID!");
        }
        System.out.println("Enter the service: ");
        String serid = s.nextLine();
        int countser = 0;
        for (int i = 0; i < item3.size(); i++){
            if (serid.equals(item3.get(i).getSerID())) {
                room.setservice(item3.get(i));
            }
            else{
                countser++;
            }
        }
        if(countser==item2.size()){
            System.out.println("Can't find the ID!");
        }
        return room;
    }

    @Override
    public boolean editItem(ArrayList<Room> items) {
        throw new UnsupportedOperationException("Not supported yet.");
        }

    @Override
    public boolean deleteItem(ArrayList<Room> items) {
        Scanner s = new Scanner(System.in);
//        Bill bill = new Bill();
        System.out.println("Select an ID to delete: ");
        String id = s.nextLine();
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getroomID().equals(id)){
                items.remove(i);
                return true;
            }
        }
        System.out.println("Can't find the ID");
        return false;
    }

    @Override
    public void show(ArrayList<Room> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("| %-3s | %-20s | %-20s |%n",i+1, items.get(i).getroomtype().gettypeName(), items.get(i).getservice().getSerName());
        }
}

    @Override
    public boolean editItem(ArrayList<Room> item1, ArrayList<Roomtype> item2, ArrayList<Service> item3) {
        Room room = new Room();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter ID: ");
        String roomid = s.nextLine();
        for (int i = 0; i < item1.size(); i++) {
            if(roomid.equals(item1.get(i).getroomID())){
                boolean check = true;
                while(check){
                    System.out.println("==== What do you want to edit? ====");
                    System.out.println("|    1. Room type                 |");
                    System.out.println("|    2. Service                   |");
                    System.out.println("|    3. Exit                      |");
                    System.out.println("===================================");
                    
                    int a = s.nextInt();
                    switch(a){
                        case 1: 
                            System.out.print("Enter ID type room: ");
                            s = new Scanner(System.in);
                            String roomtypeid = s.nextLine();
                            int counttype = 0;
                            for (int j = 0; j < item2.size(); j++){
                                if (roomtypeid.equals(item2.get(j).gettypeID())) {
                                    item1.get(i).setroomtype(item2.get(j));
                                    break;
                                }
                                else{
                                    counttype++;
                                }
                            }
                            if(counttype==item2.size()){
                                System.out.println("Can't find the ID of Room type!");
                            }
                            break;
                        case 2:
                            System.out.println("Enter ID of service: ");
                            s = new Scanner(System.in);
                            String serid = s.nextLine();
                            int countser = 0;
                            for (int j = 0; j < item3.size(); j++){
                                if (serid.equals(item3.get(j).getSerID())) {
                                    item1.get(i).setservice(item3.get(j));
                                    break;
                                }
                                else{
                                    countser++;
                                }
                            }
                            if(countser==item2.size()){
                                System.out.println("Can't fine the ID of Service!");
                            }
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
    public Object AddItem(ArrayList<Room> items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
