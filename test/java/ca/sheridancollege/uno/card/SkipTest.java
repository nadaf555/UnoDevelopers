package ca.sheridancollege.uno.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SkipTest {

    private Skip redSkip;
    private Skip blueSkip;
    private RegularCard redRegularCard;
    private RegularCard blueRegularCard;

    @BeforeEach
    void setUp() {
        redSkip = new Skip(Card.Color.RED);
        blueSkip = new Skip(Card.Color.BLUE);
        redRegularCard = new RegularCard(Card.Color.RED, 5);
        blueRegularCard = new RegularCard(Card.Color.BLUE, 7);
    }

    @Test
    void testIsValid_SameColor() {
        assertTrue(redSkip.isValid(redRegularCard, Card.Color.RED, 0), "A Skip card should be valid if the top card has the same color.");
    }

    @Test
    void testIsValid_SameType() {
        assertTrue(redSkip.isValid(blueSkip, Card.Color.YELLOW, 0), "A Skip card should be valid if the top card is also a Skip, regardless of color.");
    }

    @Test
    void testIsValid_Invalid() {
        assertFalse(redSkip.isValid(blueRegularCard, Card.Color.YELLOW, 0), "A Skip card should be invalid if the top card's color doesn't match and the top card is not a Skip.");
    }

    @Test
    void testToString() {
        assertEquals("RED Skip", redSkip.toString(), "The toString method should return 'RED Skip' for a red Skip card.");
        assertEquals("BLUE Skip", blueSkip.toString(), "The toString method should return 'BLUE Skip' for a blue Skip card.");
    }

    @Test
    void testConstructor() {
        assertEquals(Card.Color.RED, redSkip.getColor(), "The color of the redSkip card should be RED.");
        assertEquals(Card.Color.BLUE, blueSkip.getColor(), "The color of the blueSkip card should be BLUE.");
    }
}
