package org;


import org.exceptions.GameIsOverException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class GameTest {
  Game game;

  @BeforeEach
  void createGame() {
    game = new Game(6);
  }

  @Test
  void getPlayers_twoPlayersAreAdded_PlayersAreReturnedCorrectly() {
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
      for (int i = 0; i < 7; i++) {
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
  void roll_onePlayerStrikePlusTwoRollsInLastRound_NoError() {
    game.addPlayer("Tom");
    game.start();

    for (int i = 1; i <= 18; i++) {
      game.roll(5);
    }
    game.roll(10);
    assertEquals(150, game.getPlayers().get(0).getCurrentScore());
    game.roll(8);
    assertEquals(158, game.getPlayers().get(0).getCurrentScore());
    game.roll(2);
    assertEquals(160, game.getPlayers().get(0).getCurrentScore());
  }

  @Test
  void roll_onePlayerSparePlusOneRollInLastRound_NoError() {
    game.addPlayer("Tom");
    game.start();

    for (int i = 1; i <= 18; i++) {
      game.roll(5);
    }
    game.roll(5);
    game.roll(5);
    game.roll(10);
    assertEquals(155, game.getPlayers().get(0).getCurrentScore());
  }

  @Test
  void roll_fivePlayersNormalRolls_NoError() {
    addFivePlayersToGame();
    game.start();

    for (int i = 1; i <= 10; i++) {
      for (Player ignored : game.getPlayers()) {
        game.roll(4);
        game.roll(4);
      }
    }
    for (Player player : game.getPlayers()) {
      assertEquals(80, player.getCurrentScore());
    }
  }

  @Test
  void roll_fivePlayersStrikeInLastRound_NoError() {
    addFivePlayersToGame();
    game.start();

    for (int i = 1; i <= 9; i++) {
      for (Player ignored : game.getPlayers()) {
        game.roll(4);
        game.roll(4);
      }
    }
    for (Player ignored : game.getPlayers()) {
        game.roll(10);
        game.roll(10);
        game.roll(10);
    }

    for (Player player : game.getPlayers()) {
      assertEquals(102, player.getCurrentScore());
    }
  }

  @Test
  void roll_RollAfterGameIsOver_exceptionIsThrown() {
    addFivePlayersToGame();
    game.start();

    for (int i = 1; i <= 10; i++) {
      for (Player ignored : game.getPlayers()) {
        game.roll(4);
        game.roll(4);
      }
    }
    try {
      game.roll(5);
      fail("It shouldn't be allowed to roll after game has finished");
    } catch (GameIsOverException e) {
      e.printStackTrace();
    }
  }

  @Test
  void roll_RollBeforeGameHasStarted_exceptionIsThrown() {
    addFivePlayersToGame();

    try {
      game.roll(5);
      fail("It shouldn't be allowed to roll before game has finished");
    } catch (UnsupportedOperationException e) {
      e.printStackTrace();
    }
  }

  @Test
  void roll_sixPlayersStrikeInLastRound_NoError() {
    //game = new Game(6);
    addFivePlayersToGame();
    game.addPlayer("John");
    game.start();

    for (int i = 1; i <= 9; i++) {
      for (Player ignored : game.getPlayers()) {
        game.roll(4);
        game.roll(4);
      }
    }
    for (Player ignored : game.getPlayers()) {
        game.roll(10);
        game.roll(10);
        game.roll(10);
    }

    for (Player player : game.getPlayers()) {
      System.out.println(player.getName() + ": " + player.getCurrentScore());
      assertEquals(102, player.getCurrentScore());
    }
  }

  @Test
  void isOver_TenFramesArePlayed_isOnlyTrueAtTheEnd() {
    addFivePlayersToGame();
    game.start();

    for (int i = 1; i <= 9; i++) {
      for (Player ignored : game.getPlayers()) {
        game.roll(4);
        game.roll(4);
        assertFalse(game.isOver());
      }
    }
    game.roll(4);
    game.roll(4);

    game.roll(4);
    game.roll(4);

    game.roll(4);
    game.roll(4);

    game.roll(4);
    game.roll(4);

    game.roll(4);
    assertFalse(game.isOver());

    game.roll(4);
    assertTrue(game.isOver());
  }

  private void addFivePlayersToGame() {
    game.addPlayer("Tom");
    game.addPlayer("Max");
    game.addPlayer("Pascal");
    game.addPlayer("Fabian");
    game.addPlayer("Anna");
  }
}

