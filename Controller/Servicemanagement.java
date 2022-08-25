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
public class Servicemanagement implements Action<Service> {

    @Override
    public Service AddItem(ArrayList<Service> items) {
        Service services = new Service();
        Scanner s = new Scanner(System.in);
        boolean check = false;
        String id;
        do{
            System.out.println("Enter ID of Service:  ");
            id = s.nextLine();
            for (int i = 0; i < items.size(); i++) {
                if((items.get(i).getSerID()).equals(id)){
                    System.out.println("ID already exists, please enter another ID!");
                    check = true;
                }
                else{
                    check = false;
                }
            }
        }while(check);
        services.setSerID(id);
        System.out.println("Enter name of service: ");
        services.setSerName(s.nextLine());
        System.out.println("Enter price service: ");
        services.setPrices(s.nextDouble());
        return services;
    }
    @Override
    public boolean editItem(ArrayList<Service> items) {
        Scanner s = new Scanner(System.in);
        System.out.println("Select an ID to edit: ");
        String id = s.nextLine();
        for (int i = 0; i < items.size(); i++) {
            Service ser = items.get(i);
            if(items.get(i).getSerID().equals(id)){
                boolean check = true;
                while(check){
                    System.out.println("========== Select the function to edit ==========");
                    System.out.println("|          1. Edit name                         |");
                    System.out.println("|          2. Edit price                        |");
                    System.out.println("|          3. Exit                              |");
                    System.out.println("=================================================");
                    System.out.print("Choose an function to edit: ");
                    int choose = s.nextInt();
                    s = new Scanner(System.in);
                    switch(choose){
                        case 1:
                            System.out.println("Edit name");
                            ser.setSerName(s.nextLine());
                            break;
                        case 2:
                            System.out.println("Edit price");
                            ser.setPrices(s.nextDouble());
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
        return false;
    }

    @Override
    public boolean deleteItem(ArrayList<Service> items) {
        Scanner s = new Scanner(System.in);
//        Bill bill = new Bill();
        System.out.println("Select the ID to delete: ");
        String id = s.nextLine();
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getSerID().equals(id)){
                items.remove(i);
                return true;
            }
        }
        System.out.println("Can't find the ID!");
        return false;
    }

    @Override
    public void show(ArrayList<Service> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getSerID()+"\t"+items.get(i).getSerName()+"\t"+items.get(i).getPrices());
        }
    }

}