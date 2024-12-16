package ca.sheridancollege.uno.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.sheridancollege.uno.card.Card;
import ca.sheridancollege.uno.card.Card.Color;
import ca.sheridancollege.uno.card.RegularCard;

class PoolTest {

    private Pool pool;
    private Card redCard;
    private Card blueCard;

    @BeforeEach
    void setUp() {
        pool = new Pool();
        redCard = new RegularCard(Color.RED, 5);
        blueCard = new RegularCard(Color.BLUE, 3);
    }

    @Test
    void testAddCardWithColor() {
        pool.addCard(redCard, Color.RED);
        assertEquals(redCard, pool.getTopCard(), "The top card should be the one that was added.");
        assertEquals(Color.RED, pool.getTopColor(), "The top color should match the color passed in.");
    }

    @Test
    void testAddCardWithoutColor() {
        pool.addCard(blueCard);
        assertEquals(blueCard, pool.getTopCard(), "The top card should be the one that was added.");
        assertEquals(Color.BLUE, pool.getTopColor(), "The top color should match the color of the added card.");
    }

    @Test
    void testAddMultipleCards() {
        pool.addCard(redCard);
        pool.addCard(blueCard);

        // After adding multiple cards, the top card should be the last one added
        assertEquals(blueCard, pool.getTopCard(), "The top card should be the last card added.");
        assertEquals(Color.BLUE, pool.getTopColor(), "The top color should match the color of the last card added.");
    }
}
