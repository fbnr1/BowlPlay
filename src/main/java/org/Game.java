package org;

import org.exceptions.GameIsOverException;

import java.util.LinkedList;

public class Game {
  static final int MAX_PLAYERS = 5;
  LinkedList<Player> players = new LinkedList<>();
  Player             currentPlayer;
  boolean firstRound;
  boolean gameStarted = false;

  public void start() {
    if (hasValidAmountOfPlayers()) {
      gameStarted = true;
      currentPlayer = players.get(0);
    }
    else
      throw new UnsupportedOperationException("Can't start game with less than 1 ore more than " + MAX_PLAYERS + " players");
  }

  public void addPlayer(String name) {
    addPlayer(new Player(name));
  }

  public void addPlayer(Player player) {
    if (!gameStarted)
      players.add(player);
    else
      throw new UnsupportedOperationException("Can't add player after game has started");
  }

  public void roll(int knockedDownPins) {
    if(!isGameOver()) {
      if (currentPlayer.isLastFrameFinished() && firstRound) {
        int currentIndex = players.indexOf(currentPlayer);
        currentPlayer = currentIndex + 1 >= players.size() ? players.get(0) : players.get(currentIndex + 1);
      }
      currentPlayer.roll(knockedDownPins);
      firstRound = true;
    } else
      throw new GameIsOverException();
  }

  public boolean isGameOver(){
    boolean gameOver = false;

    for (Player player : players) {
      gameOver = gameOver || player.isGameFinished();
    }

    return  gameOver;
  }

  public LinkedList<Player> getPlayers() {
    return players;
  }

  private boolean hasValidAmountOfPlayers(){
    return players.size() > 0 && players.size() <= MAX_PLAYERS;
  }
}
