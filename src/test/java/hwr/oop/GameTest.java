package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class GameTest {
    Game game;
    Player playerOne;
    Player playerTwo;

    @BeforeEach
    void setUp() {
        game = new Game();
        playerOne = new Player("Robert");
        playerTwo = new Player("Matthias");
    }
  
  @Test
  void gameIsCreatedCorrectlyAndRollsCanBePerformed() {
    assertThat(game).isNotEqualTo(null);

    assertThatNoException().isThrownBy(() -> {
      game.roll(0);
      game.roll(1);
      game.roll(10);
    });
  }

  @Test
  void cannotHitLessThanZeroOrMoreThanTenPins() {
    assertThatExceptionOfType(Exception.class).isThrownBy(() -> game.roll(-1));
    assertThatExceptionOfType(Exception.class).isThrownBy(() -> game.roll(11));
  }

  @Test
  void checkAllPinsFavor_ThrowIsStrike_10PinsFavor() {
    boolean isStrike = Throw.checkAllPinsFavor(10);
    assertThat(isStrike).isTrue();
  }
  
    @Test
    void countScore_3ThrowsOfBothPlayer_ScoreIs11And15(){
        playerOne.countScore(2);
        playerOne.countScore(4);
        playerTwo.countScore(7);
        playerTwo.countScore(3);
        int scorePlayerOne = playerOne.countScore(5);
        int scorePlayerTwo = playerTwo.countScore(5);
        assertThat(scorePlayerOne).isEqualTo(11);
        assertThat(scorePlayerTwo).isEqualTo(15);
    }
    @Test
    void getFavorPins_ThrowIsStrike_10PinsFavor(){
        int favorPins = Throw.getFavorPins(3);
        assertThat(favorPins).isEqualTo(3);
    }
    @Test
    void checkAllPinsFavor_ThrowIsStrike_10PinsFavor(){
        boolean isStrike = Throw.checkAllPinsFavor(10);
        assertThat(isStrike).isTrue();
    }
    @Test
    void checkAllPinsFavor_ThrowIsNotStrike_4PinsFavor(){
        boolean isNotStrike = Throw.checkAllPinsFavor(4);
        assertThat(isNotStrike).isFalse();
    }
    @Test
    void checkQuantityOfFavorPins_ThrowIsValid_7PinsFavor(){
        boolean favorSevenPins = Throw.checkQuantityOfFavorPins(7);
        assertThat(favorSevenPins).isTrue();
    }
    @Test
    void checkQuantityOfFavorPins_ThrowIsInvalid_12PinsFavor(){
        boolean favorTwelvePins = Throw.checkQuantityOfFavorPins(12);
        assertThat(favorTwelvePins).isFalse();
    }
    /*@Test
    void countScore_TwoThrows_ScoreIs7(){
        int firstRoll = Player.countScore(4);
        int secondRoll = Player.countScore(3);
        assertThat(firstRoll).isEqualTo(4);
        assertThat(secondRoll).isEqualTo(7);
    }*/
}
