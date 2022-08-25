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
            System.out.println("Nhap id customer: ");
            id = s.nextLine();
            for (int i = 0; i < items.size(); i++) {
                if((items.get(i).getId()).equals(id)){
                    System.out.println("Id da ton tai, nhap id moi");
                    check = true;
                }
                else{
                    check = false;
                }
            }
        }while(check);
        cus.setId(id);
        System.out.println("Nhap ten: ");
        cus.setFullame(s.nextLine());
        System.out.println("Nhap so dien thoai: ");
        cus.setPhone(s.nextLine());
        System.out.println("Nhap email: ");
        cus.setEmail(s.nextLine());
        System.out.println("Nhap ngay thang nam sinh: ");
        SimpleDateFormat sdate = new SimpleDateFormat("dd/MM/yyyy");
                 try {
                  cus.setDoB(sdate.parse(s.nextLine()));
                 } catch (ParseException ex) {
                  Logger.getLogger(BookingRoommanagement.class.getName()).log(Level.SEVERE, null, ex);
                 }
        System.out.println("Nhap dia chi: ");
        cus.setAddress(s.nextLine());
        return cus;
    }

    @Override
    public boolean editItem(ArrayList<Customer> items) {
        Scanner s = new Scanner(System.in);
        System.out.println("Chon ID can sua");
        String id = s.nextLine();
        for (int i = 0; i < items.size(); i++) {
            Customer cus = items.get(i);
            if(items.get(i).getId().equals(id)){
                boolean check = true;
                while(check){
                    System.out.println("1. Edit name");
                    System.out.println("2. Edit so dien thoai");
                    System.out.println("3. Edit email");
                    System.out.println("4. Edit so dia chi");
                    System.out.println("5. Edit ngay thang nam sinh");
                    System.out.println("6. Exit");
                    System.out.print("Chon chuc nang ban muon: ");
                    int choose = s.nextInt();
                    switch(choose){
                        case 1:
                            System.out.println("Edit name");
                            cus.setFullame(s.nextLine());
                            break;
                        case 2:
                            System.out.println("Edit so dien thoai");
                            cus.setPhone(s.nextLine());
                            break;
                        case 3:
                            System.out.println("Edit email");
                            cus.setEmail(s.nextLine());
                            break;
                        case 4:
                            System.out.println("Edit dia chi");
                            cus.setAddress(s.nextLine());
                            break;
                        case 5:
                            System.out.println("Edit ngay thang nam sinh");
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
                            System.out.println("Het lua chon");
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
        System.out.println("Chon ID can xoa");
        String id = s.nextLine();
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getId().equals(id)){
                items.remove(i);
                return true;
            }
        }
        System.out.println("Khong tim thay ID");
        return false;
    }

    @Override
    public void show(ArrayList<Customer> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getId()+"\t"+items.get(i).getFullame());
        }
    }
    
}
