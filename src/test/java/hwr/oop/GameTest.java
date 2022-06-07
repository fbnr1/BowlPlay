package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class GameTest {
  Game game;

  @BeforeEach
  void setUp() {
    game = new Game();
    Player playerOne = new Player("robert");
    Player playerTwo = new Player("matthias");
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
}
