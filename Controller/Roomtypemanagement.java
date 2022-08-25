/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Roomtype;
import Entity.Service;
import Interface.Action;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author manhchelsea
 */
public class Roomtypemanagement implements Action<Roomtype> {

    @Override
    public Roomtype AddItem(ArrayList<Roomtype> items) {
        Roomtype rt = new Roomtype();
        Scanner s = new Scanner(System.in);
        boolean check = false;
        String id;
        do{
            System.out.println("Nhap id room type: ");
            id = s.nextLine();
            for (int i = 0; i < items.size(); i++) {
                if((items.get(i).gettypeID()).equals(id)){
                    System.out.println("Id da ton tai, nhap id moi");
                    check = true;
                }
                else{
                    check = false;
                }
            }
        }while(check);
        rt.settypeID(id);
        System.out.println("Nhap ten room type: ");
        rt.settypeName(s.nextLine());
        System.out.println("Enter price");
        rt.setprice(s.nextDouble());
        return rt;
    }

    @Override
    public boolean editItem(ArrayList<Roomtype> items) {
        Scanner s = new Scanner(System.in);
        System.out.println("Chon ID can sua");
        String id = s.nextLine();
        for (int i = 0; i < items.size(); i++) {
            Roomtype rt = items.get(i);
            if(items.get(i).gettypeID().equals(id)){
                boolean check = true;
                while(check){
                    System.out.println("1. Edit name");
                    System.out.println("2. Edit price");
                    System.out.println("3. Exit");
                    System.out.print("Chon chuc nang ban muon: ");
                    int choose = s.nextInt();
                    switch(choose){
                        case 1:
                            System.out.println("Edit name");
                            s = new Scanner(System.in);
                            rt.settypeName(s.nextLine());
                            break;
                        case 2:
                            System.out.println("Edit price");
                            rt.setprice(s.nextDouble());
                            break;
                        case 3:
                            check = false;
                            break;
                        default:
                            System.out.println("Het lua chon");
                            break;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteItem(ArrayList<Roomtype> items) {
        Scanner s = new Scanner(System.in);
//        Bill bill = new Bill();
        System.out.println("Chon ID can xoa");
        String id = s.nextLine();
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).gettypeID().equals(id)){
                items.remove(i);
                return true;
            }
        }
        System.out.println("Khong tim thay ID");
        return false;
    }

    @Override
    public void show(ArrayList<Roomtype> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).gettypeID()+"   "+items.get(i).gettypeName()+"   "+items.get(i).getprice());
        }
    }
    
}
