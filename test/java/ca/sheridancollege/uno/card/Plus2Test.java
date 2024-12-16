package ca.sheridancollege.uno.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Plus2Test {

    private Plus2 redPlus2;
    private Plus2 bluePlus2;
    private RegularCard redRegularCard;
    private RegularCard blueRegularCard;

    @BeforeEach
    void setUp() {
        redPlus2 = new Plus2(Card.Color.RED);
        bluePlus2 = new Plus2(Card.Color.BLUE);
        redRegularCard = new RegularCard(Card.Color.RED, 5);
        blueRegularCard = new RegularCard(Card.Color.BLUE, 7);
    }

    @Test
    void testIsValid_SameColor() {
        assertTrue(redPlus2.isValid(redRegularCard, Card.Color.RED, 4), "A Plus2 card should be valid if the top color matches.");
    }

    @Test
    void testIsValid_SameType() {
        assertTrue(redPlus2.isValid(bluePlus2, Card.Color.YELLOW, 8), "A Plus2 card should be valid if the top card is also a Plus2.");
    }

    @Test
    void testIsValid_Invalid() {
        assertFalse(redPlus2.isValid(blueRegularCard, Card.Color.YELLOW, 0), "A Plus2 card should be invalid if the top color doesn't match and the top card is not a Plus2.");
    }

    @Test
    void testToString() {
        assertEquals("RED Draw Two", redPlus2.toString(), "The toString method should return the color followed by 'Draw Two'.");
        assertEquals("BLUE Draw Two", bluePlus2.toString(), "The toString method should return the color followed by 'Draw Two'.");
    }
}
