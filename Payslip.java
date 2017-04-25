package UniProject.MorePay;

import java.util.Scanner;

/**
 *  
 * Created by Pawel on 31/01/2017.
 *The program use separate methods and appropriate parameters. Suggested methods include:
o	Calculate the gross pay (overtime rate is paid for any number of hours above 40);
o	Calculate the amount of tax paid (25% if Married and 30% if Single);
o	Display all the details as a payslip on the computer screen. 

 */


    public class MorePay {
    public static double Overtime( double a, double b ) {

        return (a  * (b - 40));
    }

        public static double  NormalRate( double c, double d ) {

        return (c * d);
    }


        public static double TaxPaidSingle(double e) {

        return (e * 30/100) ;
    }

        public static double TaxPaidMarried(double k) {

        return (k * 25/100) ;
    }


    public static void main(String[] args) {

        int a;
        int Workers;
        String status, name;
        Scanner input = new Scanner(System.in);


        System.out.print("Please enter number of workers ");
        Workers = input.nextInt();
            for(a = 1; a <= Workers; a++ ){

            System.out.print("Please confirm you are single or married ");
            status = input.next();
            
        System.out.print("Please enter name  ");
        name = input.next();

        double HourlyRate = 11.24;
        double OvertimeRate = 16.59;
        double HoursWorked, GrossPay, NormalHours,  NormalPayment, GrossPayment;

            
        System.out.print("Please enter hours worked  ");
        HoursWorked = input.nextDouble();
        GrossPay = Overtime(OvertimeRate, HoursWorked);
        NormalHours = NormalRate(HourlyRate, HoursWorked);


            NormalPayment = (NormalHours - GrossPay);
            GrossPayment = (NormalPayment + GrossPay);

        if (HoursWorked >= 40) {

            // Rounding to 2 decimal places:

            NormalPayment *=100;
            NormalPayment = Math.round(NormalPayment);
            NormalPayment /=100;
            System.out.println("Employer name "  + name);
            System.out.println("Basic hours = £" + NormalPayment);
            System.out.println("Overtime = £" + GrossPay);
            System.out.println("Total Payment = £" + GrossPayment);
            
        } else{

            System.out.println("Employer name "  + name);
            System.out.println("Basic hours = £" + NormalHours);
            System.out.println("Total Payment = £" + NormalHours);

    }           
    
    //calculation of tax
            if (status.equals("single")){
                
                double taxPaidSingle = TaxPaidSingle(GrossPayment);
                taxPaidSingle *=100;
                taxPaidSingle = Math.round(taxPaidSingle);
                taxPaidSingle /=100;

                System.out.println("Tax = £" + taxPaidSingle);
            } else if (status.equals("married")){

                double taxPaidMarried = TaxPaidMarried(GrossPayment);
                taxPaidMarried *=100;
                taxPaidMarried = Math.round(taxPaidMarried);
                taxPaidMarried /=100;

                System.out.println("Tax = £" +taxPaidMarried);
            }
}}}
