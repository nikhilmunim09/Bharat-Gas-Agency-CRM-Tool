package Customers;

import gasSupplier.GasAgencies;

public class Customer implements GasAgencies{

    public String cusName;

    public String cusStreet;

    public String cusArea;

    public String cusPincode;

    public String cusMobile;

    Customer(String name, String street, String area, String pincode, String mobile) {

        this.cusName = name;

        this.cusStreet = street;

        this.cusArea = area;

        this.cusPincode = pincode;

        this.cusMobile = mobile;

    }
    
}
