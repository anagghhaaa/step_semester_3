public class TypingSpeedAccuracyChecker {

    static void checkAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matched * 100.0) / original.length();

        System.out.println("Matched Characters: " + matched);
        System.out.printf("Accuracy: %.2f%%\n", accuracy);

        if (firstMismatch == -1) {
            System.out.println("No Mismatch Found");
        } else {
            System.out.println("First Mismatch Position: " + (firstMismatch + 1));
            System.out.println("Expected: " + original.charAt(firstMismatch));
            System.out.println("Typed: " + typed.charAt(firstMismatch));
        }
    }

    public static void main(String[] args) {

        String original = "hello world";
        String typed = "hello worlt";

        checkAccuracy(original, typed);
    }
}
