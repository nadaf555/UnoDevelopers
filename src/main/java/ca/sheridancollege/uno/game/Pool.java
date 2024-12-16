package ca.sheridancollege.uno.game;

import java.util.ArrayList;
import java.util.List;

import ca.sheridancollege.uno.card.Card;
import ca.sheridancollege.uno.card.Card.Color;

public class Pool {
    private List<Card> playedCards;
    private Card topCard;
    private Card.Color topColor;

    public Pool() {
        playedCards = new ArrayList<>();
    }

    public void addCard(Card card) {
        playedCards.add(card);
        topCard = card;
        topColor = card.getColor();

    }

    public void addCard(Card card, Color color) {
        playedCards.add(card);
        topCard = card;
        topColor = color;
    }

    public Card getTopCard() {
        return topCard;
    }

    public Color getTopColor() {
        return topColor;
    }
}
