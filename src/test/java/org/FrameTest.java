package org;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author FabianR
 */
public final class FrameTest {
   Frame frame;

   @BeforeEach
   void setupFrame() {
     frame = new Frame();
   }

  @Test
  void addRollAndGetRoll_normalRollsAreAdded_isReturnedCorrectly() {
    int knockedDownPins = 4;

    frame.addRoll(knockedDownPins);
    frame.addRoll(knockedDownPins);

    assertEquals(knockedDownPins, frame.getRolls().get(0).getKnockedDownPins());
    assertEquals(knockedDownPins, frame.getRolls().get(1).getKnockedDownPins());
  }

  @Test
  void addRoll_rollThreeTimesInARow_exceptionIsThrown() {
    int knockedDownPins = 3;

    frame.addRoll(knockedDownPins);
    frame.addRoll(knockedDownPins);
    try {
      frame.addRoll(knockedDownPins);
      fail("You can't roll three times in a row if it isn't the last round");
    } catch (IndexOutOfBoundsException e) {
      e.printStackTrace();
    }
  }

  @Test
  void addRoll_rollAfterStrikeNotLastRound_exceptionIsThrown() {
    int knockedDownPins = 3;

    frame.addRoll(10);
    try {
      frame.addRoll(knockedDownPins);
      fail("You can't roll after a strike if it isn't the last round");
    } catch (IndexOutOfBoundsException e) {
      e.printStackTrace();
    }
  }

  @Test
  void addRoll_rollAfterStrikeLastRound_noExceptionIsThrown() {
    frame = new Frame(true);
    int knockedDownPins = 3;

    frame.addRoll(10);
    frame.addRoll(knockedDownPins);
    frame.addRoll(knockedDownPins + 1);

    assertEquals(frame.getRolls().get(0).getKnockedDownPins(), 10);
    assertEquals(frame.getRolls().get(1).getKnockedDownPins(), knockedDownPins);
    assertEquals(frame.getRolls().get(2).getKnockedDownPins(), knockedDownPins + 1);
  }

  @Test
  void isStrikeAndIsSpare_noStrikeOrSpare_isFalse() {
    int knockedDownPins = 4;

    frame.addRoll(knockedDownPins);
    frame.addRoll(knockedDownPins);

    assertFalse(frame.isStrike());
    assertFalse(frame.isSpare());
  }

  @Test
  void isStrikeAndIsSpare_Strike_isTrueAndFalse() {
    int knockedDownPins = 10;

    frame.addRoll(knockedDownPins);

    assertTrue(frame.isStrike());
    assertFalse(frame.isSpare());
  }

  @Test
  void isStrikeAndIsSpare_Spare_isFalseAndTrue() {
    int knockedDownPins = 10;

    frame.addRoll(0);
    frame.addRoll(knockedDownPins);

    assertTrue(frame.isSpare());
    assertFalse(frame.isStrike());
  }

  @Test
  void isStrikeAndIsSpare_noRollsYet_isFalse() {
    assertFalse(frame.isSpare());
    assertFalse(frame.isStrike());
  }

}

