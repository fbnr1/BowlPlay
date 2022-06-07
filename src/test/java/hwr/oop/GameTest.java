package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    // testmethode_Scenario_erweiterteVerhalten

    @BeforeEach
    void setUp() {
        Game game = new Game();
        Player playerOne = new Player("robert");
        Player playerTwo = new Player("matthias");

    }


    @Test
    void checkAllPinsFavor_ThrowIsStrike_10PinsFavor(){
        boolean isStrike = Throw.checkAllPinsFavor(10);
        assertThat(isStrike).isTrue();
    }
}
