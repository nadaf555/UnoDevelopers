package ca.sheridancollege.uno.card;

import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;

public class Plus4 extends Wild {
    @Override
    public String toString() {
        return "Wild Draw Four";
    }

    @Override
    public boolean isValid(Card topCard, Color topColor, int drawCards) {
        return true;
    }

    public void playCard(Game game, Pool pool, Color color) {
        game.addDrawCards(4);
        super.playCard(game, pool, color);
    }
}
