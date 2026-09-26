public class WarehouseInventoryBalancer {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {

        int totalA = 0;
        int totalB = 0;

        for (int value : sectionA) {
            totalA += value;
        }

        for (int value : sectionB) {
            totalB += value;
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);

        if (totalA > totalB) {
            System.out.println("Section A has more inventory");
        } else if (totalB > totalA) {
            System.out.println("Section B has more inventory");
        } else {
            System.out.println("Both sections have equal inventory");
        }

        int max = sectionA[0];
        String section = "A";
        int item = 1;

        for (int i = 1; i < sectionA.length; i++) {
            if (sectionA[i] > max) {
                max = sectionA[i];
                section = "A";
                item = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > max) {
                max = sectionB[i];
                section = "B";
                item = i + 1;
            }
        }

        System.out.println("Highest Inventory: Section " + section
                + " Item " + item + " = " + max);
    }

    public static void main(String[] args) {

        int[] sectionA = {20, 15, 30, 25};
        int[] sectionB = {10, 30, 20, 15};

        analyzeInventory(sectionA, sectionB);
    }
}