package ca.sheridancollege.uno.card;

import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;

public abstract class Card {
    public enum Color {
        RED, YELLOW, GREEN, BLUE, WILD
    }

    private Color color;

    public Card(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean isValid(Card topCard, Color topColor, int drawCards);

    @Override
    public String toString() {
        return color.toString();
    }

    public abstract void playCard(Game game, Pool pool, Color color);

}
