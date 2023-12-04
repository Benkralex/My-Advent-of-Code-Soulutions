package de.benkralex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> input = new ArrayList<String>();
        try {
            File datei = new File("input.txt");
            System.out.println(datei.getAbsolutePath());
            Scanner scanner = new Scanner(datei);
            while (scanner.hasNext()) {
                input.add(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        ///
        ///
        int solutionpart1 = 0;
        int solutionpart2 = 0;
        for (String s : input) {
            int minred = 0;
            int minblue = 0;
            int mingreen = 0;
            String game = s.split(":")[0];
            s = s.split(":")[1];
            Boolean possible = true;
            String[] strings = s.split(";");
            for (String string : strings) {
                String[] split = string.split(",");
                for (String s1 : split) {
                    if (s1.contains("red")) {
                        String rednum = s1.replace("red", "");
                        rednum = rednum.replace(" ", "");
                        if (possible) {
                            possible = Integer.parseInt(rednum) <= 12;
                        }
                        if (minred < Integer.parseInt(rednum)) {
                            minred = Integer.parseInt(rednum);
                        }
                    } else if (s1.contains("blue")) {
                        String bluenum = s1.replace("blue", "");
                        bluenum = bluenum.replace(" ", "");
                        if (possible) {
                            possible = Integer.parseInt(bluenum) <= 14;
                        }
                        if (minblue < Integer.parseInt(bluenum)) {
                            minblue = Integer.parseInt(bluenum);
                        }
                    } else if (s1.contains("green")) {
                        String greennum = s1.replace("green", "");
                        greennum = greennum.replace(" ", "");
                        if (possible) {
                            possible = Integer.parseInt(greennum) <= 13;
                        }
                        if (mingreen < Integer.parseInt(greennum)) {
                            mingreen = Integer.parseInt(greennum);
                        }
                    }
                }
            }
            if (possible) {
                String gamenum = game.replace("Game", "");
                gamenum = gamenum.replace(" ", "");
                solutionpart1 += Integer.parseInt(gamenum);
            }
            solutionpart2 += (minred * minblue * mingreen);
        }
        System.out.println("Part 1: " + solutionpart1);
        System.out.println("Part 2: " + solutionpart2);
    }
}