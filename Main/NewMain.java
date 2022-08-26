/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.BillManage;
import Controller.BookingRoommanagement;
import Controller.Customermanagement;
import Controller.Roommanagement;
import Controller.Roomtypemanagement;
import Controller.Servicemanagement;
import Entity.Bill;
import Entity.BookingRoom;
import Entity.Customer;
import Entity.Room;
import Entity.Roomtype;
import Entity.Service;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author manhchelsea
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {         
        // TODO code application logic here
        //Tao roomtype
        Roomtypemanagement rt = new Roomtypemanagement();
        ArrayList<Roomtype> roomtypes = new ArrayList<Roomtype>();
        Roomtype rt1 = new Roomtype("RT1","VIP",1000.0);
        Roomtype rt2 = new Roomtype("RT2","VIP",1000.0);
        roomtypes.add(rt1);
        roomtypes.add(rt2);
        //Tao service
        Servicemanagement sm = new Servicemanagement();
        ArrayList<Service> services = new ArrayList<Service>();
        Service ser1 = new Service("S1","Giat do",50.0);
        Service ser2 = new Service("S2","Buffet sang",100.0);
        services.add(ser1);
        services.add(ser2);
        Scanner s = new Scanner(System.in);
        //tao list Room
        ArrayList<Room> room = new ArrayList<Room>();
        Roommanagement r = new Roommanagement();
        Room room1 = new Room("R1",rt1,ser2);
        Room room2 = new Room("R2",rt2,ser2);
        //Tao list bill
        BillManage bm = new BillManage();
        ArrayList<Bill> bills = new ArrayList<Bill>();
        //Tao booking room
        BookingRoommanagement bkm = new BookingRoommanagement();
        BookingRoom bookingm = new BookingRoom();
        ArrayList<BookingRoom> bk = new ArrayList<BookingRoom>();
        //tao list customer
        Customermanagement cms = new Customermanagement();
        ArrayList<Customer> cus = new ArrayList<Customer>(); 
//        System.out.println("Nhap type id: ");
//        roomt.settypeID(s.nextLine());
//        System.out.println("Nhap type name: ");
//        roomt.settypeName(s.nextLine());
//        System.out.println("Nhap price: ");
//        roomt.setprice(s.nextDouble());

        
//        s = new Scanner(System.in);
//        System.out.println("Nhap Service id: ");
//        ser1.setSerID(s.nextLine());
//        System.out.println("Nhap ten Service: ");
//        ser1.setSerName(s.nextLine());
//        Bill temp = m.AddItem();
//        bills.add(temp);
        
        while(true){
            System.out.println("============ Booking Room Management ============");
            System.out.println("|            1. Bill Management                 |");
            System.out.println("|            2. Booking Room Management         |");
            System.out.println("|            3. Customer Management             |");
            System.out.println("|            4. Employee Management             |");
            System.out.println("|            5. Room Management                 |");
            System.out.println("|            6. Room type Management            |");
            System.out.println("|            7. Service Management              |");
            System.out.println("|            8. Exit                            |");
            System.out.println("=================================================");
            System.out.print("Please choose a function: ");
            int choose = s.nextInt();
            switch(choose){
                case 1:{
                    MenuBill(bm, bills, bk);
                        break;
                    }
                    case 2:{
                        MenuBooking(bkm, bk, cus, room);
                        break;
                    }
                    case 3:{
                        MenuCustomer(cms, cus);
                        break;
                    }
                    case 4:{
                        break;
                    }
                    case 5:{
                        MenuRoom(r, room, roomtypes, services);
                        break;
                    }
                    case 6:{
                        MenuRoomtype(rt, roomtypes);
                        break;
                    }
                    case 7:{
                        MenuService(sm, services);
                        break;
                    }
                    case 8:{
                        System.exit(0);
                    }
                    default:{
                        System.out.println("You entered wrong, please re-enter!");
                    }
            }
        }

        
    }
    private static void MenuBill(BillManage billm,ArrayList<Bill> listbill, ArrayList<BookingRoom> listbooking){
        Scanner s = new Scanner(System.in);
        boolean Menu = true;
        while(Menu){
            System.out.println("============ Bill Management ============");
            System.out.println("|            1. Add bill                |");
            System.out.println("|            2. Edit bill               |");
            System.out.println("|            3. Delete bill             |");
            System.out.println("|            4. Show bill               |");
            System.out.println("|            5. Exit                    |");
            System.out.println("=========================================");
            System.out.print("Please choose a function: ");
            int choose = s.nextInt();
            switch(choose){
            case 1:{
                listbill.add(billm.AddItem(listbill,listbooking));
                break;
            }
            case 2:{
                billm.editItem(listbill);
                break;
            }
            case 3:{
                billm.deleteItem(listbill);
                break;
            }
            case 4:{
                billm.show(listbill);
                break;
            }
            case 5:{
                Menu = false;
                break;
            }
            default:{
                        System.out.println("You entered wrong, please re-enter!");
                    }
            }
        }
    }
    private static void MenuRoom(Roommanagement roomm,ArrayList<Room> listroom,ArrayList<Roomtype> listroomtype,ArrayList<Service> listservice){
        Scanner s = new Scanner(System.in);
        boolean Menu = true;
        while(Menu){
            System.out.println("========== Room Management ============");
            System.out.println("|          1. Add room                |");
            System.out.println("|          2. Edit room               |");
            System.out.println("|          3. Delete room             |");
            System.out.println("|          4. Show room               |");
            System.out.println("|          5. Exit                    |");
            System.out.println("=======================================");
            System.out.print("Please choose a function: ");
            int choose = s.nextInt();
            switch(choose){
            case 1:{
                listroom.add(roomm.AddItem(listroom,listroomtype,listservice));
                break;
            }
            case 2:{
                roomm.editItem(listroom,listroomtype,listservice);
                break;
            }
            case 3:{
                roomm.deleteItem(listroom);
                break;
            }
            case 4:{
                System.out.printf("| %-3s | %-20s | %-20s |%n","STT","Type","Service");
                roomm.show(listroom);
                break;
            }
            case 5:{
                Menu = false;
                break;
            }
            default:{
                        System.out.println("You entered wrong, please re-enter!");
                    }
            }
        }
    }
    private static void MenuRoomtype(Roomtypemanagement roomtypem,ArrayList<Roomtype> listroomtype){
        Scanner s = new Scanner(System.in);
        boolean Menu = true;
        while(Menu){
            System.out.println("============ Room Type Management ============");
            System.out.println("|            1. Add room type                |");
            System.out.println("|            2. Edit room type               |");
            System.out.println("|            3. Delete room type             |");
            System.out.println("|            4. Show room type               |");
            System.out.println("|            5. Exit                         |");
            System.out.println("==============================================");
            System.out.print("Please choose a function: ");
            int choose = s.nextInt();
            switch(choose){
            case 1:{
                listroomtype.add((Roomtype) roomtypem.AddItem(listroomtype));
                break;
            }
            case 2:{
                roomtypem.editItem(listroomtype);
                break;
            }
            case 3:{
                roomtypem.deleteItem(listroomtype);
                break;
            }
            case 4:{
                System.out.printf("| %-3s | %-20s | %-20s | %-20s |%n","STT","Room type ID","Type name","Price");
                roomtypem.show(listroomtype);
                break;
            }
            case 5:{
                Menu = false;
                break;
            }
            default:{
                        System.out.println("You entered wrong, please re-enter!");
                    }
            }
        }
    }
    private static void MenuService(Servicemanagement servicem,ArrayList<Service> listservice){
        Scanner s = new Scanner(System.in);
        boolean Menu = true;
        while(Menu){
            System.out.println("============ Service Management ============");
            System.out.println("|            1. Add service                |");
            System.out.println("|            2. Edit service               |");
            System.out.println("|            3. Delete service             |");
            System.out.println("|            4. Show service               |");
            System.out.println("|            5. Exit                       |");
            System.out.println("============================================");
            System.out.print("Please choose a function: ");
            int choose = s.nextInt();
            switch(choose){
            case 1:{
                listservice.add((Service) servicem.AddItem(listservice));
                break;
            }
            case 2:{
                servicem.editItem(listservice);
                break;
            }
            case 3:{
                servicem.deleteItem(listservice);
                break;
            }
            case 4:{
                System.out.printf("| %-3s | %-20s | %-20s | %-20s |%n","STT","ID Service","Service Name","Price");
                servicem.show(listservice);
                break;
            }
            case 5:{
                Menu = false;
                break;
            }
            default:{
                        System.out.println("You entered wrong, please re-enter!");
                    }
            }
        }
    }
    private static void MenuBooking(BookingRoommanagement bookingm,ArrayList<BookingRoom> listbooking, ArrayList<Customer> listcustomer, ArrayList<Room> listroom){
        Scanner s = new Scanner(System.in);
        boolean Menu = true;
        while(Menu){
            System.out.println("============ Booking Management ============");
            System.out.println("|            1. Add Booking                |");
            System.out.println("|            2. Edit Booking               |");
            System.out.println("|            3. Delete Booking             |");
            System.out.println("|            4. Show Booking               |");
            System.out.println("|            5. Exit                       |");
            System.out.println("============================================");
            System.out.print("Please choose a function: ");
            int choose = s.nextInt();
            switch(choose){
            case 1:{
                listbooking.add((BookingRoom) bookingm.AddItem(listbooking,listcustomer,listroom));
                break;
            }
            case 2:{
                bookingm.editItem(listbooking,listcustomer,listroom);
                break;
            }
            case 3:{
                bookingm.deleteItem(listbooking);
                break;
            }
            case 4:{
                System.out.printf("| %-3s | %-20s | %-30s | %-30s | %-40s | %-40s |%n","STT","ID Booking","Name customer","Name type room","Start date","End date");
                bookingm.show(listbooking);
                break;
            }
            case 5:{
                Menu = false;
                break;
            }
            default:{
                        System.out.println("You entered wrong, please re-enter!");
                    }
            }
        }
    }
    private static void MenuCustomer(Customermanagement cusm, ArrayList<Customer> listcustomer){
        Scanner s = new Scanner(System.in);
        boolean Menu = true;
        while(Menu){
            System.out.println("============ Customer Management ============");
            System.out.println("|            1. Add customer                |");
            System.out.println("|            2. Edit customer               |");
            System.out.println("|            3. Delete customer             |");
            System.out.println("|            4. Show customer               |");
            System.out.println("|            5. Exit                        |");
            System.out.println("=============================================");
            System.out.print("Please choose a function: ");
            int choose = s.nextInt();
            switch(choose){
            case 1:{
                listcustomer.add((Customer) cusm.AddItem(listcustomer));
                break;
            }
            case 2:{
                cusm.editItem(listcustomer);
                break;
            }
            case 3:{
                cusm.deleteItem(listcustomer);
                break;
            }
            case 4:{
                System.out.printf("| %-3s | %-20s | %-20s | %-30s | %-20s | %-20s | %-40s |%n","STT","ID","Fullname","Phone number","Email","Address","DoB");
                cusm.show(listcustomer);
                break;
            }
            case 5:{
                Menu = false;
                break;
            }
            default:{
                        System.out.println("You entered wrong, please re-enter!");
                    }
            }
        }
    }
}
