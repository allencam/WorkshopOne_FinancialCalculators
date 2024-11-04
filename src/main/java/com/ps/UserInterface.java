package com.ps;

import java.util.Scanner;

public class UserInterface {
    static Scanner commandScan = new Scanner(System.in);
    static Scanner inputScan = new Scanner(System.in);

    public static void init() {
        byte mainMenuCommand;
        do {
            System.out.print("""
                     Welcome, please select an option:
                     (1) Mortgage Calculation
                     (2) CD Future Value Calculator
                     (3) Annuity Calculator
                    """);
            System.out.print("Your selection: ");
            mainMenuCommand = commandScan.nextByte();

            switch (mainMenuCommand) {
                case 1:
                    processMortgageCalc();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Input invalid, please try again");
            }
        } while(mainMenuCommand != 0);
    }
    private static void processMortgageCalc() {
        System.out.print("Principal loan amount: ");
        float principal = inputScan.nextFloat();
        System.out.print("Interest rate (without the % sign): ");
        float monthlyRate = inputScan.nextFloat();
        System.out.print("Enter the length of the loan in years: ");
        byte loanLengthInYears = inputScan.nextByte();

        double monthlyPayment = Calc.mortgageCalc(principal,monthlyRate,loanLengthInYears);

        System.out.printf("Monthly payment: $%.2f", monthlyPayment);
    }
    private static void processCdCalc() {
        System.out.print("Enter the initial deposit amount: ");
        double principal = inputScan.nextDouble();
        System.out.print("Enter the annual interest rate without the % sign: ");
        float annualInterestRate = inputScan.nextFloat();
        System.out.print("How many times does interest compound per year (most CDs compound daily, so 365 times): ");
        short compFrequency = inputScan.nextShort();
        System.out.print("How many years until the maturity date? ");
        byte timeInYears = inputScan.nextByte();

        double futureValue = Calc.cdCalc(principal,annualInterestRate,compFrequency,timeInYears);

        System.out.printf("Future Value: $%.2f",futureValue);
    }
}
