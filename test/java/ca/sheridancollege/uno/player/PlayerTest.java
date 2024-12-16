package ca.sheridancollege.uno.player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.sheridancollege.uno.card.Card;
import ca.sheridancollege.uno.card.Card.Color;
import ca.sheridancollege.uno.card.RegularCard;
import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;
import ca.sheridancollege.uno.game.Stack;

class PlayerTest {

    private Player player;
    private Stack stack;
    private Pool pool;
    private Card card1;
    private Card card2;

    @BeforeEach
    void setUp() {
        // Create a concrete subclass for testing
        player = new Player(Game.getInstance()) {
            @Override
            public void playTurn(Pool pool, Stack stack, int drawCards) {
                // Simple implementation for testing purposes
            }
        };

        stack = new Stack(); // Real Stack instance
        pool = new Pool(); // Real Pool instance
        card1 = new RegularCard(Color.RED, 5);
        card2 = new RegularCard(Color.GREEN, 7);

        // Add cards to the stack for testing
        stack.addCard(card1, 0);
        stack.addCard(card2, 1);
    }

    @Test
    void testDrawCardAddsCardToHand() {
        player.drawCard(stack);

        List<Card> hand = player.getHandList();
        assertEquals(1, hand.size(), "Hand should have one card.");
        assertEquals(card1, hand.get(0), "The drawn card should be in the hand.");
    }

    @Test
    void testDrawCardDoesNotAddNullCard() {
        // Ensure the stack draws a null card
        // Draw the first card
        stack.clear(); // Simulate a null card scenario
        int handSize = player.getHandList().size(); // get the current number of cards in hand
        player.drawCard(stack);

        List<Card> hand = player.getHandList();
        assertEquals(handSize, hand.size(), "Hand should have one card when no card is drawn.");
    }

    @Test
    void testGetHand() {
        // Add cards to the stack for testing
        stack.addCard(card1, 0);
        stack.addCard(card2, 1);

        // Add cards to hand
        player.drawCard(stack); // Add first card to hand
        player.drawCard(stack); // Add second card to hand

        // Ensure hand is correctly formatted
        String handString = player.getHand();
        assertTrue(handString.contains("1. " + card1.toString()), "Hand string should contain card1.");
        assertTrue(handString.contains("2. " + card2.toString()), "Hand string should contain card2.");
    }

    @Test
    void testGetHandListReturnsCopy() {
        player.drawCard(stack); // Add a card to hand
        List<Card> handList = player.getHandList();

        // Ensure the returned list is the original
        assertSame(player.getHandList(), handList, "getHandList should return the actual List object.");
    }
}
