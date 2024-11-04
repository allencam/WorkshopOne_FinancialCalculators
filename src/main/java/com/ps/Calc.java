package com.ps;

public class Calc {
    public static double mortgageCalc(float principal,float monthlyRate,short loanLengthInYears) {
//      ===== Mortgage Calc =====
//      - formula: M (monthly principal and interest payment) = P (principal) * (i [monthly interest rate] / (1 - (1 + i) ^ L (length of loan in months)
//      - important notes: % values are divided by 100, %.2f will round an interpolated floating point value to two decimal places
        return principal * ((monthlyRate/12/100) / (1 - (Math.pow(1 + (monthlyRate/12/100),(-loanLengthInYears*12)))));
    }

    public static double cdCalc(double principal,float annualRate,short compFrequency,byte timeInYears) {
//      ===== CD Future Value Calc =====
//      - formula: A (futureValue) = P (initial amount, principal) * (1 + R [annualInterestRate] / n (number of times interest is compounded per year, compFrequency) ^ (n * t (time in years))
//      - Variables/Data Types: futureValue/double (return), principal/double, annualRate/float, compFrequency/short, timeInYears/byte
        return principal * (Math.pow((1 + (annualRate/100) / compFrequency),(compFrequency * timeInYears)));
    }
}
