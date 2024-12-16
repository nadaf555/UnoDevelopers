package ca.sheridancollege.uno.game;

import ca.sheridancollege.uno.card.Card;
import ca.sheridancollege.uno.card.Deck;

public class Stack {
    private Deck deck;

    public Stack() {
        deck = new Deck();
    }

    public Card drawCard() {
        return deck.drawCard();
    }

    public void addCard(Card card) {
        deck.addCard(card);
    }

    public void addCard(Card card, int index) {
        deck.addCard(card, index);
    }

    public void clear() {
        deck.clear();
    }
}
