package org;

import org.exceptions.GameIsOverException;

import java.util.LinkedList;

public class Game {
  static final int MAX_PLAYERS = 5;
  LinkedList<Player> players = new LinkedList<>();
  Player  currentPlayer;
  boolean firstRoundDone;
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
    if(isGameOver())
      throw new GameIsOverException("The game has already finished. Start a new Game to roll again");
    if(!gameStarted)
      throw new UnsupportedOperationException("The game hasn't started yet");
    if (currentPlayer.isLastFrameFinished() && firstRoundDone) {
      int currentIndex = players.indexOf(currentPlayer);
      currentPlayer = currentIndex + 1 >= players.size() ? players.get(0) : players.get(currentIndex + 1);
    }
    currentPlayer.roll(knockedDownPins);
    firstRoundDone = true;
  }

  public boolean isGameOver(){
    for (Player player : players) {
      if (!player.isGameFinished())
        return false;
    }
    return true;
  }

  public LinkedList<Player> getPlayers() {
    return players;
  }

/*  public Map<Player, Integer> getScore() {
    Map<Player, Integer> playerScores = new HashMap<>();
    for (Player player : players) {
      playerScores.put(player, player.getCurrentScore());
    }
    return  playerScores;
  }*/

  private boolean hasValidAmountOfPlayers(){
    return players.size() > 0 && players.size() <= MAX_PLAYERS;
  }
}
