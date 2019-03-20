
package mycompany;

import java.util.ArrayList;

/**
 *
 * @author Default
 */
public class OrderBook {
    
    private ArrayList<Order> order;
     
    public OrderBook() {
        order = new ArrayList<>();
    }
     
    public void addOrder(Order o){
        order.add(o);
    }
    
    //Override toString
    @Override
    public String toString() {
        return " " + this.order;
    }
    //7)method displayAll that displays the details of all orders 
    public void displayAll() {
        for(int i = 0;i < order.size();i++) {
            System.out.println(order.get(i));
        }
    }
     //8)method findOrder given the id returns the order
    public Order findOrder(int id) {
    for(int i=0;i<order.size();i++) {
        if (order.get(i).getOrderID() == id) {
            return order.get(i);
        }
    }
    return null;
    }
    
     //9)method findAllOrders given the id returns the order
    public boolean findAllOrders(String name) {
        boolean flag = false;
        for(int i=0;i<order.size();i++) {
            if (order.get(i).getItem().getName().equals(name)) {
                System.out.println(order.get(i).toString());
                flag = true;               
            }
        }
        return flag;
    }  
    
     //10)method orderItemValue that returns the total order value for a particular item
        public double orderItemValue(String name) {
            double total = 0;
        for(int i=0;i<order.size();i++) {
            if (order.get(i).getItem().getName().equals(name)) {
                total += order.get(i).calculateBasicOrderCost();           
            }
        }
        return total;
    }  
}
