package org;

import java.util.ArrayList;

public class ScoreCalculator {
  public static int calculateCurrentScore(ArrayList<Frame> frames) {
    int[] knockedDownPins = convertFramesToPins(frames);
    int totalScore = 0;

    for (int i = 0; i < knockedDownPins.length; i++) {
      int frameScore = 0;
      if(i >= 3 && frameScore != 10){
        if(knockedDownPins[i -3] == 10){
          totalScore += knockedDownPins[i];
        }
      }
      if (knockedDownPins[i] == 10) {
        totalScore += knockedDownPins[i + 1]; // + knockedDownPins[i + 2];
      } else if (i % 2 == 1) {
        frameScore = knockedDownPins[i] + knockedDownPins[i - 1];
        if (frameScore == 10) {
          totalScore += knockedDownPins[i + 1];
        }
      }
      totalScore += knockedDownPins[i];
    }
    return totalScore;
    /*
    for (int aktuellerWurf = 0; aktuellerWurf < knockedDownPins.length; aktuellerWurf++){
      if (knockedDownPins[aktuellerWurf] == 10);
      if (knockedDownPins[aktuellerWurf - 2] == 10){
        knockedDownPins[aktuellerWurf - 2] += knockedDownPins[aktuellerWurf];
        totalScore += knockedDownPins[aktuellerWurf];
      }
      if (knockedDownPins[aktuellerWurf - 3] == 10){
        knockedDownPins[aktuellerWurf - 3] += knockedDownPins[aktuellerWurf];
        knockedDownPins[aktuellerWurf - 2] += knockedDownPins[aktuellerWurf - 2];
      }
    }*/
  }

  private static int[] convertFramesToPins(ArrayList<Frame> frames) {
    int[] knockedDownPins = frames.size() != 10 ?  new int[frames.size() * 2 + 1] : new int[frames.size() * 2 + 2]; // todo nicht hardcoden
    int counter = 0;

    for (Frame frame : frames) {
      ArrayList<Roll> rolls = frame.getRolls();
      for (Roll roll : rolls) {
        knockedDownPins[counter] = roll.getKnockedDownPins();
        counter++;
      }
    }
    return knockedDownPins;
  }

  public static int getCurrentScore2(ArrayList<Frame> frames) {
    ArrayList<Integer> thrownPins2 = convertFramesToPins2(frames);
    boolean wasStrike = false;
    // todo : fehler wenn einer der letzten beiden Würfe ein Strike war
    int totalScore = 0;

    for (int throwNumber = 0; throwNumber < thrownPins2.size(); throwNumber++) {
      if (thrownPins2.get(throwNumber) == 10) {
        totalScore += thrownPins2.get(throwNumber + 1) + thrownPins2.get(throwNumber + 2);
        wasStrike = true;
      } else if (throwNumber % 2 == 1) {
        int frameScore = thrownPins2.get(throwNumber) + thrownPins2.get(throwNumber - 1);
        if (frameScore == 10) {
          totalScore += thrownPins2.get(throwNumber + 1);
        }
      }
      totalScore += thrownPins2.get(throwNumber);
    }
    return totalScore;
  }

  private static ArrayList<Integer> convertFramesToPins2(ArrayList<Frame> frames) {
    ArrayList<Integer> knockedDownPins = new ArrayList<>();
    boolean skipNext = false;

    for (Frame frame : frames) {
      for (Roll roll: frame.getRolls()) {
        if (!skipNext) {
          knockedDownPins.add(roll.getKnockedDownPins());
          if (roll.getKnockedDownPins() == 10) {
            skipNext = true;
          }
        } else
          skipNext = false;
      }
    }

    return knockedDownPins;
  }

  /*public static void roll(int knockedDownPins) {
    if (knockedDownPins == 10) {
      rollCounter++;
    }
    thrownPins[rollCounter++] = knockedDownPins;
    thrownPins2.add(knockedDownPins);
  }*/
}


