package de.benkralex;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            File datei = new File("input.txt");
            System.out.println(datei.getAbsolutePath());
            Scanner scanner = new Scanner(datei);
            int solutionpart1 = 0;
            while (scanner.hasNextLine()) {
                String nums = scanner.nextLine().split(": ")[1];
                List<String> yournums = Arrays.asList(nums.split(" \\| ")[1].split(" "));
                int hits = 0;
                for (String s : nums.split(" \\| ")[0].split(" ")) {
                    if (!s.equals(" ") && !s.isEmpty()) {
                        if (yournums.contains(s)) {
                            hits++;
                        }
                    }
                }
                if (!(hits == 0)) {
                    solutionpart1 += Math.pow(2, hits-1);
                }
            }
            System.out.println(solutionpart1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}