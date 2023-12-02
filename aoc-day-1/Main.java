package de.benkralex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> input = new ArrayList<String>();
        try {
            File datei = new File("C:/Users/Admin/Documents/GitHub/aoc-day1/src/main/java/de/benkralex/input.txt");
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
        int e = 0;
        int x = 0;
        int e1 = 0;
        int x1 = 0;
        int soulutionpart1 = 0;
        int soulutionpart2 = 0;
        for (String s : input) {
            e = 0;
            x = 0;
            s1 = s;
            s1 = s1.replace("one", "o1e");
            s1 = s1.replace("two", "t2o");
            s1 = s1.replace("three", "t3e");
            s1 = s1.replace("four", "f4r");
            s1 = s1.replace("five", "f5e");
            s1 = s1.replace("six", "s6x");
            s1 = s1.replace("seven", "s7n");
            s1 = s1.replace("eight", "e8t");
            s1 = s1.replace("nine", "n9e");
            System.out.println(s);
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    if (e == 0) {
                        e = Integer.valueOf(String.valueOf(s.charAt(i)))*10;
                    }
                    x = Integer.valueOf(String.valueOf(s.charAt(i)));
                }
            }
            for (int i = 0; i < s1.length(); i++) {
                if (Character.isDigit(s1.charAt(i))) {
                    if (e1 == 0) {
                        e1 = Integer.valueOf(String.valueOf(s1.charAt(i)))*10;
                    }
                    x1 = Integer.valueOf(String.valueOf(s1.charAt(i)));
                }
            }
            e1 = e1 + x1;
            e = e + x;
            soulutionpart2 += e1;
            soulutionpart1 += e;
        }
        System.out.println("Part 1: " + soulutionpart1);
        System.out.println("Part 2: " + soulutionpart2);
    }
}