package service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Scoreboard {
    private Map<String, Integer[]> matches;

    public Scoreboard() {
        this.matches = new LinkedHashMap<>();
    }

    public void startGame(String homeTeam, String awayTeam) {
        matches.put(homeTeam + " vs " + awayTeam, new Integer[]{0, 0});
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        String match = homeTeam + " vs " + awayTeam;
        if (matches.containsKey(match)) {
            Integer[] scores = matches.get(match);
            scores[0] = homeScore;
            scores[1] = awayScore;
        }
    }

    public void finishGame(String homeTeam, String awayTeam) {
        matches.remove(homeTeam + " vs " + awayTeam);
    }

    public List<String> getSummary() {
        List<Map.Entry<String, Integer[]>> sortedMatches = new ArrayList<>(matches.entrySet());
        sortedMatches.sort((m1, m2) -> {
            Integer[] scores1 = m1.getValue();
            Integer[] scores2 = m2.getValue();
            int totalScore1 = scores1[0] + scores1[1];
            int totalScore2 = scores2[0] + scores2[1];
            if (totalScore1 == totalScore2) {
                // Sort by the most recently started match
                return -m1.getKey().compareTo(m2.getKey());
            } else {
                // Sort by total score (descending order)
                return Integer.compare(totalScore2, totalScore1);
            }
        });

        List<String> summary = new ArrayList<>();
        for (Map.Entry<String, Integer[]> match : sortedMatches) {
            Integer[] scores = match.getValue();
            summary.add(match.getKey() + " - " + scores[0] + " : " + scores[1]);
        }
        return summary;
    }
}