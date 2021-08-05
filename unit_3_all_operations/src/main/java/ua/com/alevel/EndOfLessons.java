package ua.com.alevel;
import java.util.Scanner;

public class EndOfLessons {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter lesson: ");
        int a = sc.nextInt();

        a = a * 45 + (a / 2) * 5 + ((a + 1) / 2 - 1) * 15;

        int hours = a / 60 + 9;
        int minutes = a % 60;
        System.out.print("Lesson end time: "+ hours + ":" + minutes);
    }
}
