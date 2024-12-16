package ca.sheridancollege.uno.card;

import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;

public class Wild extends Card {
    public Wild() {
        super(Color.WILD);
    }

    @Override
    public boolean isValid(Card topCard, Color topColor, int drawCards) {
        if (drawCards == 0) {
            return true; // Wild cards can always be played
        } else {
            return false;
        }
    }

    public void playCard(Game game, Pool pool, Color color) {
        pool.addCard(this, color);
    }

    @Override
    public String toString() {
        return "Wild";
    }
}
