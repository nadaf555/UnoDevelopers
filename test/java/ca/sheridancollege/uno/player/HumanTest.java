package ca.sheridancollege.uno.player;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.sheridancollege.uno.card.Card.Color;
import ca.sheridancollege.uno.card.RegularCard;
import ca.sheridancollege.uno.card.Wild;
import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;
import ca.sheridancollege.uno.game.Stack;

class HumanTest {

    private Human human;
    private Pool pool;
    private Stack stack;

    @BeforeEach
    void setUp() {
        human = new Human(Game.getInstance());
        pool = new Pool();
        stack = new Stack();

        // Adding a red card and a wild card to the player's hand
        human.getHandList().add(new RegularCard(Color.RED, 5));
        human.getHandList().add(new Wild());
    }

    @Test
    void testPlayTurn_DrawCard() {
        // Simulate user input for drawing a card (input 0)
        String simulatedInput = "0\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Store initial hand size
        int initialHandSize = human.getHandList().size();

        // Execute the player's turn
        human.playTurn(pool, stack, 0);

        // Ensure the player drew a card (hand size increased)
        assertEquals(initialHandSize + 1, human.getHandList().size(), "Player should have drawn a card.");
    }

    @Test
    void testPlayTurn_PlayValidCard() {
        // Set the top card in the pool to match one in the player's hand
        pool.addCard(new RegularCard(Color.RED, 3));

        // Simulate user input for playing the first card (input 1)
        String simulatedInput = "1\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Store initial hand size
        int initialHandSize = human.getHandList().size();

        // Execute the player's turn
        human.playTurn(pool, stack, 0);

        // Ensure the player played a card (hand size decreased)
        assertEquals(initialHandSize - 1, human.getHandList().size(), "Player should have played a card.");
        assertEquals(Color.RED, pool.getTopColor(), "The top color should match the played card's color.");
    }

    @Test
    void testPlayTurn_PlayWildCard() {
        // Set the top card in the pool to ensure the wild card can be played
        pool.addCard(new RegularCard(Color.GREEN, 7));

        // Simulate user input for playing the wild card (input 2)
        String simulatedInput = "2\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Execute the player's turn
        human.playTurn(pool, stack, 0);

        // Check if the Wild card was played and color was selected
        assertEquals(Color.RED, pool.getTopColor(), "The selected wild color should be from the player's hand.");
    }
}
