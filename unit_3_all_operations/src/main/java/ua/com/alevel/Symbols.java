package ua.com.alevel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Symbols {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string to count the characters: ");
        String str = sc.next();

        Map<Character, Integer> symbols = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if(!symbols.containsKey(charAt)) {
                symbols.put(charAt, 1);
            }
            else {
                symbols.put(charAt, symbols.get(charAt) + 1);
            }
        }
        System.out.println("Characters: " + symbols);
    }
}
