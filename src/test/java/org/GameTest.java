package org;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class GameTest {
  Game game;

  @BeforeEach
  void createGame() {
    game = new Game();
  }

  @Test
  void getPlayers_PlayersAreReturnedCorrectly() {
    Player player1 = new Player("Tom");
    Player player2 = new Player("Max");

    game.addPlayer(player1);
    game.addPlayer(player2);

    LinkedList<Player> players = game.getPlayers();

    assertEquals(player1, players.get(0));
    assertEquals(player2, players.get(1));
  }

  @Test
  void start_noPlayersInGame_exceptionIsThrown() {
    try {
      game.start();
      fail("It shouldn't be allowed to start the game with zero players");
    } catch (UnsupportedOperationException e) {
      e.printStackTrace();
    }
  }

  @Test
  void start_SixPlayersInGame_exceptionIsThrown() {
    try {
      for (int i = 0; i <= 5; i++) {
        game.addPlayer(""+ i);
      }
      game.start();
      fail("It shouldn't be allowed to start the game with more than five players");
    } catch (UnsupportedOperationException e) {
      e.printStackTrace();
    }
  }

  @Test
  void start_FivePlayersInGame_canStartGame() {
    for (int i = 0; i < 5; i++) {
      game.addPlayer(""+ i);
    }
    game.start();
  }

  @Test
  void addPlayer_addPlayerAfterGameHasStarted_exceptionIsThrown() {
    game.addPlayer("Tom");
    game.start();

    try {
      game.addPlayer("Max");
      fail("It shouldn't be possible to add players after the game has started");
    } catch (UnsupportedOperationException e ) {
      e.printStackTrace();
    }
  }

  @Test
  void roll_twoPlayersRollFortyTimesInTotal_NoError() {
    game.addPlayer("Tom");
    //game.addPlayer("Max");
    game.start();

    for (int i = 1; i <= 18; i++) {
      game.roll(5);
    }
    game.roll(10);
    game.roll(9);
    game.roll(1);
    for (Player player : game.getScore().keySet()) {
      System.out.println(player.getName() + ": " + game.getScore().get(player));
    }
    assertEquals(game.getPlayers().get(0).getCurrentScore(), 160);
  }
}

