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
public interface ActionRoom<T,T1,T2> extends Action<T> {
    public Object AddItem(ArrayList<T> item1, ArrayList<T1> item2, ArrayList<T2> item3);
    public boolean editItem(ArrayList<T> item1, ArrayList<T1> item2, ArrayList<T2> item3);
}
