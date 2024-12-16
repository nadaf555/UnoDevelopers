package ca.sheridancollege.uno.card;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegularCardTest {

    private RegularCard redFive;
    private RegularCard blueFive;
    private RegularCard redSeven;

    @BeforeEach
    void setUp() {
        redFive = new RegularCard(Card.Color.RED, 5);
        blueFive = new RegularCard(Card.Color.BLUE, 5);
        redSeven = new RegularCard(Card.Color.RED, 7);
    }

    @Test
    void testGetNumber() {
        assertEquals(5, redFive.getNumber(), "The number should be 5 for the redFive card.");
        assertEquals(7, redSeven.getNumber(), "The number should be 7 for the redSeven card.");
    }

    @Test
    void testIsValid_SameColor() {
        assertTrue(redFive.isValid(redSeven, Card.Color.RED, 0),
                "A RegularCard should be valid if the top card has the same color.");
    }

    @Test
    void testIsValid_SameNumber() {
        assertTrue(redFive.isValid(blueFive, Card.Color.GREEN, 0),
                "A RegularCard should be valid if the top card has the same number.");
    }

    @Test
    void testIsValid_DifferentColorAndNumber() {
        assertFalse(redSeven.isValid(blueFive, Card.Color.YELLOW, 0),
                "A RegularCard should be invalid if the top card has a different color and number.");
    }

    @Test
    void testIsValid_WithTopColor() {
        assertTrue(redFive.isValid(new Wild(), Card.Color.RED, 0),
                "A RegularCard should be valid if it matches the top color set by a Wild card.");
        assertFalse(redFive.isValid(new Wild(), Card.Color.BLUE, 0),
                "A RegularCard should be invalid if it does not match the top color set by a Wild card.");
    }

    @Test
    void testToString() {
        assertEquals("RED 5", redFive.toString(), "The toString method should return 'RED 5' for the redFive card.");
        assertEquals("BLUE 5", blueFive.toString(),
                "The toString method should return 'BLUE 5' for the blueFive card.");
        assertEquals("RED 7", redSeven.toString(), "The toString method should return 'RED 7' for the redSeven card.");
    }
}
