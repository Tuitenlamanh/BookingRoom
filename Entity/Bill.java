/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author manhchelsea
 */
public class Bill {

    /**
     * @param args the command line arguments
     */
    private String billID;
    private BookingRoom book;
    private Double Totalmoney;

    public Bill(String billID, String billname, Double Totalmoney, BookingRoom book) {
        this.billID = billID;
        this.Totalmoney = Totalmoney;
        this.book = book;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public Double getTotalmoney() {
        return Totalmoney;
    }

    public void setTotalmoney(Double Totalmoney) {
        this.Totalmoney = Totalmoney;
    }

    public BookingRoom getBook() {
        return book;
    }

    public void setBook(BookingRoom book) {
        this.book = book;
    }

   
    public Bill(){
    
}
}
