package ca.sheridancollege.uno.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ca.sheridancollege.uno.player.AI;
import ca.sheridancollege.uno.player.Human;
import ca.sheridancollege.uno.player.Player;

public class Game {
    private static Game instance;
    private Stack stack;
    private Pool pool;
    private List<Player> players;
    private int currentPlayerIndex;
    private boolean direction; // true for clockwise, false for counter-clockwise
    private int drawCards = 0;

    private Game() {
        stack = new Stack();
        pool = new Pool();
        players = new ArrayList<>();
        direction = true;
        currentPlayerIndex = 0;

        // Initialize players directly within the Game class
        initializePlayers();
        startGame();
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    protected Pool getPool() {
        return pool;
    }

    private void initializePlayers() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = 0;

        // Prompt the user to select the number of players
        System.out.println("Welcome to UNO!");
        while (numberOfPlayers < 1) {
            System.out.print("Please select the number of players (1 or more): ");
            try {
                numberOfPlayers = scanner.nextInt();
                if (numberOfPlayers < 1) {
                    System.out.println("Invalid number of players. Please enter a number greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // clear the invalid input
            }
        }

        // Add one Human player
        players.add(new Human(this));

        // Add AI players for the remaining spots
        for (int i = 1; i < numberOfPlayers; i++) {
            players.add(new AI(this));
        }
    }

    protected List<Player> getPlayers() {
        return players;
    }

    public void startGame() {
        // Initial card distribution
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(stack);
            }
        }
        pool.addCard(stack.drawCard());
    }

    public void play() {
        while (!isGameOver()) {
            Player currentPlayer = players.get(currentPlayerIndex);
            currentPlayer.playTurn(pool, stack, drawCards);
            nextPlayer();
        }
        System.out.println("Game over!");
    }

    protected void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + (direction ? 1 : -1) + players.size()) % players.size();
    }

    protected int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    protected boolean isGameOver() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    protected boolean getDirection() {
        return direction;
    }

    protected void setDirection(boolean direction) {
        this.direction = direction;
    }

    public void reverseDirection() {
        direction = !direction;
        System.out.println("The direction of play has been reversed.");
    }

    public void skipNextPlayer() {
        nextPlayer();
        System.out.println("The player has been skipped.");
    }

    public void forceDraw(Player player) {
        for (int i = 0; i < drawCards; i++) {
            player.drawCard(stack);
        }
        drawCards = 0;
        System.out.println("Player has drawn " + drawCards + " cards.");
    }

    public void addDrawCards(int count) {
        drawCards += count;
    }

    public void resetDrawCards() {
        drawCards = 0;
    }
}
