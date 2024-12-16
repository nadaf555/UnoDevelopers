package ca.sheridancollege.uno.card;

import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;

public class Plus2 extends Card {
    
    public Plus2(Color color) {
        super(color);
    }

    @Override
    public boolean isValid(Card topCard, Color topColor, int drawCards) {
        return this.getColor() == topColor || topCard instanceof Plus2 || topCard instanceof Plus4;
    }

    @Override
    public String toString() {
        return super.toString() + " Draw Two";
    }

    public void playCard(Game game, Pool pool, Color color) {
        game.addDrawCards(2);
        pool.addCard(this);
    }
}
