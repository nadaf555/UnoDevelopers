// Sajid

package ca.sheridancollege.uno;

import ca.sheridancollege.uno.game.Game;

public class UnoGame {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.play();
    }
}
