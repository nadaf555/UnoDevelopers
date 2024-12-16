package ca.sheridancollege.uno.card;

import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;

public class Skip extends Card {
    public Skip(Color color) {
        super(color);
    }

    @Override
    public boolean isValid(Card topCard, Color topColor, int drawCards) {
        if (drawCards == 0) {
            return this.getColor() == topColor || topCard instanceof Skip;
        } else {
            return false;
        }
    }

    @Override
    public void playCard(Game game, Pool pool, Color color) {
        game.skipNextPlayer();
        pool.addCard(this);
    }

    @Override
    public String toString() {
        return super.toString() + " Skip";
    }
}
