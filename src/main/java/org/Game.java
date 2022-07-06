package org;

import java.util.LinkedList;

public class Game {
  static final int MAX_PLAYERS = 5;
  LinkedList<Player> players = new LinkedList<>();
  Player             currentPlayer;
  boolean firstRound;
  
  public void addPlayer(String name) {
    addPlayer(new Player(name));
  }

  public void addPlayer(Player player) {
    players.add(player);
  }

  boolean hasValidAmountOfPlayers(){
    return players.size() > 0 && players.size() <= MAX_PLAYERS;
  }

  public void roll(int knockedDownPins) {
    if (currentPlayer.isLastFrameFinished() && firstRound) {
      int currentIndex = players.indexOf(currentPlayer);
      currentPlayer = currentIndex + 1 >= players.size() ? players.get(0) : players.get(currentIndex + 1);
    }
    currentPlayer.roll(knockedDownPins);
    System.out.println(currentPlayer.getName() + " (" + currentPlayer.getCurrentRollNumber() + "): " + knockedDownPins);
    firstRound = true;
  }

  boolean isGameOver(){
    return false;
  }

  public void start() {
    try {
      currentPlayer = players.get(0);
    } catch (IndexOutOfBoundsException e) {
      throw new UnsupportedOperationException();
    }

  }
}
