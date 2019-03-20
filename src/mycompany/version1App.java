/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany;

/**
 *
 * @author TJ Home-PC
 */
public class version1App {

    public static void main(String[] args) {
        //Creating objects of class "Item" with new values
        Item i1 = new Item();
        Item i2 = new Item("Orange", 1.60, 10);
        Item i3 = new Item("Banana", 1.30, 20);
        Item i4 = new Item("Cereal", 4.00, 25);
        Item i5 = new Item();
        Item i6 = new Item();
        Item i7 = new Item();
        Item i8 = new Item();
        Item i9 = new Item();
        Item i10 = new Item();
        Item i11 = new Item();
        
        //prints details of i2
        System.out.println(i2.getName()+", "+i2.getId()+", "+i2.getsQuantity()+", "+i2.getuPrice());
        
        //setting new values for i2
        i2.setName("Suger");
        i2.setsQuantity(2); 
        i2.setuPrice(3.00);
        
        //Displays the new values for i2
        System.out.println(i2.getName()+", "+i2.getId()+", "+i2.getsQuantity()+", "+i2.getuPrice());
        
        //Sets quantity of i3 to -3(NOTE: Should return an error)
        if(i3.setsQuantity(-4)){
            System.out.println("Quantity updated.");           
        }else{
            System.out.println("Error: No minus quantity.");
        }
        
        //Sets quantity of i3 to -3(NOTE: Should return an error)
        if(i3.setuPrice(-2.0)){
            System.out.println("Price updated.");
        }else{
            System.out.println("Error: No minus price.");
        }
        
        //Decreases quantity of i3 by 21(NOTE: Should return an error)
        if (i3.decreaseQuantity(21)){
            System.out.println("Quantity updated.");
        }else{
            System.out.println("Error: Quantity is minus.");
        }
        
        //Creates array
        Stock stock = new Stock();
        //Adds objects into the array
        stock.add(i1);
        stock.add(i2);
        stock.add(i3);
        stock.add(i4);
        stock.add(i5);
        stock.add(i6);
        stock.add(i7);
        stock.add(i8);
        stock.add(i9);
        
        //Checks to see if array has space. If there is space, add to array and display message of this working
        if (stock.add(i10)) {
            System.out.println("Item added.");
        } else {
            System.out.println("Error. Array full,Item no added");
        }
        
        //Checks to see if array has space (NOTE: Should return error)
        if (stock.add(i11)) {
            System.out.println("Item added.");
        } else {
            System.out.println("Error. Array full,Item no added");
        }
        
        //Displays all details of all items in stock array
        stock.displayAll();
        
        //Finds item name shoe (NOTE: Should return error)
        Item temp = stock.findItem("shoes");
        if(temp != null){
            System.out.println(temp.toString());
        }else{
            System.out.println("Error: No item with that id.");
        }
        //Finds item of name apple. Once found, prints all details
        temp = stock.findItem("apple");
        if(temp != null){
            System.out.println(temp.toString());
        }else{
            System.out.println("Error: No item with that name.");
        }
        
        //Calculates total stock value
        System.out.println("Total stock value: "+stock.calculateToStockVal());
        
        //Find dearest item
        System.out.println("Dearest item: "+stock.findDearest());
        
        //Find Cheapest item
        System.out.println("Cheapest Item: "+stock.findCheapest()); 
    }
}
