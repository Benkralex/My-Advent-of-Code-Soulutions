package de.benkralex;

import java.util.ArrayList;
import java.util.List;

public class Card {
    public static int solution_part2 = 0;
    public static List<Card> cards = new ArrayList<>();
    public int cardNum;
    public List<Integer> luckyNums;
    public List<Integer> yourNums;
    public List<Integer> linkedCopyCards;
    public int hits;

    public Card(int cardNum, List<Integer> luckyNums, List<Integer> yourNums, List<Integer> linkedCopyCards, int hits) {
        this.cardNum = cardNum;
        this.luckyNums = luckyNums;
        this.yourNums = yourNums;
        this.linkedCopyCards = linkedCopyCards;
        this.hits = hits;
    }
    public static void addCard(Card card) {
        solution_part2++;
        /*System.out.println(card.cardNum + ":");
        System.out.println(card.linkedCopyCards);
        System.out.println();*/
        for (Integer i : card.linkedCopyCards) {
            addCard(cards.get(i - 1));
        }
    }
}
