package GasBooking;

import java.util.*;
import java.util.concurrent.TimeUnit;

import Customers.GasConnection;

import java.text.*;

public class Booking extends GasConnection{
    
    public int otp=5678,amount=900;

    public double refund=0;

    public Date bookingDate = null;
    public Date deliveryDate = null;

    public String status,deliveryPhone="9823822837";

    public Booking(String name, String street, String area, String pincode, String mobile,int numberOfCylinders)
    {
        super(name, street, area, pincode, mobile,numberOfCylinders);
    }
    
    public void getDates ()
    {

        //getting booking date details

        System.out.print("Enter booking date : ");
        String tempDate = sc.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try 
        {
            bookingDate = dateFormat.parse(tempDate);
        } catch (Exception e) 
        {
            System.out.println("Error parsing booking date : "+e);
        }

        //delivery details

        System.out.print("Enter Delivery Date : ");
        tempDate = sc.nextLine();
        try {
            deliveryDate = dateFormat.parse(tempDate);
        } catch (Exception e) {
            System.out.println("Error parsing delivery date : "+e);
        }

        //finding difference between two dates

        try {
            long differenceTime = deliveryDate.getTime()-bookingDate.getTime();
            long differenceDays = TimeUnit.DAYS.convert(differenceTime,TimeUnit.MILLISECONDS);
            if(differenceDays>7)
            {
                status = "P";
            }
        } catch (Exception e) {
            System.out.println("Error while finding difference in dates : "+e);
        }
    }

 public void validate()
    {
        //finding difference between booking and last date.
        long difference = bookingDate.getTime()-lastDate.getTime();
        long days = TimeUnit.DAYS.convert(difference,TimeUnit.MILLISECONDS);

        if(numberOfCylinders==1)
        {
            //to book 1 cylinder the difference between last booking date and booking date must be >30
            //it means that 30 days must have been passed to book 1 cylinder
            if(days<30)
            {
                System.out.println("Booking cannot be done, You can book 1 cylinder after "+(int)(30-days)+"days.");
                status ="C";//status cancelled
                numberOfCylinders=0;
            }
            else 
            {
                System.out.println("Booking done.");
                status="B";//status booked.
                lastDate=bookingDate;
                numberOfCylinders=1;
            }

        }
        else if(numberOfCylinders==2)
        {
            //to book 2 cylinders the difference between last booking date and booking date must be >50
            //it means that 50 days must have been passed to book 2 cylinders
            if(days<50)
            {
                System.out.println("Booking cannot be done, You can book 2 cylinders after "+(int)(50-days)+"days.");
                status ="C";//status cancelled
                numberOfCylinders=0;
            }
            else 
            {
                System.out.println("Booking done.");
                status="B";//status booked.
                lastDate=bookingDate;
                numberOfCylinders=2;
            }
        }
    }


}
