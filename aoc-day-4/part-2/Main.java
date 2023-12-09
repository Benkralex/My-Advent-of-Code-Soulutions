package de.benkralex;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            File datei = new File("C:/Users/Admin/Documents/GitHub/aoc-day4/src/main/java/de/benkralex/input.txt");
            System.out.println(datei.getAbsolutePath());
            Scanner scanner = new Scanner(datei);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int cardNum;
                int hits = 0;
                List<Integer> luckyNums = new ArrayList<>();
                List<Integer> yourNums = new ArrayList<>();
                List<Integer> linkedCopyCards = new ArrayList<>();
                cardNum = Integer.parseInt(line.split(": ")[0].split(" ")[line.split(": ")[0].split(" ").length - 1]);
                for (String s : Arrays.asList(line.split(": ")[1].split(" \\| ")[0].split(" "))) {
                    if (!(s == null || s.length() <= 0)) {
                        for (int i = 0; i < s.length(); i++) {
                            if (!Character.isDigit(s.charAt(i))) {
                                s.replace("" + s.charAt(i), "");
                            }
                        }
                        luckyNums.add(Integer.parseInt(s));
                    }
                }
                for (String s : Arrays.asList(line.split(": ")[1].split(" \\| ")[1].split(" "))) {
                    if (!(s == null || s.length() <= 0)) {
                        for (int i = 0; i < s.length(); i++) {
                            if (!Character.isDigit(s.charAt(i))) {
                                s.replace("" + s.charAt(i), "");
                            }
                        }
                        yourNums.add(Integer.parseInt(s));
                    }
                }
                System.out.println(cardNum);
                for (Integer luckyNum : luckyNums) {
                    if (yourNums.contains(luckyNum)) {
                        hits++;
                        System.out.println(luckyNum);
                    }
                }
                for (int i = 1; i <= hits; i++) {
                    linkedCopyCards.add(cardNum + i);
                }
                System.out.println(luckyNums);
                System.out.println(yourNums);
                System.out.println(linkedCopyCards);
                System.out.println(hits);
                System.out.println();
                Card.cards.add(new Card(cardNum, luckyNums, yourNums, linkedCopyCards, hits));
            }
            System.out.print("\n\n\n");
            for (Card card : Card.cards) {
                Card.addCard(card);
            }
            System.out.println(Card.solution_part2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}