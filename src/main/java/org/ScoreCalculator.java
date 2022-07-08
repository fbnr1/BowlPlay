package org;

import java.util.ArrayList;

public class ScoreCalculator implements IFScoreCalculator {
  public int calculateScoreUntilFrame(int frameIndex, ArrayList<Frame> frames) {
    int[] knockedDownPins = convertFramesToPinsArray(frames);
    final int indexOfLastFrame = 18;
    int totalScore = 0;
    int frameScore;
    int iterateUntilIndex = (frameIndex == 10) ? 21 : frameIndex * 2;

    for (int i = 0; i < iterateUntilIndex; i++) {
      boolean isSecondRollOfFrame = i % 2 == 1;
      // is last round/frame?
      if (i < indexOfLastFrame) {
        // is strike?
        if (isStrike(knockedDownPins[i])) {
          // add next two rolls to score (if they already exist)
          try {
            totalScore += knockedDownPins[i + 2];
            if (!isStrike(knockedDownPins[i + 2]))
              totalScore += knockedDownPins[i + 3];
            else
              totalScore += knockedDownPins[i + 4];
          }
          catch (ArrayIndexOutOfBoundsException ignored) {
          }
        } // is second roll of frame?
        else if ( isSecondRollOfFrame && !isStrike(knockedDownPins[i - 1])) {
          frameScore = knockedDownPins[i] + knockedDownPins[i - 1];
          // is spare?
          if (isStrike(frameScore)) {
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
    int[] knockedDownPins = frames.size() != 10 ? new int[frames.size() * 2] : new int[21];
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

  private static boolean isStrike(int knockedDownPins) {
    return knockedDownPins == 10;
  }
}


