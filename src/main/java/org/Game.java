package org;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
  int frameNumber = 10;
  static final int MAX_PLAYERS = 5;
  ArrayList<Player> players = new ArrayList<>();
  LinkedList<Player> playersLL = new LinkedList<>();
  Player currentPlayer;
  
  void addPlayer(String name) {
    players.add(new Player(name));
  }

  boolean hasValidAmountOfPlayers(){
    return players.size() > 0 && players.size() < MAX_PLAYERS;
  }

/*  void gameRythm(){
    Scanner scanner = new Scanner(System.in);
    int thrownPins;
    for (int i = 0; i <= frameNumber; i++) {
      for (Player p:players) { // zu manuellen Test verschieben
        System.out.println(p.getName() + " ist dran!");
        System.out.println("Wie viele Pins hast du bei deinem ersten Wurf umgeworfen?");
        thrownPins = scanner.nextInt();
        p.roll(thrownPins);
        if (!p.isStrike(thrownPins)){
          System.out.println("Wie viele Pins hast du beim zweiten Wurf umgeworfen?");
          thrownPins = scanner.nextInt();
          p.roll(thrownPins);
        }
      }
    }
  }*/

  public void roll(int knockedDownPins) {
    int currentIndex = playersLL.indexOf(currentPlayer);

    currentPlayer = playersLL.get(currentIndex + 1);

    currentPlayer.roll(knockedDownPins);
  }

  boolean isGameOver(){
    return false;
  }

  public void start() {
  }
}
