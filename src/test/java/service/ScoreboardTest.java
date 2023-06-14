package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ScoreboardTest {
    private Scoreboard scoreboard;

    @BeforeEach
    public void setUp() {
        scoreboard = new Scoreboard();
    }

    @Test
    public void testGetSummary() {
        scoreboard.startGame("Poland", "Canada");
        scoreboard.startGame("Spain", "Brazil");
        scoreboard.startGame("Germany", "France");
        scoreboard.startGame("Argentina", "Australia");

        scoreboard.updateScore("Poland", "Canada", 0, 5);
        scoreboard.updateScore("Spain", "Brazil", 10, 2);
        scoreboard.updateScore("Germany", "France", 2, 2);
        scoreboard.updateScore("Argentina", "Australia", 3, 1);

        scoreboard.finishGame("Germany", "France");

        List<String> summary = scoreboard.getSummary();

        Assertions.assertEquals(3, summary.size());
        Assertions.assertEquals("Spain vs Brazil - 10 : 2", summary.get(0));
        Assertions.assertEquals("Poland vs Canada - 0 : 5", summary.get(1));
        Assertions.assertEquals("Argentina vs Australia - 3 : 1", summary.get(2));
    }
}
