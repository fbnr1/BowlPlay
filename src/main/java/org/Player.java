package org;

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

  public int getCurrentRollNumber() {
    int counter = 0;
    for (Frame frame : frames) {
      for (Roll roll : frame.getRolls())
        counter++;
    }
    return counter;
  }

  public int getCurrentScore() {
    return ScoreCalculator.calculateCurrentScore(frames);
  }

  public void roll(int knockedDownPins){
    if (isLastFrameFinished()) {
      startNextFrame();
    }
    frames.get(frames.size() - 1).addRoll(knockedDownPins);
  }

  private void startNextFrame() {
    if (frames.size() < TOTAL_FRAMES) {
        if (frames.size() == TOTAL_FRAMES - 1)
          frames.add(new Frame(TOTAL_FRAMES, 3));
        else
          frames.add(new Frame(frames.size() + 1));
    }
  }
  // todo FabianR : reset frames

  public boolean isLastFrameFinished() {
    return frames.size() == 0 || frames.get(frames.size() - 1).isFinished();
  }
}
