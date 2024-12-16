package ca.sheridancollege.uno.card;

import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = CardGenerator.generateDeck();
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return null; // No cards left
        }
        return cards.remove(0);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void addCard(Card card, int index) {
        cards.add(index, card);
    }

    public void clear() {
        cards.clear();
    }
}
