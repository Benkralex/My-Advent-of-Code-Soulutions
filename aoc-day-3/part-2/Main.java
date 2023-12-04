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
                    if (c == '*') {
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
            int solutionpart2 = 0;
            List<Coordinats> symbolspart2 = new ArrayList<>();
            while (scanner.hasNextLine()) {
                boolean nearBy = false;
                int y = 0;
                String line = scanner.nextLine();
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c)) {
                        num += c;
                            for (Coordinats symbol : symbols) {
                                if (symbol.isNearBy(x, y)) {
                                    nearBy = true;
                                    if (!symbolspart2.contains(symbol)) {
                                        symbolspart2.add(symbol);
                                    }
                                }
                            }
                    } else {
                        if (nearBy) {
                            for (Coordinats symbol : symbolspart2) {
                                symbol.intNearBy.add(Integer.parseInt(num));
                                System.out.println(num);
                            }
                            symbolspart2.clear();
                        }
                        nearBy = false;
                        num = "";
                    }
                    y++;
                }
                if (nearBy) {
                    for (Coordinats symbol : symbolspart2) {
                        symbol.intNearBy.add(Integer.parseInt(num));
                        System.out.println(num);
                    }
                    symbolspart2.clear();
                }
                nearBy = false;
                num = "";
                x++;
            }

            for (Coordinats symbol : symbols) {
                if (symbol.intNearBy.size() == 2) {
                    solutionpart2 += symbol.intNearBy.get(0) * symbol.intNearBy.get(1);
                }
            }
            System.out.println(solutionpart2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}