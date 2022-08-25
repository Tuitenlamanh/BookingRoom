/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;

/**
 *
 * @author manhchelsea
 */
public interface ActionBill<T1,T2> extends Action<T1> {
    public Object AddItem(ArrayList<T1> item1, ArrayList<T2> item2);
    public boolean editItem(ArrayList<T1> item1, ArrayList<T2> item2);
    
}
