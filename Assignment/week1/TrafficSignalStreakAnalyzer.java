public class TrafficSignalStreakAnalyzer {

    static void analyzeStreak(String signals) {

        char currentSignal = signals.charAt(0);
        int currentStreak = 1;

        char maxSignal = currentSignal;
        int maxStreak = 1;

        for (int i = 1; i < signals.length(); i++) {

            if (signals.charAt(i) == currentSignal) {
                currentStreak++;
            } else {
                currentSignal = signals.charAt(i);
                currentStreak = 1;
            }

            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                maxSignal = currentSignal;
            }
        }

        System.out.println("Longest Signal Streak: " + maxSignal);
        System.out.println("Streak Length: " + maxStreak);
    }

    public static void main(String[] args) {

        String signals = "RRGGGYRR";

        analyzeStreak(signals);
    }
}