package de.benkralex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            List<Coordinats> symbols = new ArrayList<>();
            File datei = new File("input.txt");
            System.out.println(datei.getAbsolutePath());
            Scanner scanner = new Scanner(datei);
            int x = 0;
            while (scanner.hasNextLine()) {
                int y = 0;
                String line = scanner.nextLine();
                for (char c : line.toCharArray()) {
                    if (c != '.' && !Character.isDigit(c)) {
                        symbols.add(new Coordinats(c, x, y));
                    }
                    y++;
                }
                x++;
            }
            scanner.close();
            scanner = new Scanner(datei);
            x = 0;
            String num = "";
            int solutionpart1 = 0;
            while (scanner.hasNextLine()) {
                boolean nearBy = false;
                int y = 0;
                String line = scanner.nextLine();
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c)) {
                        num += c;
                        if (!nearBy) {
                            for (Coordinats symbol : symbols) {
                                nearBy = symbol.isNearBy(x, y);
                                if (nearBy) {
                                    break;
                                }
                            }
                        }
                    } else {
                        if (nearBy) {
                            System.out.println(num);
                            solutionpart1 += Integer.parseInt(num);
                        }
                        nearBy = false;
                        num = "";
                    }
                    y++;
                }
                if (nearBy) {
                    System.out.println(num);
                    solutionpart1 += Integer.parseInt(num);
                }
                nearBy = false;
                num = "";
                x++;
            }
            System.out.println(solutionpart1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}