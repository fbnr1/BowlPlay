package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
  int playerCount = 0;
  int thrownPins = 0;
  int frameNumber = 10;
  ArrayList<Player> players = new ArrayList<Player>();

  void createPlayers(int playerCount){
    this.playerCount = playerCount;
    for (int i = 0; i < playerCount; i++) {
      players.add(new Player());
    }
  }

  boolean enoughPlayers(){
    return playerCount > 0;
  }

  void gamerythmus(){
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i <= frameNumber; i++) {
      for (Player p:players) { // zu manuellen Test verschieben

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
  }

  boolean gameIsOver(){
    return false;
  }
}
