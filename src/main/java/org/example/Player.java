package org.example;

import java.util.ArrayList;

public class Player extends Normalcalculation{
  int scorecount = 0;
  int totalCurrentScore = 0;
  int pinsCurrentThrow = 0;
  int pinsNextThrow = 0;
  int pinsNextNextThrow = 0;
  int frameNumber = 10;
  boolean firstThrow = true;
  int pinsFirstThrow = 0;
  int pinsSecondThrow = 0;
  ArrayList<Integer> scoreCount = new ArrayList<Integer>();
  static ArrayList<Integer> thrownPins = new ArrayList<Integer>();

  // Zugriff auf bestimmtes Element - Object object = arrayList.get(4);
  public static int totalScore() {
    int totalScore = 0;
    for (int throwNumber = 0; throwNumber < thrownPins.size(); throwNumber++) {
      if (thrownPins.get(throwNumber) == 10) {
        totalScore += thrownPins.get(throwNumber + 1) + thrownPins.get(throwNumber + 2);
      } else if (throwNumber > 0 && throwNumber % 2 == 1) {
        int frameScore = thrownPins.get(throwNumber) + thrownPins.get(throwNumber - 1);
        if (frameScore == 10) {
          totalScore += thrownPins.get(throwNumber + 1);
        }
      }
      totalScore += thrownPins.get(throwNumber);
    }
    return totalScore;
  }

  void roll(int thrownPins){
    // pinsNextNextThrow = pinsNextThrow;
    // pinsNextNextThrow = pinsCurrentThrow;
    // pinsCurrentThrow = thrownPins;
    addThrownPinsToScore(thrownPins);
    // return pinsCurrentThrow;
  }

  void addThrownPinsToScore(int thrownPins){
    scoreCount.add(thrownPins);
  }

  int getCurrentScore(){
    totalCurrentScore = 0;
    for (int i = 0; i < scoreCount.size(); i++) {
      totalCurrentScore += scoreCount.get(i);
    }
    return totalCurrentScore;
  }

  public boolean isStrike(int thrownPins){
    return thrownPins == 10;
  }

  boolean isSpare(int thrownPins){
    return pinsFirstThrow + pinsSecondThrow == 10;
  }

  void createCalculation(int thrownPins) {
    switch (thrownPins) {
      case 10:
        if(firstThrow){
          strikeCalculation(thrownPins);
        } else{
          spareCalculation(thrownPins);
        }
        break;

      default:
        calculation(thrownPins);
    }
  }
  @Override
  public int calculation(int thrownPins) {
    return scorecount + thrownPins;
  }

  public int spareCalculation(int thrownPins){
    return thrownPins + scorecount + pinsNextThrow;
  }

  public int strikeCalculation(int thrownPins){
    return scorecount + thrownPins + pinsNextThrow + pinsNextNextThrow;
  }


  boolean isDone(int frameNumber){
    this.frameNumber = frameNumber;
    return frameNumber == 0;
  }

}
