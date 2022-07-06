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
}

