package arrays_and_methods.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 5: Fantasy League Auto-Draft Ranking Engine
 * Scenario: Fantasy League Draft Eligibility & Ranking
 * 
 * Determines player draft eligibility via overloaded rules and ranks draftable
 * players by performance (batting average/fantasy points) descending using
 * Arrays.sort() and Comparable.
 * 
 * Concepts: Method overloading, static methods, Comparable interface,
 * Arrays.sort(), encapsulation, multi-criteria filtering.
 */
public class FantasyLeagueRankingEngine {

    /**
     * Represents a fantasy league player with match statistics and fitness status.
     */
    public static class Player implements Comparable<Player> {
        private final String name;
        private final int matchesPlayed;
        private final double battingAverage;
        private final boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        @Override
        public int compareTo(Player other) {
            // Rank descending by fantasy points (represented by batting average)
            return Double.compare(other.battingAverage, this.battingAverage);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * Overloaded draft eligibility check: experience-only bar for established players.
     * Established players with >= 10 matches qualify regardless of fitness.
     *
     * @param matchesPlayed Number of career matches played
     * @return true if the player has 10 or more matches
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Overloaded draft eligibility check: combined matches-and-fitness check.
     * Qualifying if established (>= 10 matches) OR uninjured with at least 5 matches.
     *
     * @param matchesPlayed Number of matches played
     * @param injured       Current fitness status
     * @return true if draftable under either criteria
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return isDraftable(matchesPlayed) || (!injured && matchesPlayed >= 5);
    }

    /**
     * Shortlists draftable players, sorts them using Arrays.sort(), and formats the ranking string.
     *
     * @param players Array of available players
     * @return Formatted ranking string of draftable players
     */
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();
        for (Player p : players) {
            if (p != null && isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftableList.add(p);
            }
        }

        Player[] draftable = draftableList.toArray(new Player[0]);
        // Sort using Arrays.sort relying on Player's compareTo implementation
        Arrays.sort(draftable);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(i + 1).append(". ").append(draftable[i].getName());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Fantasy League Auto-Draft Ranking Engine ===");

        Player[] draftPool = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println("Output: " + draftAndRank(draftPool));
    }
}
