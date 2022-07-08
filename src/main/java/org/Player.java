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
    return getScoreUntilFrame(frames.size());
  }

  public int getScoreUntilFrame(int frameIndex) {
    IFScoreCalculator scoreCalculator = new ScoreCalculator();
    return scoreCalculator.calculateScoreUntilFrame(frameIndex, frames);
  }

  public void roll(int knockedDownPins) throws IllegalArgumentException {
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

  public int getCurrentFrameIndex() {
    return frames.size();
  }
  private void startNextFrame() {
    if (frames.size() < TOTAL_FRAMES) {
        if (frames.size() == TOTAL_FRAMES - 1) {
          frames.add(new Frame(true));
        }
        else {
          frames.add(new Frame());
        }
    }
  }
}
