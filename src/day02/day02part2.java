package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day02part2 {
    public static File file = new File("src/day02/input.txt");
    public static Scanner scanner;
    static {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String[] input;
        String[] turn;
        String input2;
        int id;
        long sum = 0;
        while (scanner.hasNextLine()) {

            int redMinCount = 0;
            int greenMinCount = 0;
            int blueMinCount = 0;

            input2 = scanner.nextLine().replace("Game ", "").replace(": ", ";");
            input = input2.split(";");

            for (int i = 1; i < input.length; i++) {
                String[] game = input[i].split(", ");
                for (int j = 0; j < game.length; j++) {
                    game[j] = game[j].trim();
                }
                for (String s : game) {
                    turn = s.split(" ");
                    if (turn[1].equals("red")) {
                        redMinCount = Math.max(Integer.parseInt(turn[0]), redMinCount);
                    } else if (turn[1].equals("green")) {
                        greenMinCount = Math.max(Integer.parseInt(turn[0]), greenMinCount);
                    } else if (turn[1].equals("blue")) {
                        blueMinCount = Math.max(Integer.parseInt(turn[0]), blueMinCount);
                    }
                }
            }
            sum += (long) redMinCount * greenMinCount * blueMinCount;
        }
        System.out.println(sum);
    }
}