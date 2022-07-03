package org;

import org.exceptions.PreviousFrameNotFinishedException;

import java.util.ArrayList;

public class Player{
  private final int TOTAL_FRAMES; // todo keine const? &&& nicht hier sondern in game festlegen?
  private final String name;
  private final ArrayList<Frame> frames = new ArrayList<>();

  public Player(String name) {
    this(name, 10);
  }

  public Player(String name, int totalFrames) {
    this.TOTAL_FRAMES = totalFrames;
    this.name = name;

  }

  public String getName() {
    return name;
  }

  /*public int getCurrentScore() {
    int totalScore = 0;
    for (int throwNumber = 0; throwNumber < thrownPins.size(); throwNumber++) {
      if (thrownPins.get(throwNumber) == 10) {
        totalScore += thrownPins.get(throwNumber + 1) + thrownPins.get(throwNumber + 2);
      } else if (throwNumber % 2 == 1) {
        int frameScore = thrownPins.get(throwNumber) + thrownPins.get(throwNumber - 1);
        if (frameScore == 10) {
          totalScore += thrownPins.get(throwNumber + 1);
        }
      }
      totalScore += thrownPins.get(throwNumber);
    }
    return totalScore;
  }*/

  public int getCurrentScore() {
    return ScoreCalculator.calculateCurrentScore(frames);
  }

  public void roll(int knockedDownPins){
    if (isEveryFrameFinished()) {
      startNextFrame();
    }
    frames.get(frames.size() - 1).addRoll(knockedDownPins);
  }

  public void resetFrames() {
    frames.clear();
  }

  private void startNextFrame() {
    if (frames.size() < TOTAL_FRAMES) {
      if (isEveryFrameFinished()) {
        if (frames.size() == TOTAL_FRAMES - 1)
          frames.add(new Frame(10, 3));
        else
          frames.add(new Frame(frames.size() + 1, 2));
      } else
        throw new PreviousFrameNotFinishedException("You need to finish the previous frame before starting a new one");
    }
  }

  private boolean isEveryFrameFinished() {
    for (Frame frame : frames)
      if(!frame.isFinished())
        return false;
    return true;
  }
}
