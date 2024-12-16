package ca.sheridancollege.uno.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.sheridancollege.uno.card.Card;
import ca.sheridancollege.uno.card.Card.Color;
import ca.sheridancollege.uno.card.RegularCard;

class StackTest {

    private Stack stack;
    private Card redCard;
    private Card blueCard;

    @BeforeEach
    void setUp() {
        stack = new Stack();
        redCard = new RegularCard(Color.RED, 5);
        blueCard = new RegularCard(Color.BLUE, 3);
    }

    @Test
    void testDrawCard() {
        // Add a card to the stack and then draw it
        stack.addCard(redCard, 0);
        assertEquals(redCard, stack.drawCard(), "The drawn card should match the one added.");
    }

    @Test
    void testAddCard() {
        // Add a card to the stack and ensure it's there
        stack.addCard(blueCard, 0);
        assertEquals(blueCard, stack.drawCard(), "The card added to the stack should be drawable.");
    }

    @Test
    void testDrawCardEmptyStack() {
        // Draw from an empty stack
        stack.clear();
        assertNull(stack.drawCard(), "Drawing from an empty stack should return null.");
    }
}
