package org;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Tests for Player and ScoreCalculator
 */
class PlayerTest {
  Player playerOne;

  @BeforeEach
  void createPlayer() {
    playerOne = new Player("Tom");
  }

  @Test
  void getName_nameIsReturnedCorrectly() {
    assertEquals(playerOne.getName(), "Tom");
  }

  @Test
  void roll_CannotKnockDownMoreThanTenPins() {
    try {
      playerOne.roll(11);
      fail("No error if player knocks down more than 10 pins");
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }

  @Test
  void roll_CannotKnockDownLessThanZeroPins() {
    try {
      playerOne.roll(-1);
      fail("No error if player knocks down less than 0 pins");
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }

  @Test
  void getCurrentScore_noSparesOrStrikes_scoreIsReturnedCorrectly() {
    playerOne.roll(5);
    playerOne.roll(2);
    assertEquals(7, playerOne.getCurrentScore());
    playerOne.roll(3);
    playerOne.roll(5);
    assertEquals(15, playerOne.getCurrentScore());
    playerOne.roll(2);
    playerOne.roll(0);
    assertEquals(17, playerOne.getCurrentScore());
    playerOne.roll(9);
    playerOne.roll(0);
    assertEquals(26, playerOne.getCurrentScore());
    playerOne.roll(1);
    playerOne.roll(2);
    assertEquals(29, playerOne.getCurrentScore());
    playerOne.roll(2);
    playerOne.roll(6);
    assertEquals(37, playerOne.getCurrentScore());
    playerOne.roll(7);
    playerOne.roll(2);
    assertEquals(46, playerOne.getCurrentScore());
    playerOne.roll(4);
    playerOne.roll(5);
    assertEquals(55, playerOne.getCurrentScore());
    playerOne.roll(4);
    playerOne.roll(8);
    assertEquals(67, playerOne.getCurrentScore());
    playerOne.roll(0);
    playerOne.roll(6);
    assertEquals(73, playerOne.getCurrentScore());
  }

  @Test
  void getCurrentScore_someSparesAndStrikes_scoreIsCalculatedCorrectly() {
    playerOne.roll(5);
    playerOne.roll(2);
    assertEquals(7, playerOne.getCurrentScore());
    playerOne.roll(5);
    playerOne.roll(5);
    assertEquals(17, playerOne.getCurrentScore());
    playerOne.roll(3);
    assertEquals(23, playerOne.getCurrentScore());
    playerOne.roll(3);
    assertEquals(26, playerOne.getCurrentScore());
    playerOne.roll(10);
    assertEquals(36, playerOne.getCurrentScore());
    playerOne.roll(4);
    playerOne.roll(0);
    assertEquals(44, playerOne.getCurrentScore());
    playerOne.roll(4);
    playerOne.roll(0);
    assertEquals(48, playerOne.getCurrentScore());

  }

  @Test
  void getCurrentScore_someStrikes_scoreIsCalculatedCorrectly(){
    playerOne.roll(10);
    assertEquals(10, playerOne.getCurrentScore());
    playerOne.roll(1);
    assertEquals(12, playerOne.getCurrentScore());
    playerOne.roll(2);
    assertEquals(16, playerOne.getCurrentScore());
  }

  @Test
  void getCurrentScore_fiveStrikesInARow_scoreIsCalculatedCorrectly(){
    playerOne.roll(3);
    playerOne.roll(4);
    assertEquals(7, playerOne.getCurrentScore());
    playerOne.roll(10);
    assertEquals(17, playerOne.getCurrentScore());
    playerOne.roll(10);
    assertEquals(37, playerOne.getCurrentScore());
    playerOne.roll(10);
    assertEquals(67, playerOne.getCurrentScore());
    playerOne.roll(10);
    assertEquals(97, playerOne.getCurrentScore());
    playerOne.roll(10);
    assertEquals(127, playerOne.getCurrentScore());
    playerOne.roll(2);
    playerOne.roll(4);
    assertEquals(141, playerOne.getCurrentScore());
    playerOne.roll(2);
    playerOne.roll(4);
    assertEquals(147, playerOne.getCurrentScore());

  }

  @Test
  void getCurrentScore_SpareAndThenStrike_scoreIsCalculatedCorrectly(){
    playerOne.roll(0);
    playerOne.roll(10);
    assertEquals(10, playerOne.getCurrentScore());
    playerOne.roll(10);
    assertEquals(20, playerOne.getCurrentScore());
    playerOne.roll(10);
    assertEquals(50, playerOne.getCurrentScore());
    playerOne.roll(10);
    assertEquals(80, playerOne.getCurrentScore());
    playerOne.roll(2);
    playerOne.roll(6);
    assertEquals(98, playerOne.getCurrentScore());
    playerOne.roll(2);
    playerOne.roll(3);
    assertEquals(103, playerOne.getCurrentScore());
    playerOne.roll(2);
    playerOne.roll(1);
    assertEquals(106, playerOne.getCurrentScore());
  }

  @Test
  void getCurrentScore_StrikeInLastRound_threeRollsInLastRound(){
    for (int i = 1; i <= 18; i++) {
      playerOne.roll(4);
    }
    playerOne.roll(10);
    playerOne.roll(4);
    System.out.println(playerOne.getCurrentScore());
  }
}

