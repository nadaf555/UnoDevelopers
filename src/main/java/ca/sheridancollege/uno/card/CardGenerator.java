package ca.sheridancollege.uno.card;

import java.util.ArrayList;
import java.util.List;

public class CardGenerator {

    public static List<Card> generateDeck() {
        List<Card> deck = new ArrayList<>();
        
        for (Card.Color color : Card.Color.values()) {
            if (color != Card.Color.WILD) {
                // Add number cards
                for (int i = 0; i <= 9; i++) {
                    deck.add(new RegularCard(color, i));
                    if (i != 0) { // Two of each card from 1-9
                        deck.add(new RegularCard(color, i));
                    }
                }
                // Add action cards: Skip, Reverse, and Draw Two
                deck.add(new Skip(color));
                deck.add(new Skip(color)); // Two Skip cards
                deck.add(new Reverse(color));
                deck.add(new Reverse(color)); // Two Reverse cards
                deck.add(new Plus2(color));
                deck.add(new Plus2(color)); // Two Draw Two cards
            }
        }
        // Add wild cards
        for (int i = 0; i < 4; i++) {
            deck.add(new Wild());
            deck.add(new Plus4());
        }

        return deck;
    }
}
