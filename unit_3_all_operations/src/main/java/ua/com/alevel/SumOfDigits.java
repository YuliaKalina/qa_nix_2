package ua.com.alevel;

import java.util.Scanner;

public class SumOfDigits {
    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string to add the numbers: ");
        String str = sc.next();

        int sum = 0;

        for(int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                sum = sum + Integer.parseInt(str.charAt(i) + "");
            }
        }

        System.out.println("The result of adding numbers: " + sum);
    }
}
