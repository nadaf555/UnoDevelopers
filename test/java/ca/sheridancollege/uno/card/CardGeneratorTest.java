package ca.sheridancollege.uno.card;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CardGeneratorTest {

    @Test
    void testGenerateDeck() {
        List<Card> deck = CardGenerator.generateDeck();

        // Test the total number of cards in the deck
        assertEquals(108, deck.size(), "Deck should contain 108 cards");

        // Test the number of each type of card
        long numberCards = deck.stream().filter(card -> card instanceof RegularCard).count();
        assertEquals(76, numberCards, "There should be 76 number cards (1 zero, 2 of each 1-9 for each color)");

        long skipCards = deck.stream().filter(card -> card instanceof Skip).count();
        assertEquals(8, skipCards, "There should be 8 Skip cards (2 for each color)");

        long reverseCards = deck.stream().filter(card -> card instanceof Reverse).count();
        assertEquals(8, reverseCards, "There should be 8 Reverse cards (2 for each color)");

        long plus2Cards = deck.stream().filter(card -> card instanceof Plus2).count();
        assertEquals(8, plus2Cards, "There should be 8 Draw Two cards (2 for each color)");

        long wildCards = deck.stream().filter(card -> card instanceof Wild).filter(card -> (!(card instanceof Plus4))).count();
        assertEquals(4, wildCards, "There should be 4 Wild cards");

        long plus4Cards = deck.stream().filter(card -> card instanceof Plus4).count();
        assertEquals(4, plus4Cards, "There should be 4 Wild Draw Four cards");

        // Additional tests can check specific color counts and card values if needed
    }
}
