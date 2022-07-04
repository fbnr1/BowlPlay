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

  private boolean isLastFrameFinished() {
    /*for (Frame frame : frames)
      if(!frame.isFinished())
        return false;
    return true;*/
    return frames.size() <= 0 || frames.get(frames.size() - 1).isFinished();
  }
}
