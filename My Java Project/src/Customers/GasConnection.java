package Customers;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class GasConnection extends Customer{
    public int numberOfCylinders ;
    //numberofCylinders will be intialized if booking is confirmed

    public Scanner sc = new Scanner(System.in);

    //this tempConnectionNumber will increase by one each time an object is created.
    static int tempConnectionNumber = 100;

    //this will assign the tempConnectionNumber to connectionNumber of the object of this class.
    public int connectionNumber;



    
    public GasConnection(String name, String street, String area, String pincode, String mobile,int numberOfCylinders)
    {
        super(name, street, area, pincode, mobile);
        this.numberOfCylinders=numberOfCylinders;
        connectionNumber = ++tempConnectionNumber;
    }
    
    public Date lastDate = null;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public void getLastDate() 
    {
        System.out.print("Enter the last date : ");
        String date = sc.nextLine();
        try {
            lastDate = dateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("Error in getLastDate : "+e);
        }
    }

    
}
