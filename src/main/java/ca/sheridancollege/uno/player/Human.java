package ca.sheridancollege.uno.player;

import java.util.Scanner;

import ca.sheridancollege.uno.card.Card;
import ca.sheridancollege.uno.card.Card.Color;
import ca.sheridancollege.uno.game.Game;
import ca.sheridancollege.uno.game.Pool;
import ca.sheridancollege.uno.game.Stack;

public class Human extends Player {

  public Human(Game game) {
    super(game);
  }

  private boolean playing = false;

  @Override
  public void playTurn(Pool pool, Stack stack, int drawCards) {
    playing = true;
    Scanner scanner = new Scanner(System.in);
    while (playing) {
      System.out.println("Your hand: " + getHand());
      System.out.println("Top card: " + pool.getTopCard());
      System.out.print("Choose a card to play (0 to draw): ");

      int choice = scanner.nextInt();
      if (choice == 0) {
        if (drawCards == 0) {
          drawCard(stack);
          System.out.println("You drew a card.");
        } else {
          for (int i=0; i<drawCards; i++){
            drawCard(stack);
          }
          System.out.println("Player drew " + drawCards + "cards");
          game.resetDrawCards();
        }
        playing = false;
      } else {
        Card chosenCard = hand.get(choice - 1);
        if (chosenCard.isValid(pool.getTopCard(), pool.getTopColor(), drawCards)) {
          hand.remove(chosenCard);
          Color color;
          if (chosenCard.getColor() == Color.WILD) {
            color = selectWildColor();
            System.out.println("You played: " + chosenCard + ". And chose " + color.toString());
          } else {
            color = chosenCard.getColor();
            System.out.println("You played: " + chosenCard);
          }
          chosenCard.playCard(game, pool, color);
          playing = false;
        } else {
          System.out.println("Invalid card. Try again.");
        }
      }
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
