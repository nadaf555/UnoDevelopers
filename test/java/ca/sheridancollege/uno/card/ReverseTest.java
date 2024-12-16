package ca.sheridancollege.uno.card;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseTest {

    private Reverse redReverse;
    private Reverse blueReverse;
    private RegularCard redRegularCard;
    private RegularCard blueRegularCard;

    @BeforeEach
    void setUp() {
        redReverse = new Reverse(Card.Color.RED);
        blueReverse = new Reverse(Card.Color.BLUE);
        redRegularCard = new RegularCard(Card.Color.RED, 5);
        blueRegularCard = new RegularCard(Card.Color.BLUE, 7);
    }

    @Test
    void testIsValid_SameColor() {
        assertTrue(redReverse.isValid(redRegularCard, Card.Color.RED, 0),
                "A Reverse card should be valid if the top card has the same color.");
    }

    @Test
    void testIsValid_SameType() {
        assertTrue(redReverse.isValid(blueReverse, Card.Color.YELLOW, 0),
                "A Reverse card should be valid if the top card is also a Reverse, regardless of color.");
    }

    @Test
    void testIsValid_Invalid() {
        assertFalse(redReverse.isValid(blueRegularCard, Card.Color.YELLOW, 0),
                "A Reverse card should be invalid if the top card's color doesn't match and the top card is not a Reverse.");
    }

    @Test
    void testToString() {
        assertEquals("RED Reverse", redReverse.toString(),
                "The toString method should return 'RED Reverse' for a red Reverse card.");
        assertEquals("BLUE Reverse", blueReverse.toString(),
                "The toString method should return 'BLUE Reverse' for a blue Reverse card.");
    }

    @Test
    void testConstructor() {
        assertEquals(Card.Color.RED, redReverse.getColor(), "The color of the redReverse card should be RED.");
        assertEquals(Card.Color.BLUE, blueReverse.getColor(), "The color of the blueReverse card should be BLUE.");
    }
}
