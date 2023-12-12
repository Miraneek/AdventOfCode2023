package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day02 {
    public static File file = new File("src/day02/input.txt");
    public static Scanner scanner;

    static {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String[] input;
        String[] turn;
        String input2;
        int id;
        int sum = 0;
        while (scanner.hasNextLine()) {
            boolean gameLagit = true;
            input2 = scanner.nextLine().replace("Game ", "").replace(": ", ";");
            input = input2.split(";");
            id = Integer.parseInt(input[0]);
            for (int i = 1; i < input.length; i++) {
                int redCount = 0;
                int greenCount = 0;
                int blueCount = 0;
                String[] game = input[i].split(", ");
                for (int j = 0; j < game.length; j++) {
                    game[j] = game[j].trim();
                }
                for (int j = 0; j < game.length; j++) {
                    turn = game[j].split(" ");
                    if (turn[1].equals("red")) {
                        redCount = Integer.parseInt(turn[0]);
                        if (redCount > 12) {
                            gameLagit = false;
                            break;
                        }
                    } else if (turn[1].equals("green")) {
                        greenCount = Integer.parseInt(turn[0]);
                        if (greenCount > 13) {
                            gameLagit = false;
                            break;
                        }
                    } else if (turn[1].equals("blue")) {
                        blueCount = Integer.parseInt(turn[0]);
                        if (blueCount > 14) {
                            gameLagit = false;
                            break;
                        }
                    }
                }
                if (!gameLagit) {
                    break;
                }
            }
            if (gameLagit) {
                sum += id;
            }
        }
        System.out.println(sum);
    }
}