package ca.sheridancollege.uno.card;

import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;

public class Reverse extends Card {

    public Reverse(Color color) {
        super(color);
    }

    @Override
    public boolean isValid(Card topCard, Color topColor, int drawCards) {
        if (drawCards == 0) {
            return this.getColor() == topColor || topCard instanceof Reverse;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Reverse";
    }

    @Override
    public void playCard(Game game, Pool pool, Color color) {
        game.reverseDirection();
        pool.addCard(this);
    }
}
