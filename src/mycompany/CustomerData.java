package mycompany;

import java.util.ArrayList;

/**
 *
 * @author D00186562
 */
public class CustomerData {
    
    private ArrayList<Customer> allCustomers;
    
    public CustomerData(){
        allCustomers= new ArrayList<>();
    }
    
    public void addCustomer(Customer c){
        allCustomers.add(c);
    }
    
    public void removeDuplicate(){
        //TODO
    }
    
    @Override
    public String toString() {
        return "CustomerData{" + "allCustomers=" + allCustomers + '}';
    }
    
}
