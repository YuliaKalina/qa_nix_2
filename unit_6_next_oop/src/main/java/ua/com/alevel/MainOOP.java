package ua.com.alevel;

import ua.com.alevel.planets.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainOOP {
    public static void main(String[] args) {
        PlanetReporter reporter = new PlanetReporter();
        while (true) {
            printMenu();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int input = 3;
            try {
                input = Integer.parseInt(reader.readLine());
                if(input == 0) break;
            } catch (IOException e) {
                System.out.println("problem: " + e.getMessage());
            }
            Planet planet = selectPlanet(input);
            reporter.setPlanet(planet).report();
        }
    }

    public static void printMenu(){
        System.out.println(" 1 - Mercury " +
                "\n 2 - Venus " +
                "\n 3 - Earth " +
                "\n 4 - Mars " +
                "\n 5 - Jupiter " +
                "\n 6 - Saturn " +
                "\n 7 - Uranus " +
                "\n 8 - Neptune ");
        System.out.println("If you want to exit, please enter 0");
    }

    public static Planet selectPlanet(int i) {
        switch (i) {
            case 1:
                return new Mercury();
            case 2:
                return new Venus();
            case 3:
                return new Earth();
            case 4:
                return new Mars();
            case 5:
                return new Jupiter();
            case 6:
                return new Saturn();
            case 7:
                return new Uranus();
            case 8:
                return new Neptune();
            default:
                throw new IllegalArgumentException("No such planet");
        }
    }
}



