package org;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public final class BowlingGameManualTest {
  Scanner scanner;
  Game game;

  @BeforeEach
  void setUp() {
    game = new Game();
    scanner = new Scanner(System.in);
  }

  @Test
  @Disabled("manual test")
  void playGame() {
    addPlayers();
  }

  void addPlayers() {
    String input;
    System.out.print("Please enter the name of player 1: ");
    game.addPlayer(scanner.next());
    do {
      System.out.print("Please enter the name of player " + (game.getPlayers().size() + 1) + " or enter S to start the game: ");
      input = scanner.next();
      if (!input.equalsIgnoreCase("S")) {
        game.addPlayer(input);
      }
    } while (!input.equalsIgnoreCase("S"));

    for (Player player : game.getPlayers()) {
      System.out.println(player.getName());
    }

    System.out.print("Enter 'score' to see the current score" + "\n" + "or enter how many pins have been knocked down:");
    //input = scanner.next()
    game.roll(scanner.nextInt());
    game.isOver();
// todo FabianR : finish
  }
}

