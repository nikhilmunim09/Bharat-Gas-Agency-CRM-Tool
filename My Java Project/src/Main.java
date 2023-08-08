import java.text.SimpleDateFormat;
import java.util.*;

import Customers.*;
import GasBooking.*;
import gasSupplier.*;

public class Main {
    
    static int count;

    public static  Scanner sc = new Scanner(System.in);

    static int bCount=0,cCount=0,dCount=0,pCount=0;
    //bcount is booking count ccount is cancelled count dcount is delivered count pcount is pending count
    //these will be used to print report.

    static String dpName;

    //here we are using objects of delivery because it has attributes of all the classes, and we are passing array of delivery objects.
    public static void cylinderCount(Delivery[] objects)
    {
        String[] months = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};

        int[] month = new int[12];

        System.out.println("------------------------ All Deliveries Details-------------------------");

        for(Delivery del : objects)
        {
            //delivery count.
            count=0;
            System.out.println("In the month of "+(months[del.deliveryDate.getMonth()])+" : ");
            System.out.println(" * In "+del.cusArea);

            if(del.status.equals("D"))
            {
                count+=del.numberOfCylinders;
            }


        }
        System.out.println("\n");

    }

    public static void checkLateDel(Delivery[] objects)
    {
        String[] months = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};

        //this will store number of late deliveries as per month[index] like month[0] is of january.
        int month[] = new int[12];

        for(Delivery obj : objects)
        {
            if(obj.amount==858.75 && obj.status.equals("D"))
            {
                month[obj.deliveryDate.getMonth()]++;
            }
        }

        for(int i = 0 ; i < 12 ; i++)
        {
            if(month[i]!=0)
            {
                System.out.println(" * In "+months[i]+" there are "+month[i]+" deliveries.");
            }
        }
    }

    public static void numOfSingleCylinders(Delivery[] objects)
    {
        System.out.println("------------------------Single Cylinder Deliveries-------------------------");
        for(int i = 0 ; i < objects.length ; i++)
        {
            if(objects[i].numberOfCylinders==1)
            {
                System.out.println("Name of customer : "+objects[i].cusName);
                System.out.println("Mobile no : "+objects[i].cusMobile);
                System.out.println("Gas Connection number "+objects[i].connectionNumber);
                System.out.println("----------------------------------");
            }
        }
        System.out.println("\n");

           
    }
    
    public static void numOfDoubleCylinders(Delivery[] objects)
    {
        System.out.println("------------------------Double Cylinders Deliveries-------------------------");
        for(int i = 0 ; i < objects.length ; i++)
        {
            if(objects[i].numberOfCylinders==2)
            {
                System.out.println("Name of customer : "+objects[i].cusName);
                System.out.println("Mobile no : "+objects[i].cusMobile);
                System.out.println("Gas Connection number : "+objects[i].connectionNumber);
                System.out.println("----------------------------------");
            }
        }
        System.out.println("\n");


    }

    public static void deliveryDetails(Delivery[] objects)
    {
        System.out.println("----------delivery details-------------");
        System.out.print("Enter name of delivery person : ");
        dpName = sc.nextLine();

        for(Delivery obj : objects)
        {
            if(obj.status.equals("D") && obj.delPersonName.equals(dpName))
            {
                System.out.println("----------------------------------");
                System.out.println("Customer name : "+obj.cusName);
                System.out.println("-- "+obj.cusStreet+", "+obj.cusArea+", "+obj.cusPincode);
                System.out.println("Delivered on : "+obj.deliveryDate);
            }
        }
    }

    public static void printReport(Delivery[] objects)
    {
        for(Delivery obj : objects)
        {
            if(obj.status.equals("D"))  dCount++; 

            else if(obj.status.equals("B"))  bCount++; 

            else if(obj.status.equals("C"))  cCount++; 

            else if(obj.status.equals("P"))  pCount++; 

            else System.out.println("Invalid status");
        
        }

        System.out.println("\n\n----------------------------Printing Report-----------------------------");
        System.out.println("* Booked");
        System.out.println("- "+bCount+" booked");
        System.out.println("* Pending");
        System.out.println("- "+pCount+" pending");
        System.out.println("* Delivered");
        System.out.println("- "+dCount+" delivered");
        System.out.println("* Canceled");
        System.out.println("- "+cCount+" canceled");


    }

    public static void printInvoice(Delivery[] objects)
    {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String invoiceDate = sdf.format(d);
        
        for(Delivery obj : objects)
        {
            if(obj.status.equals("D"))
            {
                System.out.println("***********************************************************************************************");
                System.out.println("                                           INVOICE                                             ");
                System.out.println("-----------------------------------------------------------------------------------------------\n\n");

                System.out.println("---------------------------------------Booking Details-----------------------------------------\n");
                System.out.println("Gas Agency Code : " + GasAgencies.agencyCode + "\t\t\t\t\t" + " Date of Invoice : "+invoiceDate);
                System.out.println("Gas Agency Name : " + GasAgencies.agencyName + "\t\t\t" + " Agency Phone No. : "+GasAgencies.phNumber);
                System.out.println("Gas Connection Number : " + obj.connectionNumber + "\t\t\t\t" + " Customer Name : "+obj.cusName);
                System.out.println("Booking date : "+sdf.format(obj.bookingDate)+"\t\t\t\t"+" Customer Mobile No. : "+obj.cusMobile+"\n");
                System.out.println("---------------------------------------Payment Details-----------------------------------------\n");
                System.out.println("Amount : "+obj.amount);
                System.out.println("Refund : "+obj.refund);
                System.out.println("Total Amount : "+(obj.amount-obj.refund)+"\n");
                System.out.println("---------------------------------------Delivery Details----------------------------------------\n");
                System.out.println("Delivered By : "+obj.delPersonName+"\t\t\t"+"Delivery Person Mobile No.: "+obj.deliveryPhone);
                System.out.println("Delivery Date : "+sdf.format(obj.deliveryDate)+"\n");
                System.out.println("***********************************************************************************************\n\n");

            }
        }
    }

    public static void main(String[] args) {
        System.out.println("******************************************************************");
        System.out.println("                         Bharat Gas Agency                        ");
        System.out.println("******************************************************************");

        Delivery[] objects = new Delivery[5];
        objects[0]=new Delivery("Nikhil", "Alpha - 1", "Pune", "12938", "928492123", 1);
        objects[1]=new Delivery("Akhil", "Ambegaon", "Bareilly", "32421", "3453453345", 2);
        objects[2]=new Delivery("Madhav", "Rampur Garden", "Rampur", "34534", "34345345", 1);
        objects[3]=new Delivery("Nilesh", "Raje chowk", "Delhi", "32543", "34324321", 2);
        objects[4]=new Delivery("Kunal", "Green Park", "Kolkata", "56354", "867867867", 1);

        for(Delivery obj : objects)
        {
            obj.delPersonDetails();
            obj.getLastDate();
            obj.getDates();
            obj.validate();
            obj.CalcAmount();
            obj.verifyOtp();
        }

        System.out.println();
        cylinderCount(objects);
        checkLateDel(objects);
        numOfSingleCylinders(objects);
        numOfDoubleCylinders(objects);
        deliveryDetails(objects);
        printReport(objects);
        printInvoice(objects);

    }
}
