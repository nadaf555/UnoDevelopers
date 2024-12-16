package ca.sheridancollege.uno.card;

import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;

public class RegularCard extends Card {
    private int number;

    public RegularCard(Color color, int number) {
        super(color);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean isValid(Card topCard, Color topColor, int drawCards) {
        if (drawCards == 0) {
            if (topCard instanceof RegularCard) {
                RegularCard top = (RegularCard) topCard;
                return this.getColor() == top.getColor() || this.number == top.getNumber();
            } else {
                return this.getColor() == topColor;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + number;
    }

    @Override
    public void playCard(Game game, Pool pool, Color color) {
        pool.addCard(this);
    }

}
