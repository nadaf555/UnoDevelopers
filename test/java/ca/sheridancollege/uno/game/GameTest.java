package ca.sheridancollege.uno.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.sheridancollege.uno.player.AI;
import ca.sheridancollege.uno.player.Human;
import ca.sheridancollege.uno.player.Player;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = Game.getInstance();
    }

    @Test
    void testSingletonInstance() {
        Game anotherGameInstance = Game.getInstance();
        assertSame(game, anotherGameInstance, "The Game instance should be a singleton.");
    }

    @Test
    void testPlayerInitialization() {
        assertEquals(4, game.getPlayers().size(), "There should be 4 players initialized.");
        assertTrue(game.getPlayers().get(0) instanceof Human, "The first player should be a Human.");
        assertTrue(game.getPlayers().get(1) instanceof AI, "The second player should be an AI.");
        assertTrue(game.getPlayers().get(2) instanceof AI, "The third player should be an AI.");
        assertTrue(game.getPlayers().get(3) instanceof AI, "The fourth player should be an AI.");
    }

    @Test
    void testStartGame() {
        // Assuming Stack and Pool classes have methods to get the number of cards
        assertEquals(7, game.getPlayers().get(0).getHandList().size(), "Each player should be dealt 7 cards.");
        assertNotNull(game.getPool().getTopCard(), "The pool should contain at least one card.");
    }

    @Test
    void testReverseDirection() {
        game.setDirection(true);
        assertTrue(game.getDirection(), "Initially, the direction should be clockwise.");
        game.reverseDirection();
        assertFalse(game.getDirection(), "After reversing, the direction should be counter-clockwise.");
        game.reverseDirection();
        assertTrue(game.getDirection(), "Reversing again should return to clockwise.");
    }

    @Test
    void testNextPlayer() {
        Player currentPlayer = game.getPlayers().get(0);
        Player nextPlayer = game.getPlayers().get(1);
        game.nextPlayer();
        assertEquals(nextPlayer, game.getPlayers().get(game.getCurrentPlayerIndex()),
                "The next player should be the second player.");
        game.reverseDirection();
        game.nextPlayer();
        assertEquals(currentPlayer, game.getPlayers().get(game.getCurrentPlayerIndex()),
                "The direction reversal should affect the next player.");
    }

    @Test
    void testIsGameOver() {
        // Mocking the scenario where a player has no cards
        game.getPlayers().get(0).getHandList().clear();
        assertTrue(game.isGameOver(), "The game should be over when a player has no cards.");
    }

    @Test
    void testSkipNextPlayer() {
        Player currentPlayer = game.getPlayers().get(0);
        Player playerAfterNext = game.getPlayers().get(2);

        game.nextPlayer();
        game.skipNextPlayer();

        assertEquals(playerAfterNext, game.getPlayers().get(game.getCurrentPlayerIndex()), 
                "The player after the skipped one should now be the current player.");
    }

    @Test
    void testForceDraw() {
        // Test drawing 2 cards
        Player targetPlayer = game.getPlayers().get(1);
        int initialHandSize = targetPlayer.getHandList().size();
        
        game.addDrawCards(2);
        game.forceDraw(targetPlayer);

        assertEquals(initialHandSize + 2, targetPlayer.getHandList().size(), 
                "The target player should have drawn 2 additional cards.");

        // Test drawing 4 cards
        targetPlayer = game.getPlayers().get(2);
        initialHandSize = targetPlayer.getHandList().size();

        game.addDrawCards(4);
        game.forceDraw(targetPlayer);

        assertEquals(initialHandSize + 4, targetPlayer.getHandList().size(), 
                "The target player should have drawn 4 additional cards.");
    }
}
