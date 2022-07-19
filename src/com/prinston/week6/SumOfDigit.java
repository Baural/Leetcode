package com.prinston.week6;

import java.util.Scanner;

/**
 * @author Baurzhan Alzhanov
 * @date on 31.03.2021
 */


public class SumOfDigit {
    public static void main(String[] args) {
        int m, n, sum = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number:");
        m = s.nextInt();
        while(m > 0)
        {
            n = m % 10;
            System.out.println("main integer:"+m);
            sum = sum + n;
            System.out.println("Sum integer:"+sum);
            m = m / 10;
            System.out.println("Rest:"+m);
        }
        System.out.println("Sum of Digits:"+sum);
    }
}
