/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany;

import java.util.Arrays;

/**
 *
 * @author D00186562
 */
public class Stock {

    private int counter = 0;
    private Item[] stock;

    public Stock() {
        stock = new Item[10]; //new array of size 10 is created named "stock" that takes "Item" objects. 
    }

    /**
     * Function to add an object of class "Item" to "stock" array. Function
     * checks if array has sufficient space to add additional Items. Return
     * error if array is full.
     *
     * @param i
     * @return
     */
    public boolean add(Item i) {
        if (counter < stock.length) {
            stock[counter] = i;
            counter++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Function to prints all contents in the "stock" array. No action is
     * executed if array index position is NULL.
     */
    public void displayAll() {
        for (int i = 0; i < counter; i++) {
            System.out.println(stock[i].toString());
        }
    }

    /**
     * Function to find an Item in the "stock" array of specified id. All
     * details are printed if a matching id is found. Return error if no id is
     * found within array.
     *
     * @param id
     * @return Details of item of specified ID. NULL if no match.
     */
    public Item findItem(String name) {
        for (int i = 0; i < counter; i++) {
            if (stock[i].getName() == name) {
                return stock[i];
            }
        }
        return null;
    }

    /**
     * Action is carried out if array index is not NULL. Calculates the quantity
     * and price of each item, then grand total of stock value is found.
     *
     * @return total price of all items in "stock" array.
     */
    public double calculateToStockVal() {
        double total = 0;
        for (int i = 0; i < counter; i++) {
            total += stock[i].getuPrice() * stock[i].getsQuantity();
        }
        return total;
    }

    /**
     * Action is carried out if array index is not NULL. Compares each Items
     * price and determines which is dearest.
     *
     * @return dearest item in "stock" array.
     */
    public String findDearest() {
        double dearest = 0;
        String dearestName = "";
        for (int i = 0; i < counter; i++) {
            if (dearest < stock[i].getuPrice()) {
                dearest = stock[i].getuPrice();
                dearestName = stock[i].getName();
            }
        }
        return dearestName;
    }

    /**
     * Action is carried out if array index is not NULL. Compares each Items
     * price and determines which is cheapest
     *
     * @return cheapest item in "stock" array.
     */
    public Item findCheapest() {
        double cheapest = stock[0].getuPrice();
        int cheapestItem = 0;
        for (int i = 0; i < counter; i++) {
            if (cheapest > stock[i].getuPrice()) {
                cheapest = stock[i].getuPrice();
                cheapestItem = i;
            }
        }
        return stock[cheapestItem];
    }
    
    public Item[] getArray() {
        return this.stock;
    }
    
    
    
//    public void sortArray(){
//        Arrays.sort(this.stock, new ComparatorAscendingID());
//    }

//    public void removeDuplicates() {
//        for (int i = 0; i < this.stock.length; i++) {
//            if (i <= this.stock.length + 1) {
//                if (stock[i] != null && stock[i + 1] != null) {
//                    if (stock[i].equals(stock[i + 1])) {
//                        System.out.println("FOUND");
//                        System.out.println(stock[i]);
//                    }
//                }
//            }
//        }
//    }
}
