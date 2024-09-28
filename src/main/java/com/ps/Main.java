package com.ps;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    /* ===== Main Method ======
        start
        ask user if they want (a) - mortgage calc, or (b) CD future value calc ( else/if else )
        ask user to provide values based on their selection and run respective methods depending on condition, create variables here
        print calculated values
        end
     */
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome, what would you like to do?");
        System.out.println("(a)  Mortgage Calculation");
        System.out.println("(b)  CD Future Value Calculator");
        System.out.print("Enter your selection: ");
        String select = scan.nextLine();

        if(select.equals("a")) {
            System.out.print("Enter the principal loan amount: ");
            float principal = scan.nextFloat();
            System.out.print("Enter the interest rate without the % sign: ");
            float monthlyRate = scan.nextFloat();
            System.out.print("Enter the length of the loan in years: ");
            byte loanLengthInYears = scan.nextByte();
            double monthlyPayment = mortgageCalc(principal,monthlyRate,loanLengthInYears);
            System.out.printf("Monthly payment: $%.2f", monthlyPayment);
        } else if(select.equals("b")) {
            System.out.println("This feature is currently in development.");
        } else {
            System.out.println("Invalid entry.");
        }
    }
    public static double mortgageCalc(float principal,float monthlyRate,short loanLengthInYears) {
    /* ===== Mortgage Calc =====
        formula: M (monthly principal and interest payment) = P (principal) * (i [monthly interest rate] / (1 - (1 + i) ^ L (length of loan in months)
        important notes: % values are divided by 100, %.2f will round an interpolated floating point value to two decimal places
    */
        double monthlyPrincipal = principal * ((monthlyRate/12/100) / (1 - (Math.pow(1 + (monthlyRate/12/100),(-loanLengthInYears*12)))));
        return monthlyPrincipal;
    }
}