package com.mahalb;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //declare our constant variables
        final byte MONTH_IN_YEARS = 12;
        final byte PERCENTAGE = 100;

        //creating scanner object and read input from the user (amount of the input)
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        /*
        declaring our int variable. Int is good datatype for storing the principal. I didn't use "short" datatype because
        we cannot store more than 30.000. In case if someone want to calculate for ex. 1.000.000 usd
        */
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        //declaring our float variable for decimal number. I didn't use "double" datatype, "float" is better for small number
        float annualInterestRate = scanner.nextFloat();
        //calculation of monthly interest rate according to our formula
        float monthyInterestRate = annualInterestRate / PERCENTAGE / MONTH_IN_YEARS;

        System.out.print("Period (Year): ");
        //we will read as a byte because max number that we want to store is 30
        byte years = scanner.nextByte();
        //calculation of number of total payment
        int numberOfPayments = years * MONTH_IN_YEARS;

        //So when we collected all the data from the user, now we are ready to calculate Mortgate
        double mortgage = principal
                * (monthyInterestRate * Math.pow(1 + monthyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthyInterestRate, numberOfPayments - 1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
        
    }
}
