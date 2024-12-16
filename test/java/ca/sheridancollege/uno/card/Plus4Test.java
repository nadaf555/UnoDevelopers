package ca.sheridancollege.uno.card;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Plus4Test {

    private Plus4 plus4Card;

    @BeforeEach
    void setUp() {
        plus4Card = new Plus4();
    }

    @Test
    void testIsValid() {
        RegularCard redRegularCard = new RegularCard(Card.Color.RED, 5);
        RegularCard blueRegularCard = new RegularCard(Card.Color.BLUE, 7);
        Plus2 redPlus2 = new Plus2(Card.Color.RED);

        assertTrue(plus4Card.isValid(redRegularCard, Card.Color.RED, 8),
                "A Plus4 card should be valid regardless of the top card's color.");
        assertTrue(plus4Card.isValid(blueRegularCard, Card.Color.YELLOW, 4),
                "A Plus4 card should be valid regardless of the top card's color.");
        assertTrue(plus4Card.isValid(redPlus2, Card.Color.GREEN, 0),
                "A Plus4 card should be valid regardless of the top card's color.");
    }

    @Test
    void testToString() {
        assertEquals("Wild Draw Four", plus4Card.toString(),
                "The toString method should return 'Wild Draw Four' for a Plus4 card.");
    }

    @Test
    void testInheritance() {
        assertTrue(plus4Card instanceof Wild, "Plus4 should be an instance of Wild.");
        assertEquals(Card.Color.WILD, plus4Card.getColor(), "Plus4 card should have the color WILD.");
    }
}
