package org;

public final class Roll {
  private final int knockedDownPins;

  public Roll(int knockedDownPins) {
    final int maxPins = 10;
    if (knockedDownPins < 0 || knockedDownPins > maxPins)
      throw new IllegalArgumentException();
    this.knockedDownPins = knockedDownPins;
  }

  public int getKnockedDownPins() {
    return knockedDownPins;
  }
}

