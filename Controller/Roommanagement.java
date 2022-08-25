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
        System.out.println("Nhap id: ");
        room.setroomID(s.nextLine());
        System.out.println("Nhap roomtype id:  ");
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
            System.out.println("Khong co trong danh sach");
        }
        System.out.println("Nhap loai dich vu: ");
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
            System.out.println("Thang Huy bi len don roi!");
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
        System.out.println("Chon ID can xoa");
        String id = s.nextLine();
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getroomID().equals(id)){
                items.remove(i);
                return true;
            }
        }
        System.out.println("Khong tim thay ID");
        return false;
    }

    @Override
    public void show(ArrayList<Room> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("| %-15s | %-15s |%n", items.get(i).getroomtype().gettypeName(), items.get(i).getservice().getSerName());
        }
}

    @Override
    public boolean editItem(ArrayList<Room> item1, ArrayList<Roomtype> item2, ArrayList<Service> item3) {
        Room room = new Room();
        Scanner s = new Scanner(System.in);
        System.out.println("Nhap id: ");
        String roomid = s.nextLine();
        for (int i = 0; i < item1.size(); i++) {
            if(roomid.equals(item1.get(i).getroomID())){
                boolean check = true;
                while(check){
                    System.out.println("Ban can sua gi?");
                    System.out.println("1. Loai phong");
                    System.out.println("2. Dich vu");
                    System.out.println("3. Exit");
                    
                    int a = s.nextInt();
                    switch(a){
                        case 1: 
                            System.out.print("Enter ID type room: ");
                            s = new Scanner(System.in);
                            String roomtypeid = s.nextLine();
                            int counttype = 0;
                            for (int j = 0; j < item2.size(); j++){
                                if (roomtypeid.equals(item2.get(j).gettypeID())) {
                                    room.setroomtype(item2.get(j));
                                    break;
                                }
                                else{
                                    counttype++;
                                }
                            }
                            if(counttype==item2.size()){
                                System.out.println("Can't find the ID!");
                            }
                            break;
                        case 2:
                            System.out.println("Enter ID of service: ");
                            s = new Scanner(System.in);
                            String serid = s.nextLine();
                            int countser = 0;
                            for (int j = 0; j < item3.size(); j++){
                                if (serid.equals(item3.get(j).getSerID())) {
                                    room.setservice(item3.get(j));
                                    break;
                                }
                                else{
                                    countser++;
                                }
                            }
                            if(countser==item2.size()){
                                System.out.println("Khong co dich vu trong danh sach");
                            }
                        case 3:
                            check = false;
                            break;
                        default:
                            System.out.println("Het");
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
