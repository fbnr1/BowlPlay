package org;


import java.util.ArrayList;

public final class Frame {
  private       int             maxRolls;
  private final int             id;
  private final ArrayList<Roll> rolls    = new ArrayList<>();
  private       boolean         finished = false;

  public Frame(int id) {
    this(id, 2);
  }
  public Frame(int id, int maxRolls) {
    this.id       = id;
    this.maxRolls = maxRolls;
  }

  public void addRoll(int knockedDownPins) {
    if (isRollAllowed() && !isFinished()) {
      //rolls.add(new Roll(rolls.size() + 1, knockedDownPins));
      rolls.add(new Roll(knockedDownPins));
      if (isLastRollOfFrame()) {
        finished = true;
      }
      if (!finished && knockedDownPins == 10)
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
    Roll firstRoll;
    Roll secondRoll;

    try {
      firstRoll  = rolls.get(0);
      secondRoll = rolls.get(1);
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
    return (rolls.size() <= 1) || (id == 10 && (isStrike() || isSpare())); // todo == maxrolls?
  }

  private boolean isLastRollOfFrame() {
    return ((rolls.size() == 2 && maxRolls == 2) || rolls.size() == 3 && maxRolls == 3 || (maxRolls == 3 && rolls.size() == 2 && !isSpare() && !isStrike() ));
  }
}

