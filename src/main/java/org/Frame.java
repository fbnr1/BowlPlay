package org;


import java.util.ArrayList;

public final class Frame {
  private final int     ALL_PINS = 10;
  private final boolean lastFrame;
  private final ArrayList<Roll> rolls;
  private       boolean         finished = false;

  public Frame() {
    this(false);
  }

  public Frame(boolean lastFrame) {
    this.lastFrame = lastFrame;
    rolls = new ArrayList<>();
  }

  public void addRoll(int knockedDownPins) {
    if (!isRollAllowed()) {
      throw new IndexOutOfBoundsException("The maximum amount of rolls in this frame has been reached.");
    }
    rolls.add(new Roll(knockedDownPins));
    if (isLastRollOfFrame()) {
        finished = true;
    }
    if (!finished && knockedDownPins == ALL_PINS && !lastFrame) {
      rolls.add(new Roll(0));
      finished = true;
    }
  }

  public ArrayList<Roll> getRolls() {
    return new ArrayList<>(rolls);
  }

  public boolean isStrike() {
    if (rolls.size() == 0) {
      return false;
    }
    if (rolls.size() == 3 && rolls.get(2).getKnockedDownPins() == ALL_PINS) {
      return true;
    }
    Roll firstRoll = rolls.get(0);
    return firstRoll.getKnockedDownPins() == ALL_PINS;
  }

  public boolean isSpare() {
    if (rolls.size() < 2)
      return false;
    if ((!lastFrame && isStrike())) {
      return false;
    }
    if (lastFrame && rolls.size() == 3) {
      if (isRollStrike(0)) {
        return sumOfRolls(1, 2) == ALL_PINS;
      }
      if (isRollStrike(2)) {
        return sumOfRolls(0, 1) == ALL_PINS;
      }
    }

    if (!isStrike()) {
      return sumOfRolls(0, 1) == ALL_PINS;
    }
    return false;
  }

  public boolean isFinished() {
    return finished;
  }

  private boolean isRollAllowed() {
    return (rolls.size() < 2)
            || (lastFrame && (isStrike() || isSpare()) && !isFinished());
  }

  private boolean isLastRollOfFrame() {
    return ((rolls.size() == 2 && !lastFrame)
            || (rolls.size() == 3 && lastFrame)
            || (lastFrame && rolls.size() == 2 && !isSpare() && !isStrike()));
  }

  private int sumOfRolls(int firstIndex, int secondIndex) {
    return rolls.get(firstIndex).getKnockedDownPins() + rolls.get(secondIndex).getKnockedDownPins();
  }

  private boolean isRollStrike(int index) {
    return rolls.get(index).getKnockedDownPins() == ALL_PINS;
  }
}

