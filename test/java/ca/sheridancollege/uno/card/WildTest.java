package ca.sheridancollege.uno.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WildTest {

    private Wild wildCard;

    @BeforeEach
    void setUp() {
        wildCard = new Wild();
    }

    @Test
    void testConstructor() {
        assertEquals(Card.Color.WILD, wildCard.getColor(), "The color of a Wild card should be WILD.");
    }

    @Test
    void testIsValid() {
        RegularCard redRegularCard = new RegularCard(Card.Color.RED, 5);
        RegularCard blueRegularCard = new RegularCard(Card.Color.BLUE, 7);
        Plus2 redPlus2 = new Plus2(Card.Color.RED);

        assertTrue(wildCard.isValid(redRegularCard, Card.Color.RED, 0), "A Wild card should be valid regardless of the top card's color.");
        assertTrue(wildCard.isValid(blueRegularCard, Card.Color.YELLOW, 0), "A Wild card should be valid regardless of the top card's color.");
        assertTrue(wildCard.isValid(redPlus2, Card.Color.GREEN, 0), "A Wild card should be valid regardless of the top card's color.");
    }

    @Test
    void testToString() {
        assertEquals("Wild", wildCard.toString(), "The toString method should return 'Wild' for a Wild card.");
    }
}
