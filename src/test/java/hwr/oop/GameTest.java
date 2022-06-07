package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
        Player playerOne = new Player("robert");
        Player playerTwo = new Player("matthias");
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
    @Test
    void countScore_TwoThrows_ScoreIs7(){
        int firstRoll = Player.countScore(4);
        int secondRoll = Player.countScore(3);
        assertThat(firstRoll).isEqualTo(4);
        assertThat(secondRoll).isEqualTo(7);
    }
}
