/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany;


import java.util.Objects;

/**
 *
 * @author D00186562
 */
public abstract class Customer implements Comparable<Customer>{
    private String type;
    private String name;
    private String address;
    private String email;

    public Customer(String type, String name, String address, String email) {
        this.type = type;
        this.name = name;
        this.address = address;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", address=" + address + ", email=" + email +'}';
    }
    
    @Override
    public int compareTo(Customer c1){
        return this.name.compareTo(c1.getName());
        //return 0;
    }
    
    
    
    
}
