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
    scanner = new Scanner(System.in);
  }

  @Test
  @Disabled("manual test")
  void play() {
    game = new Game();
    addPlayers();
    playGame();
  }

  private void addPlayers() {
    String input;
    System.out.print("Please enter the name of player 1: ");
    game.addPlayer(scanner.next());
    do {
      System.out.print("Please enter the name of player " + (game.getPlayers().size() + 1) + " or enter S to start the game: ");
      input = scanner.next();
      if (!input.equalsIgnoreCase("S")) {
        game.addPlayer(input);
      } else {
        game.start();
      }
    } while (!input.equalsIgnoreCase("S"));
  }

  private void playGame() {
    String input;
    gameLoop:
    while (!game.isOver()) {
      System.out.print("Enter 'help' to see a list of available commands" + "\n" + "or enter how many pins have been knocked down (0 - 10): ");
      input = scanner.next();
      if (input.equalsIgnoreCase("help")) {
        String commands = "\t'score': display current score\n" + "\t'continue': continue playing the game\n" + "\t'exit': exit the game";
        System.out.println("Here is a list of all available commands:\n" + commands);
        String commandInput = scanner.next();
        switch (commandInput) {
          case "score":
            System.out.println(createScoreString());
            break;
          case "continue":
            break;
          case "exit":
            break gameLoop;
          default:
        }
      }
      else {
        try {
          game.roll(Integer.parseInt(input));
        }
        catch (IllegalArgumentException e) {
          System.out.println("You can't knock down more than 10 pins in one frame (except for the last frame)");
        }
      }
    }
    System.out.println("Final score:\n" + createScoreString());
    do {
        System.out.println("Play again? (y/n): ");
        input = scanner.next();
        if (input.equalsIgnoreCase("y"))
          play();
        else if (input.equalsIgnoreCase("n"))
          return;
      }
    while (!input.equalsIgnoreCase("y"));
  }

  private String createScoreString() {
    StringBuilder scoreString = new StringBuilder();
    for (Player player : game.getPlayers()) {
      scoreString.append(player.getName());
      for (int i = 1; i <= player.getCurrentFrameIndex(); i++) {
        scoreString.append("\t[").append(i).append("]: ").append(player.getScoreUntilFrame(i));
      }
      scoreString.append("\t[Total]: ").append(player.getCurrentScore()).append("\n");
    }
    return scoreString.toString();
  }
}

