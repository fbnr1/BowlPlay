package org;

import java.util.ArrayList;

public class Player{
  private final int    TOTAL_FRAMES;
  private final String name;
  private final ArrayList<Frame> frames = new ArrayList<>();

  public Player(String name) {
    this(name, 10);
  }

  public Player(String name, int totalFrames) {
    if (totalFrames < 1) {
      throw new IllegalArgumentException("Total frames must be at least 1");
    }
    this.TOTAL_FRAMES = totalFrames;
    this.name         = name;
  }

  public String getName() {
    return this.name;
  }

  public int getCurrentScore() {
    return getScoreUntilFrame(this.frames.size());
  }

  public int getScoreUntilFrame(int frameIndex) {
    return ScoreCalculator.calculateScoreUntilFrame(frameIndex, this.frames);
  }

  public void roll(int knockedDownPins){
    if (frames.size() == 0 || isCurrentFrameFinished()) {
      startNextFrame();
    }
    frames.get(frames.size() - 1).addRoll(knockedDownPins);
  }

  public boolean isCurrentFrameFinished() {
    if (frames.size() == 0) {
      return false;
    }
    return frames.get(frames.size() - 1).isFinished();
  }

  public boolean isGameFinished() {
    return frames.size() == TOTAL_FRAMES && isCurrentFrameFinished();
  }

  private void startNextFrame() {
    if (frames.size() < TOTAL_FRAMES) {
        if (frames.size() == TOTAL_FRAMES - 1)
          frames.add(new Frame(true));
        else
          frames.add(new Frame());
    }
  }
}
