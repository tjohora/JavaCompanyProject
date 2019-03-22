package mycompany;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
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
        Stock stockArray = new Stock();
        Scanner input = new Scanner(new File("item.txt"));
        input.useDelimiter(",");
        PrintStream invalid = new PrintStream(new File("invalidItem.txt"));

        String name;
        int id, quantityInStock;
        double UnitPrice;

        while (input.hasNext()) {
            try {
                name = input.next();
                id = input.nextInt();
                quantityInStock = input.nextInt();
                UnitPrice = input.nextDouble();
                stockArray.add(new Item(name, id, quantityInStock, UnitPrice));
//                s1.add(new Item(input.next(), input.nextInt(), input.nextInt(), input.nextDouble()));                           
            } catch (InputMismatchException e) {
                invalid.println(input.nextLine());
            }
        }
        input.close();
//        s1.displayAll();
//
//        customerType customerName customerAddress email balance creditLimit 
//        OR customerType customerName customerAddress email loyaltyPoints 
        String customerType, customerName, customerAddress, email;
        double balance, creditLimit;
        int loyaltyPoints;

        BufferedReader input2 = new BufferedReader(new FileReader("customers.txt"));
        String line = input2.readLine();

        CustomerData customerList = new CustomerData();

        while (line != null) {
            StringTokenizer split = new StringTokenizer(line);
            customerType = split.nextToken();
            customerName = split.nextToken();
            customerAddress = split.nextToken();
            email = split.nextToken();

            if (customerType.equalsIgnoreCase("business")) {
                balance = Double.parseDouble(split.nextToken());
                creditLimit = Double.parseDouble(split.nextToken());

                customerList.addCustomer(new BusinessCustomer(customerType, customerName, customerAddress, email, balance, creditLimit));
//                data.addCustomer(new BusinessCustomer(customerType,split.nextToken(),split.nextToken(),split.nextToken(),Double.parseDouble(split.nextToken()),Double.parseDouble(split.nextToken())));
            } else {
                loyaltyPoints = Integer.parseInt(split.nextToken());
                customerList.addCustomer(new PrivateCustomer(customerType, customerName, customerAddress, email, loyaltyPoints));
//                data.addCustomer(new PrivateCustomer(customerType,split.nextToken(),split.nextToken(),split.nextToken(),Integer.parseInt(split.nextToken())));
            }
            line = input2.readLine();
        }
        input2.close();

        stockArray.displayAll();
        Arrays.sort(stockArray.getArray(), new ComparatorAscendingID());
//        stockArray.sortArray();
        System.out.println("SORTED");
        stockArray.displayAll();
//        s1.removeDuplicates();

//        Collections.sort(customerList);
    }

}
