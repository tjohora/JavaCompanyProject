package mycompany;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author D00196849
 */
public class StartUpApp {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Stock s1 = new Stock();
        Scanner input = new Scanner(new File("item.txt"));
        //Scanner corruptedItem = new Scanner(new File("item.txt"));
        input.useDelimiter(",");
        PrintStream invalid = new PrintStream(new File("invalidCustomers.txt"));

//        String name;
//        int id, quantityInStock;
//        double UnitPrice;

        while (input.hasNext()) {
            try {
//                name = input.next();
//                id = input.nextInt();
//                quantityInStock = input.nextInt();
//                UnitPrice = input.nextDouble();

                s1.add(new Item(input.next(), input.nextInt(), input.nextInt(), input.nextDouble()));
//                s1.add(new Item(name, id, quantityInStock,UnitPrice));                
//                corruptedItem.nextLine();
            } catch (InputMismatchException e) {
                invalid.println(input.nextLine());

            }
        }
        input.close();
//        corruptedItem.close();
        //s1.displayAll();

//        customerType customerName customerAddress email balance creditLimit 
//        OR customerType customerName customerAddress email loyaltyPoints 
        //String customerType, customerName, customerAddress, email;
        //double balance, creditLimit, loyaltyPoints;
        String customerType;

        BufferedReader input2 = new BufferedReader(new FileReader("customers.txt"));
        String line = input2.readLine();
        
        System.out.println(line);
        CustomerData data = new CustomerData();
        
        while (line != null) {
            StringTokenizer split = new StringTokenizer(line);
            customerType = split.nextToken();
            
            
//            customerName = split.nextToken();            
//            customerAddress = split.nextToken();           
//            email = split.nextToken();
            
            if (customerType.equalsIgnoreCase("business")) {
//                balance = Double.parseDouble(split.nextToken());
//                System.out.println(balance);
//                creditLimit = Double.parseDouble(split.nextToken());
//                
//                data.addCustomer(new BusinessCustomer(balance, creditLimit, customerType, customerName, customerAddress, email));
                data.addCustomer(new BusinessCustomer(customerType,split.nextToken(),split.nextToken(),split.nextToken(),Double.parseDouble(split.nextToken()),Double.parseDouble(split.nextToken())));
            }else{
//                loyaltyPoints = Integer.parseInt(split.nextToken());                
//                data.addCustomer(new PrivateCustomer(customerType, customerName, customerAddress, email, loyaltyPoints));
                data.addCustomer(new PrivateCustomer(customerType,split.nextToken(),split.nextToken(),split.nextToken(),Integer.parseInt(split.nextToken())));
            }        
            line = input2.readLine();
            System.out.println(line);
        }
        input2.close();
        
        s1.displayAll();
        s1.sortArray();
        System.out.println("SORTED");
        s1.displayAll();       
        //s1.removeDuplicates();
        
        //Collections.sort(data);
        
    }
    
}
