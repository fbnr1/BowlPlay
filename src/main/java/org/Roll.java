package org;

public final class Roll {
  private final int knockedDownPins;

  public Roll(int knockedDownPins) {
    int MAX_PINS = 10;
    if (knockedDownPins < 0 || knockedDownPins > MAX_PINS)
      throw new IllegalArgumentException();
    this.knockedDownPins = knockedDownPins;
  }

  public int getKnockedDownPins() {
    return knockedDownPins;
  }
}

