package org;


import java.util.ArrayList;

public final class Frame {
  private final boolean lastFrame;
  private final ArrayList<Roll> rolls    = new ArrayList<>();
  private       boolean         finished = false;

  public Frame() {
    this(false);
  }
  public Frame(boolean lastFrame) {
    this.lastFrame = lastFrame;
  }

  public void addRoll(int knockedDownPins) {
    if (isRollAllowed()) { //  && !isFinished()
      //rolls.add(new Roll(rolls.size() + 1, knockedDownPins));
      rolls.add(new Roll(knockedDownPins));
      if (isLastRollOfFrame()) {
        finished = true;
      }
      if (!finished && knockedDownPins == 10 && !lastFrame)
        addRoll(0);
    }
    else {
      throw new IndexOutOfBoundsException("The maximum amount of rolls in this frame has been reached.");
    }
  }

  public ArrayList<Roll> getRolls() {
    return rolls;
  }

  public boolean isStrike() {
    try {
      Roll firstRoll = rolls.get(0);
      return firstRoll.getKnockedDownPins() == 10;
    } catch (IndexOutOfBoundsException e) {
      return false;
    }

  }

  public boolean isSpare() {
    if (isStrike()) {
      return false;
    }
    try {
      Roll firstRoll  = rolls.get(0);
      Roll secondRoll = rolls.get(1);
      return (firstRoll.getKnockedDownPins() + secondRoll.getKnockedDownPins() == 10);
    }
    catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  public boolean isFinished() {
    return finished;
  }

  private boolean isRollAllowed() {
    return (rolls.size() <= 1) || (lastFrame && (isStrike() || isSpare()) && !isFinished());
  }

  private boolean isLastRollOfFrame() {
    return ((rolls.size() == 2 && !lastFrame) || rolls.size() == 3 && lastFrame || (lastFrame && rolls.size() == 2 && !isSpare() && !isStrike()));
  }
}

