/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany;

/**
 *
 * @author D00186562
 */
public class Order extends Item{
    
    private Item item;
    private static int orderIDCount = 1;
    private int orderID;   
    private int orderQuantity;
    
    //Parameterized constructor for relevant instance variables
    //2)The quantity of an item in stock should be updated when an order is accepted, do in Order constructor.
    public Order(Item order, int orderQuantity){
        this.item = order;
        this.orderQuantity = orderQuantity;
        this.orderID = orderIDCount;
        orderIDCount++;
        item.decreaseQuantity(orderQuantity);
    }
    
    //Getters
    public Item getItem(){
        return this.item;
    }
    public int getOrderQuantity(){
        return this.orderQuantity;
    }
    public int getOrderID(){
        return this.orderID;
    }
    
    //Setters
    public boolean setOrderQuantity(int orderQuantity) {
        if (orderQuantity >= 0) {
            this.orderQuantity = orderQuantity;
            return true;
        }
        return false;
    }
    public void setItem(Item i){
        this.item = i;
    }
    
    //3) A method, calculateBasicOrderCost  (in Order) that calculates the order cost by multiplying the order quantity by the price of the item.
    /**
     * Calculates the value of the order by multiplying the order quantity by
     * the price of the item.
     * @return Total order value
     */
    public double calculateBasicOrderCost(){
        return orderQuantity*item.getuPrice();
    }
    
    //4) A method calculateDiscount (in Order) that accepts an order value and returns the discount amount. 
    /**
     * Checks to see which discount the order is entitled to depending on its 
     * order value. Discounts are calculated as follows:
     * Less than 1000 = 0%.
     * Between 1000-5000 = 3%.
     * More than 5000 = 4%.
     * 
     * @return Value of order after discount
     */
    public double calculateDiscount(){
        double basicOrderCost = calculateBasicOrderCost();
        if(basicOrderCost>=1000 && basicOrderCost <= 5000)
            return basicOrderCost*0.97;
        else if(basicOrderCost>5000)
            return basicOrderCost*0.96;
        else{
            return basicOrderCost;
        }
    }
    
    //5)Override the toString method where appropriate.
    /**
     * Prints OrderID,OrderQuantity and all item parameters. 
     * @return OrderID,OrderQuantity and all item parameters.
     */
    @Override
    public String toString(){
        return "OrderID= " + this.orderID + ", OrderQuantity= " + this.orderQuantity +", "+ this.item;
    }
    
    /**
     * Checks to see if 2 orders are the same.
     * 2 orders are considered equal if they have the same item name and quantity.
     * @param otherObject
     * @return Boolean of two objects 
     */
    @Override
    public boolean equals(Object otherObject){
        if (otherObject == null)
            return false;
        else if(getClass() != otherObject.getClass())
            return false;
        else{
            Order otherOrder = (Order)otherObject;
            return item.getName().equals(otherOrder.getName()) && orderQuantity == otherOrder.orderQuantity;           
        }
    }
}
