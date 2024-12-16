package ca.sheridancollege.uno.player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.sheridancollege.uno.card.Card;
import ca.sheridancollege.uno.card.Card.Color;
import ca.sheridancollege.uno.card.RegularCard;
import ca.sheridancollege.uno.card.Wild;
import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;
import ca.sheridancollege.uno.game.Stack;

class AITest {

    private AI ai;
    private Stack stack;
    private Pool pool;
    private Card redCard;
    private Card greenCard;
    private Card wildCard;
    private Card newCard;

    @BeforeEach
    void setUp() {
        ai = new AI(Game.getInstance());
        stack = new Stack(); // Real Stack instance
        pool = new Pool(); // Real Pool instance

        redCard = new RegularCard(Color.RED, 5);
        greenCard = new RegularCard(Color.GREEN, 7);
        wildCard = new Wild();
        newCard = new RegularCard(Color.BLUE, 1);

        // Add cards to stack and pool
        stack.addCard(newCard);
        pool.addCard(redCard);

        // Add cards to AI's hand
        ai.hand.add(redCard); // This should be valid
        ai.hand.add(greenCard); // This should be valid
        ai.hand.add(wildCard); // Wild card to test color selection
    }

    @Test
    void testPlayTurnWithValidCard() {
        // Test when AI has a valid card to play
        ai.playTurn(pool, stack, 0);

        List<Card> hand = ai.getHandList();
        assertEquals(2, hand.size(), "AI's hand should have two cards after playing one.");
        assertFalse(hand.contains(redCard), "AI should have played the red card.");
    }

    @Test
    void testPlayTurnWithWildCard() {
        // Change the pool's top card to test Wild card behavior
        pool.addCard(new RegularCard(Color.BLUE, 8));

        ai.playTurn(pool, stack, 0);

        List<Card> hand = ai.getHandList();
        assertEquals(2, hand.size(), "AI's hand should have two cards after playing the Wild card.");
        assertFalse(hand.contains(wildCard), "AI should have played the Wild card.");

        // Check that the color was selected and added to the pool correctly
        // This requires checking if the correct color was selected
    }

    @Test
    void testPlayTurnDrawsCardWhenNoValidCard() {
        // Empty AI's hand and add a card to the stack
        ai.getHandList().clear();
        stack.addCard(redCard, 0);

        ai.playTurn(pool, stack, 0);

        List<Card> hand = ai.getHandList();
        assertEquals(1, hand.size(), "AI's hand should have one card after drawing.");
        assertTrue(hand.contains(redCard), "AI should have drawn the red card.");
    }
}
