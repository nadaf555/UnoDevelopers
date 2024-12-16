package ca.sheridancollege.uno.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

class DeckTest {

    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck(); // Creates a deck and shuffles it
    }

    @Test
    void testShuffle() {
        Deck deck2 = new Deck();
        assertNotEquals(deck.drawCard(), deck2.drawCard(), "Shuffled decks should not be identical.");
    }

    @Test
    void testDrawCard() {
        int initialSize = 108;
        Set<Card> drawnCards = new HashSet<>();

        for (int i = 0; i < initialSize; i++) {
            Card card = deck.drawCard();
            assertNotNull(card, "Card should not be null.");
            assertFalse(drawnCards.contains(card), "Card should be unique.");
            drawnCards.add(card);
        }

        assertNull(deck.drawCard(), "Drawing a card from an empty deck should return null.");
    }

    @Test
    void testAddCard() {
        Card card = new RegularCard(Card.Color.RED, 5);
        deck.addCard(card);
        
        boolean found = false;
        for (int i = 0; i < 109; i++) { // Drawing up to 109 cards to ensure the added card is included
            if (deck.drawCard() == card) {
                found = true;
                break;
            }
        }
        assertTrue(found, "The added card should be in the deck.");
    }
}
