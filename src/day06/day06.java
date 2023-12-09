package day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day06 {

    //Tento kod funguje pro první i druhý ukol, jediné co jsem změnil kvůli druhému úkolu,
    //bylo změnil INT na LONG

    //dodatečné otázky: Jakou největší vzdálenost jsme schopni urazit a o kolik
    //tím překonáme rekordy?

    public static File file = new File("src/day06/input.txt");
    public static Scanner scanner;

    static {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[][] input = new String[2][4];

    public static void main(String[] args) {

        int sum = 0;
        int output = 1;
        long largestPossibleDistance = 0;

        for (int i = 0; i < 2; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(": ");
            input[i] = parts[1].split(" ");
        }

        for (int i = 0; i < input[0].length; i++) {
            long raceTime = Long.parseLong(input[0][i]);
            long recordDistance = Long.parseLong(input[1][i]);
            for (int j = 0; j < raceTime; j++) {
                long potentialDistance = j * (raceTime - j);
                if (potentialDistance > recordDistance) {
                    sum++;
                    largestPossibleDistance = Math.max(largestPossibleDistance, potentialDistance);
                }
            }
            System.out.printf("For the %d. race the maximum possible distance is %d\n",i+1,largestPossibleDistance);
            output *= sum;
            sum = 0;
        }
        System.out.println("------------");
        System.out.println(output);
    }
}
