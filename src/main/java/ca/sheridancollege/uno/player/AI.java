package ca.sheridancollege.uno.player;

import ca.sheridancollege.uno.card.Card;
import ca.sheridancollege.uno.card.Card.Color;
import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;
import ca.sheridancollege.uno.game.Stack;

public class AI extends Player {

  public AI(Game game) {
    super(game);
  }

  @Override
  public void playTurn(Pool pool, Stack stack, int drawCards) {
    // Simple AI logic: play the first valid card
    for (Card card : hand) {
      if (card.isValid(pool.getTopCard(), pool.getTopColor(), drawCards)) {
        hand.remove(card);
        Color color;
        if (card.getColor() == Color.WILD) {
          color = selectWildColor();
          System.out.println("AI played: " + card + ". And chose " + color.toString());
        } else {
          color = card.getColor();
          System.out.println("AI played: " + card);
        }
        card.playCard(game, pool, color);
        return;
      }
    }
    if (drawCards > 0) {
      for (int i = 0; i < drawCards; i++) {
        drawCard(stack);
      }
      System.out.println("AI drew " + drawCards + "cards");
      game.resetDrawCards();
    } else {
      drawCard(stack);
      System.out.println("AI drew a card");
    }
  }

  private Color selectWildColor() {
    Color color = null;
    while (color == null) {
      for (Card card : hand) {
        if (card.getColor() != Color.WILD) {
          color = card.getColor();
        }
      }
    }
    return color;
  }
}
