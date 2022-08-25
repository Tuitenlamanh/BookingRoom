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
public interface Action<T>{
    public Object AddItem(ArrayList<T> items);
    public boolean editItem(ArrayList<T> items);
    public boolean deleteItem(ArrayList<T> items);
    public void show(ArrayList<T> items);
}

