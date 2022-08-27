/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Bill;
import Entity.BookingRoom;
import Entity.Service;
import Interface.Action;
import Interface.ActionBill;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author manhchelsea
 */
public class BillManage implements ActionBill<Bill,BookingRoom> {

    

    @Override
    public boolean editItem(ArrayList<Bill> item1, ArrayList<BookingRoom> item2) {
        Scanner s = new Scanner(System.in);
//        Bill bill = new Bill();
        System.out.println("Select an ID to edit");
        String id = s.nextLine();
        for (int i = 0; i < item1.size(); i++) {
            if(item1.get(i).getBillID().equals(id)){
                boolean check = true;
                while(check){
                    System.out.print("Enter Booking ID:");
                    String bookid =  s.nextLine();
                    for (int j = 0; j < item2.size(); j++) {
                        if(bookid.equals(item2.get(j).getBrid())){
                            Bill bill = item1.get(i);
                            item1.get(i).setBook(item2.get(j));
//                            Date Startdate = item2.get(i).getStartDate();
//                            Date Enddate = item2.get(i).getEndDate();
//                            long daysDiff = ChronoUnit.HOURS.between(Startdate.toInstant(), Enddate.toInstant());
//                            System.out.println("The number of days between dates: " + daysDiff);
//                            Double priceroomtype = item2.get(i).getRoom().getroomtype().getprice();
//                            Double priceservice = item2.get(i).getRoom().getservice().getPrices();
//                            bill.setTotalmoney(TotalMoney(priceroomtype,priceservice,daysDiff));            
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        System.out.println("Can't find the ID!");
                    }
                }
            }
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteItem(ArrayList<Bill> items) {
        Scanner s = new Scanner(System.in);
//        Bill bill = new Bill();
        System.out.println("Select an ID to delete");
        String id = s.nextLine();
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getBillID().equals(id)){
                items.remove(i);
                System.out.println("Deleted succesfully!");
                return true;
            }
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void show(ArrayList<Bill> listBill) {
        for (int i = 0; i < listBill.size(); i++) {
            Date Startdate = listBill.get(i).getBook().getStartDate();
            Date Enddate = listBill.get(i).getBook().getEndDate();
            long daysDiff = ChronoUnit.HOURS.between(Startdate.toInstant(), Enddate.toInstant());
            Double priceroomtype = listBill.get(i).getBook().getRoom().getroomtype().getprice();
            Double priceservice = listBill.get(i).getBook().getRoom().getservice().getPrices();
            listBill.get(i).setTotalmoney(TotalMoney(priceroomtype,priceservice,daysDiff));
            System.out.printf("| %-3s | %-20s | %-20s | %-20s |%n",i+1,listBill.get(i).getBillID(),listBill.get(i).getBook().getCustomer().getFullname(),listBill.get(i).getTotalmoney());
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bill AddItem(ArrayList<Bill> item1, ArrayList<BookingRoom> item2) {
        Bill bill = new Bill();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter ID of Bill: ");
        String id = s.nextLine();
        bill.setBillID(id);
        System.out.println("Enter ID Booking Room: ");
        s = new Scanner(System.in);
        String bookingid = s.nextLine();
        int counttype = 0;
        Date Startdate, Enddate;
        for (int i = 0; i < item2.size(); i++){
            if (bookingid.equals(item2.get(i).getBrid())) {
                bill.setBook(item2.get(i));
                Startdate = item2.get(i).getStartDate();
                Enddate = item2.get(i).getEndDate();
                long daysDiff = ChronoUnit.HOURS.between(Startdate.toInstant(), Enddate.toInstant());
                System.out.println("The number of days between dates: " + daysDiff);
//                Double priceroomtype = item2.get(i).getRoom().getroomtype().getprice();
//                Double priceservice = item2.get(i).getRoom().getservice().getPrices();
//                bill.setTotalmoney(TotalMoney(priceroomtype,priceservice,daysDiff));
            }
            else{
                counttype++;
            }
        }
        if(counttype==item2.size()){
            System.out.println("Can't find the ID!");
        }
        return bill;
    }

    @Override
    public Object AddItem(ArrayList<Bill> items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editItem(ArrayList<Bill> items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Double TotalMoney(Double priceroomtype,Double priceservice,long daysDiff){
        return (priceroomtype*daysDiff+priceservice);
    }

    @Override
    public Double TotalMoney(ArrayList<Bill> item1, ArrayList<BookingRoom> item2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
