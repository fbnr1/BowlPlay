package org;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


class PlayerTest {
  Player player1;

  @BeforeEach
  void createPlayer() {
    player1 = new Player("Tom");
  }

  @Test
  void getName_nameIsReturnedCorrectly() {
    assertEquals(player1.getName(), "Tom");
  }

  @Test
  void roll_CannotKnockDownMoreThanTenPins() {
    try {
      // todo FabianR : add Tests and fix code
      player1.roll(11);
      fail("No error if player knocks down more than 10 pins");
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }

  @Test
  void roll_CannotKnockDownLessThanZeroPins() {
    try {
      player1.roll(-1);
      fail("No error if player knocks down less than 0 pins");
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }

  @Test
  void getCurrentScore_noSparesOrStrikes_scoreIsReturnedCorrectly() {
    player1.roll(5);
    player1.roll(2);
    assertEquals(7, player1.getCurrentScore());
    player1.roll(3);
    player1.roll(5);
    assertEquals(15, player1.getCurrentScore());
    player1.roll(2);
    player1.roll(0);
    assertEquals(17, player1.getCurrentScore());
    player1.roll(9);
    player1.roll(0);
    assertEquals(26, player1.getCurrentScore());
    player1.roll(1);
    player1.roll(2);
    assertEquals(29, player1.getCurrentScore());
    player1.roll(2);
    player1.roll(6);
    assertEquals(37, player1.getCurrentScore());
    player1.roll(7);
    player1.roll(2);
    assertEquals(46, player1.getCurrentScore());
    player1.roll(4);
    player1.roll(5);
    assertEquals(55, player1.getCurrentScore());
    player1.roll(4);
    player1.roll(8);
    assertEquals(67, player1.getCurrentScore());
    player1.roll(0);
    player1.roll(6);
    assertEquals(73, player1.getCurrentScore());
  }

  @Test
  void getCurrentScore_someSparesAndStrikes_scoreIsReturnedCorrectly() {
    //player1.resetFrames();
    player1.roll(5);
    player1.roll(2);
    assertEquals(7, player1.getCurrentScore());
    player1.roll(5);
    player1.roll(5);
    assertEquals(17, player1.getCurrentScore());
    player1.roll(3);
    assertEquals(23, player1.getCurrentScore());
    player1.roll(3);
    assertEquals(26, player1.getCurrentScore());
    player1.roll(10);
    assertEquals(36, player1.getCurrentScore());
    player1.roll(4);
    player1.roll(3);
    assertEquals(50, player1.getCurrentScore());
  }


}

