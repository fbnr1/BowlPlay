package org;

import java.util.ArrayList;

public class ScoreCalculator {
  public static int calculateCurrentScore(ArrayList<Frame> frames) {
    int[] knockedDownPins = convertFramesToPinsArray(frames);
    int totalScore = 0;
    int frameScore;

    for (int i = 0; i < knockedDownPins.length; i++) {
      if (i < 19) {
        // is strike?
        if (knockedDownPins[i] == 10) {
          try {
            // add next two rolls to score
            totalScore += knockedDownPins[i + 2];
            if (knockedDownPins[i + 2] != 10)
              totalScore += knockedDownPins[i + 3];
            else
              totalScore += knockedDownPins[i + 4];
          }
          catch (ArrayIndexOutOfBoundsException ignored) {
          }
          // is second roll of frame?
        }
        else if (i % 2 == 1 && knockedDownPins[i - 1] != 10) {
          frameScore = knockedDownPins[i] + knockedDownPins[i - 1];
          // is spare?
          if (frameScore == 10) {
            try {
              // add next roll to score
              totalScore += knockedDownPins[i + 1];
            }
            catch (ArrayIndexOutOfBoundsException ignored) {
            }
          }
        }
      }
      totalScore += knockedDownPins[i];
    }
    return totalScore;
  }

  private static int[] convertFramesToPinsArray(ArrayList<Frame> frames) {
    int[] knockedDownPins = frames.size() != 10 ?  new int[frames.size() * 2] : new int[frames.size() * 2 + 1]; // todo maxsize (10) nicht hardcoden
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
}


