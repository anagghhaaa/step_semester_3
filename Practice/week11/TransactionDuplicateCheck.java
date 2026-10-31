import java.util.HashSet;
import java.util.Scanner;

public class TransactionDuplicateCheck {

    static boolean hasDuplicate(String[] transactionIds) {
        HashSet<String> set = new HashSet<>();

        for (String id : transactionIds) {
            if (set.contains(id)) {
                return true;
            }
            set.add(id);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] ids = new String[n];

        for (int i = 0; i < n; i++) {
            ids[i] = sc.next();
        }

        System.out.println(hasDuplicate(ids));

        sc.close();
    }
}
