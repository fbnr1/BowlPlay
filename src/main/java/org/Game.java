package org;

import org.exceptions.GameIsOverException;

import java.util.LinkedList;

public class Game {
  private final int                MAX_PLAYERS;
  private final        LinkedList<Player> players     = new LinkedList<>();
  private              Player             currentPlayer;
  private boolean gameStarted = false;

  public Game(int maxPlayers) {
    this.MAX_PLAYERS = maxPlayers;
  }

  public Game() {
    this(5);
  }

  public void start() {
    if (gameStarted) {
      throw new UnsupportedOperationException("The game has already started");
    }
    if (!hasValidAmountOfPlayers()) {
      throw new UnsupportedOperationException("Can't start game with less than 1 or more than " + MAX_PLAYERS + " players");
    }
    gameStarted = true;
    currentPlayer = players.get(0);
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

  public void roll(int knockedDownPins) throws IndexOutOfBoundsException, IllegalArgumentException {
    if(isOver()) {
      throw new GameIsOverException("The game has already finished. Start a new Game to roll again");
    }
    if(!gameStarted) {
      throw new UnsupportedOperationException("The game hasn't started yet");
    }
    if (currentPlayer.isCurrentFrameFinished()) {
      int currentIndex = players.indexOf(currentPlayer);
      currentPlayer = currentPlayer.equals(players.getLast()) ? players.getFirst() : players.get(currentIndex + 1);
    }
      currentPlayer.roll(knockedDownPins);
  }

  public boolean isOver() {
    for (Player player : players) {
      if (!player.isGameFinished())
        return false;
    }
    return true;
  }

  public LinkedList<Player> getPlayers() {
    return new LinkedList<>(players);
  }

  private boolean hasValidAmountOfPlayers(){
    return players.size() > 0 && players.size() <= MAX_PLAYERS;
  }
}
