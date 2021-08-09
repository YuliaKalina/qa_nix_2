package ua.com.alevel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.print("\nMake a choice:" +
                    "\n 1. reverse all" +
                    "\n 2. reverse" +
                    "\n 3. reverse + substrings" +
                    "\n 4. reverse + indexes" +
                    "\n 5. exit" +
                    "\n num> ");
            Scanner sc = new Scanner(System.in);
            int numChoice = sc.nextInt();
            sc.nextLine();
            if (numChoice == 1) {
                System.out.print("Enter the string to reverse: ");
                String str = sc.nextLine();
                System.out.print("Reversed string: " + Reverse.reverse(str, false));
            } else if (numChoice == 2) {
                System.out.print("Enter the string to reverse: ");
                String str = sc.nextLine();
                System.out.print("Reversed string: " + Reverse.reverse(str, true));
            } else if (numChoice == 3) {
                System.out.print("Enter the main string: ");
                String str = sc.nextLine();
                System.out.println("Enter the substring to reverse:");
                String target = sc.nextLine();
                System.out.print("Reversed string:" + Reverse.reverse(str, target));
            } else if (numChoice == 4) {
                System.out.print("Enter the main string: ");
                String str = sc.nextLine();
                System.out.print("Enter the first index: ");
                int start = sc.nextInt();
                System.out.print("Enter the second index: ");
                int end = sc.nextInt();
                System.out.print("Reversed string: " + Reverse.reverse(str, start, end));
            } else if (numChoice == 5) {
                System.out.println("Bye! Get back, I'll happy to help you :)");
                break;
            } else {
                break;
            }
        }
    }
}



