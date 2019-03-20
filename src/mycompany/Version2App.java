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
public class Version2App {
    public static void main(String[] args) {
        //Initializing stock and orderbook
        Stock stock = new Stock();
        OrderBook orderBook = new OrderBook();
        
        fillStock(stock);

        // Q1
        System.out.println("Q1");
        //Tests for an item that does not exist
        Q1Test(orderBook,stock.findItem("sdfsad"),3);
        
        //Tests if an item does exist but not enough in stock for order
        Q1Test(orderBook,stock.findItem("Premium apples"),16);

        // Q2
        System.out.println("Q2");
        //This shows the quantity before an order subtracts from stock
        System.out.println("Stock quantity before order: " + stock.findItem("Premium apples").getsQuantity());
        
        //Tests if an item does exist and is in stock before creating Order object
        Q1Test(orderBook,stock.findItem("Premium apples"),3);
        
        //This shows the quantity before an order subtracts from stock
        System.out.println("Stock quantity after order: " + stock.findItem("Premium apples").getsQuantity());
    
        
        
        //Q3
        System.out.println("Q3");
        //Adding orders into orderBook
        orderBook.addOrder(new Order(stock.findItem("Orange Juice"),6));
        orderBook.addOrder(new Order(stock.findItem("Book"),11));
        orderBook.addOrder(new Order(stock.findItem("Book"),3));
        
        //Calculating the basic order cost of orders
        System.out.println("Order1 basic cost: "+orderBook.findOrder(1).calculateBasicOrderCost());
        System.out.println("Order2 basic cost: "+orderBook.findOrder(2).calculateBasicOrderCost());
        System.out.println("Order3 basic cost: "+orderBook.findOrder(3).calculateBasicOrderCost());

        //Q4
        System.out.println("Q4");
        //This order is >1000, so a discount of 0% is applied(no discount)
        System.out.println("Order discounted: " + +orderBook.findOrder(1).calculateDiscount());
        //This order is 1000-5000, so a discount of 3% is applied
        System.out.println("Order discounted: " + +orderBook.findOrder(2).calculateDiscount());
        //This order is <5000, so a discount of 4% is applied
        System.out.println("Order discounted: " + +orderBook.findOrder(3).calculateDiscount());

        //Q5
        System.out.println("Q5");
        //Prints the string of the third Order of the orderBook ArrayList
        System.out.println(orderBook.findOrder(3).toString());

        //Q7
        System.out.println("Q7");
        //Displays all order objects in orderBook
        orderBook.displayAll();

        //Q8
        System.out.println("Q8");
        
        Q8Test(orderBook.findOrder(1));
        
        Q8Test(orderBook.findOrder(50));

        //Q9
        System.out.println("Q9");
        
        Q9Test(orderBook,"Book");
       
        Q9Test(orderBook,"fdsadga");
        
        //Q10
        System.out.println("Q10");
        //Gets total order value of the item name passed through it
        System.out.println(orderBook.orderItemValue("Book"));
        System.out.println(orderBook.orderItemValue("sdfgasdf"));          
    }
    

    public static void fillStock(Stock stock){
        stock.add(new Item("Premium apples", 300,15));
        stock.add(new Item("Orange Juice", 200,30));
        stock.add(new Item("Book", 500,12));
    }
    
    public static void Q1Test(OrderBook orderBook,Item item,int quantity){
        if(item==null) //if the item does not exist in stock, print error. cancel order
            System.out.println("Item does not exist in stock.");
        else if(quantity > item.getsQuantity()) //if the ordered amount is greater then the stock quantity, print error. cancel order
            System.out.println("Not enough of this item in stock. Order cancelled.");
        else{// if both the item exists and has enough in stock, create object and insert into orderBook arraylist
            System.out.println("Order Accepted.");
            orderBook.addOrder(new Order(item,quantity));
            
        }
    }
    
    public static void Q8Test(Order order){
        if (order == null)//if the order does not exist in the orderBook, print error
            System.out.println("No item with that ID found");
        else //otherwise, print order toString
            System.out.println(order);
    }
    
    public static void Q9Test(OrderBook orderBook, String item){
        if(orderBook.findAllOrders(item)==false)//if no orders contain the item name passed through it, print error
            System.out.println("No orders with that item");
    }
}
