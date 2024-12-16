package ca.sheridancollege.uno.player;

import java.util.ArrayList;
import java.util.List;

import ca.sheridancollege.uno.card.Card;
import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;
import ca.sheridancollege.uno.game.Stack;

public abstract class Player {
    protected List<Card> hand;
    protected Game game;

    public Player(Game game) {
        this.game = game;
        hand = new ArrayList<>();
    }

    public void drawCard(Stack stack) {
        Card card = stack.drawCard();
        if (card != null) {
            hand.add(card);
        }
    }

    public abstract void playTurn(Pool pool, Stack stack, int drawCards);

    public String getHand() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= hand.size(); i++) {
            result.append(" ").append(i).append(". ").append(hand.get(i - 1)).append(";");
        }
        return result.toString();
    }

    public List<Card> getHandList() {
        return hand; // Return a copy to avoid external modification
    }

    // Optionally add methods for hand management, e.g., removeCard(Card card)
}
