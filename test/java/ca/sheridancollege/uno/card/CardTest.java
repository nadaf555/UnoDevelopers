package ca.sheridancollege.uno.card;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.sheridancollege.uno.card.Card.Color;
import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;

class CardTest {

    private Card testCardRed;
    private Card testCardBlue;

    // A simple concrete subclass of Card for testing purposes
    private class TestCard extends Card {
        public TestCard(Color color) {
            super(color);
        }

        public void playCard(Game game, Pool pool, Color color) {
            
        }

        @Override
        public boolean isValid(Card topCard, Color topColor, int drawCards) {
            // For testing purposes, let's assume this method is valid if the color matches
            return this.getColor() == topColor || this.getColor() == topCard.getColor();
        }
    }

    @BeforeEach
    void setUp() {
        testCardRed = new TestCard(Color.RED);
        testCardBlue = new TestCard(Color.BLUE);
    }

    @Test
    void testGetColor() {
        assertEquals(Color.RED, testCardRed.getColor());
        assertEquals(Color.BLUE, testCardBlue.getColor());
    }

    @Test
    void testIsValid() {
        // Test cases where the colors match
        assertTrue(testCardRed.isValid(testCardRed, Color.RED, 0));
        assertTrue(testCardRed.isValid(testCardBlue, Color.RED, 0));
        assertTrue(testCardBlue.isValid(testCardRed, Color.BLUE, 0));

        // Test cases where the colors don't match
        assertFalse(testCardRed.isValid(testCardBlue, Color.GREEN, 0));
        assertFalse(testCardBlue.isValid(testCardRed, Color.YELLOW, 0));
    }

    @Test
    void testToString() {
        assertEquals("RED", testCardRed.toString());
        assertEquals("BLUE", testCardBlue.toString());
    }
}
