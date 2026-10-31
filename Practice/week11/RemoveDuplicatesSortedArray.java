import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesSortedArray {

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int j = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }

        return j + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int count = removeDuplicates(nums);

        System.out.println("Length = " + count);
        System.out.println(Arrays.toString(
            Arrays.copyOf(nums, count)
        ));

        sc.close();
    }
}