/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Bill;
import Entity.BookingRoom;
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
                boolean check = false;
                do{
                    System.out.print("Enter Booking ID:");
                    String bookid =  s.nextLine();
                    for (int j = 0; j < item2.size(); j++) {
                        if(bookid.equals(item2.get(j).getBrid())){
                            item1.get(i).setBook(item2.get(j));
                            check = false;
                        }
                    else{
                    System.out.println("Can't find the ID!");
                    check = true;
                        }
                    }
                }while(check);
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
            }
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void show(ArrayList<Bill> listBill) {
        for (int i = 0; i < listBill.size(); i++) {
            System.out.println(listBill.get(i).getBillID());
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bill AddItem(ArrayList<Bill> item1, ArrayList<BookingRoom> item2) {
        Bill bill = new Bill();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter ID: ");
        String id = s.nextLine();
        bill.setBillID(id);
        System.out.println("Enter ID Booking Room: ");
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
            }
            else{
                counttype++;
            }
        }
        if(counttype==item2.size()){
            System.out.println("Can't find the ID!");
        }
        Double Totalmoney;
        // Convert `String` to `Date`
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        // Calculate the number of days between dates
//        long timeDiff = Math.abs(Startdate.getTime() - Enddate.getTime());
        //convert Date to String
//        Date datestart = bill.getBook().getStartDate();
//        Date dateend = bill.getBook().getEndDate();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        String StartDate = formatter.format(datestart);
//         String EndDate = formatter.format(dateend);
//        //tinh chenh lech thoi gian giua 2 thoi diem
//        // Custom date format
//
//        Date d1 = null;
//        Date d2 = null;
//        try 
//            d1 = format.parse(StartDate);
//            d2 = format.parse(EndDate);
//        } catch (ParseException e) {
//        }
//        // Get msec from each, and subtract.
//        long diff = d2.getTime() - d1.getTime();
//        long diffHours = diff / (60 * 60 * 1000);
//        Totalmoney = (diffHours * bill.getBook().getRoom().getroomtype().getprice()) + bill.getBook().getRoom().getservice().getPrices();
//        bill.setTotalmoney(Totalmoney);
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
}
