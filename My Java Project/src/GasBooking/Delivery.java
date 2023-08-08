package GasBooking;

import java.util.concurrent.TimeUnit;

public class Delivery extends Booking{

    public String delPersonName;

    int customerOtp;


    public Delivery(String name, String street, String area, String pincode, String mobile, int numberOfCylinders) {
        super(name, street, area, pincode, mobile, numberOfCylinders);
    }

    public void CalcAmount()
    {
        // difference between two dates in time.
        long timeDiff = deliveryDate.getTime()-bookingDate.getTime();
        //in days 
        long daysDiff = TimeUnit.DAYS.convert(timeDiff,TimeUnit.MILLISECONDS);

        //here the logic is if difference between delivery date and booking date is greater than 7 than the delivery is considered late
        //and refund is provided for the late delivery.
        if(daysDiff>7)
        {
            refund=41.25;
        }
    }

    public void verifyOtp()
    {
        if(status.equals("B"))
        {
            
            System.out.print("Enter OTP : ");
            customerOtp = sc.nextInt();
            if(customerOtp==otp)
            {
                status = "D"; //delivered.
            }
            else 
            {
                status="C"; //canceled
                numberOfCylinders=0;
            }
            
        }
        else 
        {
            System.out.println("No booking found !!");
        }
    }

    public void delPersonDetails()
    {
        System.out.print("\nEnter delivery person's name : ");
        delPersonName = sc.nextLine();
    }
    
}
