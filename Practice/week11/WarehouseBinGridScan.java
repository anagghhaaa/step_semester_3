import java.util.Scanner;

public class WarehouseBinGridScan {

    static void warehouseSummary(int[][] grid) {
        int total = 0;
        int max = grid[0][0];
        int row = 0;
        int col = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];

                if (grid[i][j] > max) {
                    max = grid[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println("Total = " + total);
        System.out.println("MaxCoordinate = (" + row + ", " + col + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        warehouseSummary(grid);

        sc.close();
    }
}
}
