package mycompany;

/**
 *
 * @author D00186562
 */
public class BusinessCustomer extends Customer{
    private double balance;
    private double creditLimit;

    public BusinessCustomer(String type, String name, String address, String email,double balance, double creditLimit) {
        super(type, name, address, email);
        this.balance = balance;
        this.creditLimit = creditLimit;
    }

    

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "BusinessCustomer{" + "balance=" + balance + ", creditLimit=" + creditLimit + '}';
    } 
}
