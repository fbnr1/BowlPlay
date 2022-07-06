package org;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public final class RollTest {
  Roll roll;

  @Test
  void getKnockedDownPins_normalValue_correctValueReturned() {
    int knockedDownPins = 5;
    roll = new Roll(knockedDownPins);
    assertEquals(knockedDownPins, roll.getKnockedDownPins());
  }

  @Test
  void roll_tooManyPins_exceptionIsThrown() {
    try {
      roll = new Roll(11);
      fail("You shouldn't be able to knock down more pins than allowed");
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }

  @Test
  void roll_lessThanZeroPins_exceptionIsThrown() {
    try {
      roll = new Roll(-1);
      fail("You shouldn't be able to knock down less than zero pins");
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }
}

