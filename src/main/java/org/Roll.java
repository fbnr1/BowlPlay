package org;

public final class Roll {
  private final int id; // todo rename / remove?
  private final int knockedDownPins;

  public Roll(int id, int knockedDownPins) {
    int MAX_PINS = 10;
    this.id = id;
    if (knockedDownPins < 0 || knockedDownPins > MAX_PINS)
      throw new IllegalArgumentException();
    this.knockedDownPins = knockedDownPins;
  }

  public int getKnockedDownPins() {
    return knockedDownPins;
  }
}

