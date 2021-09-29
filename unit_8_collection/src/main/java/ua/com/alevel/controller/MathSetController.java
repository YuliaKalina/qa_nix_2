package ua.com.alevel.controller;

import ua.com.alevel.entity.MathSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MathSetController {
    private static final MathSet<Integer> numbers = new MathSet<>();
    private static MathSet mathSet;
    private static final int CAPACITY = 10;

    public static String getString() {
        String input = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = reader.readLine().trim();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return input;
    }

    public static int getInt() {
        try {
            return Integer.parseInt(getString());
        } catch (NumberFormatException e) {
            System.out.println("Enter a value:");
        }
        return getInt();
    }

    public void navigation() {
        MathSetController service = new MathSetController();
        while (true) {
            System.out.println("Select an option: \n" +
                    "1 - create new MathSet \n" +
                    "2 - add/join into MathSet \n" +
                    "3 - delete from MathSet \n" +
                    "4 - sort MathSet \n" +
                    "5 - get from MathSet \n" +
                    "0 - exit");

            int input = getInt();
            switch (input) {
                case 1:
                    service.create();
                    break;
                case 2:
                    service.add();
                    break;
                case 3:
                    service.delete();
                    break;
                case 4:
                    service.sort();
                    break;
                case 5:
                    service.get();
                    break;
                case 0:
                    System.out.println("See you soon");
                    break;
                default:
                    System.out.println("Select an option");
                    break;
            }
            if (input == 0) break;
        }
    }

    public void create() {
        System.out.println("Select an option: \n" +
                "1 - MathSet() \n" +
                "2 - MathSet(int capacity) \n" +
                "3 - MathSet(Number[] numbers) \n" +
                "4 - MathSet(Number[] ... numbers)");

        int select = getInt();
        switch (select) {
            case 1:
                mathSet = new MathSet();
                break;
            case 2:
                System.out.println("Enter the capacity");
                int size = getInt();
                mathSet = new MathSet(size);
                break;
            case 3:
                System.out.println("Enter the numbers");
                String numString = getString();
                Number[] numbers = getArrayFromString(numString);
                mathSet = new MathSet(numbers);
                break;
            case 4:
                Number[][] arrayOfNumbers = getArrayNum();
                mathSet = new MathSet(arrayOfNumbers);
                break;
            default:
                System.out.println("Try again");
        }
        mathSet.printMathSet();
    }

    public void add() {
        System.out.println("Select an option: \n" +
                "1 - add number \n" +
                "2 - add array \n" +
                "3 - join MathSet \n" +
                "4 - join many MathSets \n" +
                "5 - intersection MathSet \n" +
                "6 - intersection many MathSets \n");

        if (mathSet == null) mathSet = new MathSet();
        MathSet ms = mathSet;
        MathSet[] array;
        String numString;
        Number value;
        int select = getInt();

        switch (select) {
            case 1:
                System.out.println("Enter number for adding to MathSet");
                numString = getString();
                value = getStrNum(numString);
                if (value != null) {
                    mathSet.add(value);
                }
                break;
            case 2:
                System.out.println("Enter numbers for adding to MathSet");
                String num = getString();
                Number[] numbers = getArrayFromString(num);
                mathSet.add(numbers);
                break;
            case 3:
                System.out.println("Choose and input MathSet");
                create();
                ms.join(mathSet);
                mathSet = ms;
                break;
            case 4:
                System.out.println("Input MathSets");
                array = getarray();
                ms.join(array);
                mathSet = ms;
                break;
            case 5:
                System.out.println("Choose and input MathSet");
                create();
                ms.intersection(mathSet);
                mathSet = ms;
                break;
            case 6:
                System.out.println("Input MathSets");
                array = getarray();
                ms.intersection(array);
                mathSet = ms;
                break;
            default:
                System.out.println("Try again");
        }
        System.out.println("Result of action:");
        mathSet.printMathSet();
    }

    public void sort() {
        System.out.println("Select an option: \n" +
                "1 - to sort descending \n" +
                "2 - to sort descending with index from to \n" +
                "3 - to sort descending from value \n" +
                "4 - to sort ascending \n" +
                "5 - to sort ascending with index from to \n" +
                "6 - to sort ascending from value");

        Number value;
        int fromIndex, toIndex;
        int select = getInt();
        String str;

        switch (select) {
            case 1:
                mathSet.sortDesc();
                break;
            case 2:
                System.out.println("Enter index from:");
                fromIndex = getInt();
                System.out.println("Enter index to:");
                toIndex = getInt();
                mathSet.sortDesc(fromIndex, toIndex);
                break;
            case 3:
                System.out.println("Enter value from:");
                str = getString();
                value = getStrNum(str);
                if (value != null) {
                    mathSet.sortDesc(value);
                }
                break;
            case 4:
                mathSet.sortAsc();
                break;
            case 5:
                System.out.println("Enter index from:");
                fromIndex = getInt();
                System.out.println("Enter index to:");
                toIndex = getInt();
                mathSet.sortAsc(fromIndex, toIndex);
                break;
            case 6:
                System.out.println("Enter value from:");
                str = getString();
                value = getStrNum(str);
                if (value != null) {
                    mathSet.sortAsc(value);
                }
                break;
            default:
                System.out.println("Try again");
        }

        System.out.println("Result of action:");
        mathSet.printMathSet();
    }

    public void get() {
        System.out.println("Select an option: \n " +
                "1 - to get number with index \n" +
                "2 - to get max value from MathSet \n" +
                "3 - to get min value from MathSet \n" +
                "4 - to get average value from MathSet \n" +
                "5 - to get median value from MathSet \n" +
                "6 - to get array from MathSet \n" +
                "7 - to get array from MathSet with from to indexes");

        if (mathSet == null) mathSet = new MathSet();
        Number[] array;
        Number value;
        int select = getInt();

        switch (select) {
            case 1:
                System.out.println("Enter index:");
                int index = getInt();
                value = mathSet.get(index);
                if (value == null) {
                    System.out.println("Try again");
                } else {
                    System.out.println("This value -" + value);
                }
                break;
            case 2:
                Number max = mathSet.getMax();
                System.out.println("Max value -" + max);
                break;
            case 3:
                Number min = mathSet.getMin();
                System.out.println("Min value -" + min);
                break;
            case 4:
                Number average = mathSet.getAverage();
                System.out.println("Average value -" + average);
                break;
            case 5:
                Number median = mathSet.getMedian();
                System.out.println("Median value -" + median);
                break;
            case 6:
                array = mathSet.toArray();
                System.out.println(Arrays.toString(array));
                break;
            case 7:
                System.out.println("Enter index from:");
                int fromIndex = getInt();
                System.out.println("Enter index to:");
                int toIndex = getInt();
                array = mathSet.toArray(fromIndex, toIndex);
                System.out.println(Arrays.toString(array));
                break;
            default:
                System.out.println("Try again");
        }
    }

    public void delete() {
        System.out.println("Select an option: \n" +
                "1 - clear all from MathSet() \n" +
                "2 - clear some numbers from MathSet \n" +
                "3 - cut indexes from MathSet from to");

        int select = getInt();
        switch (select) {
            case 1:
                mathSet.clear();
                break;
            case 2:
                System.out.println("Enter numbers with space:");
                String string = getString();
                Number[] numbers = getArrayFromString(string);
                mathSet.clear(numbers);
                break;
            case 3:
                System.out.println("Enter index from:");
                int fromIndex = getInt();
                System.out.println("Enter index to:");
                int toIndex = getInt();
                mathSet.cut(fromIndex, toIndex);
                break;
            default:
                System.out.println("Try again");
        }

        System.out.println("Result of action:");
        mathSet.printMathSet();
    }

    private Number[][] getArrayNum() {
        Number[][] array = new Number[CAPACITY][];
        int index = 0;
        System.out.println("Input numbers");
        while (true) {
            String numString = getString();
            if (numString.equals("exit")) break;
            if (index >= array.length) array = getArraySize(array);
            array[index] = getArrayFromString(numString);
            index++;
        }
        return array;
    }

    private Number[][] getArraySize(Number[][] array) {
        int newSize = (int) ((array.length * 1.5) + 1);
        Number[][] newArray = new Number[newSize][];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, newArray[i], 0, array[i].length);
        }
        return newArray;
    }

    private Number getStrNum(String string) {
        Number value = null;
        if (string.matches("\\-?\\d+\\.\\d+")) {
            value = Double.parseDouble(string);
        } else if (string.matches("\\-?\\d+")) {
            value = Integer.parseInt(string);
        } else System.out.println("Try again");
        return value;
    }

    private Number[] getArrayFromString(String numString) {
        String[] temp = numString.split(" ");
        Number[] numbers = new Number[temp.length];
        Number value;
        for (int i = 0; i < temp.length; i++) {
            value = getStrNum(temp[i]);
            if (value != null) {
                numbers[i] = value;
            }
        }
        return numbers;
    }

    private MathSet[] getarray() {
        MathSet[] sets = new MathSet[CAPACITY];
        int index = 0;
        do {
            System.out.println("Add MathSet:");
            if (index >= sets.length) sets = getArraySize(sets);
            create();
            sets[index] = mathSet;
            index++;
            System.out.println("Do you want to stop create MathSets? (Y/N)");
        } while (false);
        return sets;
    }

    private MathSet[] getArraySize(MathSet[] sets) {
        int newSize = (int) ((sets.length * 1.5) + 1);
        MathSet[] newArray = new MathSet[newSize];
        System.arraycopy(sets, 0, newArray, 0, sets.length);
        return newArray;
    }

}

