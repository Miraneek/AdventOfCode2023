package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day1 {

    public static File file = new File("input.txt");
    public static Scanner scanner;
    static {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> numbers = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine"));
    public static void main(String[] args){
        int sum = 0;
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            sum += Integer.parseInt(getFirstAndLastNumber(line));
        }


        System.out.printf("Součet všech čisel: %d", sum);
    }

    public static String getFirstAndLastNumber(String line) {
        String firstNumber = "";
        String secondNumber = "";

        line = line.replace("zero", "zero0zero");
        line = line.replace("one", "one1one");
        line = line.replace("three", "three3three");
        line = line.replace("four", "four4four");
        line = line.replace("five", "five5five");
        line = line.replace("six", "six6six");
        line = line.replace("seven", "seven7seven");
        line = line.replace("nine", "nine9nine");
        line = line.replace("eight", "eight8eight");
        line = line.replace("two", "two2two");

        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                firstNumber = line.charAt(i) + "";
                break;
            }
        }

        for (int i = line.length() - 1; i >= 0; i--) {
            if (Character.isDigit(line.charAt(i))) {
                secondNumber = line.charAt(i) + "";
                break;
            }

        }
        return firstNumber + secondNumber;
    }
}