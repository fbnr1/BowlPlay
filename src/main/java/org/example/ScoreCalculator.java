package org.example;

public class ScoreCalculator {
  private static int[] ThrownPins = new int[21];
  private static int rollCounter = 0;
  static void kdkd() {
    roll(10);
    // ;
    roll(6);
    roll(2);
    roll(10);
    //
    roll(0);
    roll(2);
    roll(7);
    roll(3);
    roll(2);
    roll(2);

    System.out.println(score());
  }
  public static int score() {
    int totalScore = 0;
    for (int i = 0; i < ThrownPins.length; i++) {
      if (ThrownPins[i] == 10) {
        totalScore += ThrownPins[i + 1] + ThrownPins[i + 2];
      } else if (i > 0 && i % 2 == 1) {
        int frameScore = ThrownPins[i] + ThrownPins[i - 1];
        if (frameScore == 10) {
          totalScore += ThrownPins[i + 1];
        }
      }
      totalScore += ThrownPins[i];
    }
    return totalScore;
  }

  public static void roll(int knockedDownPins) {
    if (knockedDownPins == 10) {
      rollCounter++;
    }
    ThrownPins[rollCounter++] = knockedDownPins;
  }
}


