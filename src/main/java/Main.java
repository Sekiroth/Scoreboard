import service.Scoreboard;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard();

        // Start new games
        scoreboard.startGame("Poland", "Canada");
        scoreboard.startGame("Spain", "Brazil");
        scoreboard.startGame("Germany", "France");
        scoreboard.startGame("Sweden", "Italy");
        scoreboard.startGame("Austria", "Australia");

        // Update scores
        scoreboard.updateScore("Poland", "Canada", 10, 0);
        scoreboard.updateScore("Spain", "Brazil", 10, 2);
        scoreboard.updateScore("Germany", "France", 2, 2);
        scoreboard.updateScore("Sweden", "Italy", 6, 6);
        scoreboard.updateScore("Austria", "Australia", 3, 1);

        // Finish a game
        scoreboard.finishGame("Germany", "France");
        scoreboard.finishGame("Sweden", "Italy");

        // Get summary
        List<String> summary = scoreboard.getSummary();
        summary.forEach(System.out::println);
    }
}
