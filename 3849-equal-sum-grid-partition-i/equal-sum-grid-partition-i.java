class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] rowSums = new long[m];
        long[] colSums = new long[n];
        long totalSum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i] += grid[i][j];
                colSums[j] += grid[i][j];
                totalSum += grid[i][j];
            }
        }
        if (totalSum % 2 != 0) {
            return false;
        }

        long target = totalSum / 2;
        long currentPrefix = 0;
        for (int i = 0; i < m - 1; i++) {
            currentPrefix += rowSums[i];
            if (currentPrefix == target) {
                return true;
            }
        }
        currentPrefix = 0;
        for (int j = 0; j < n - 1; j++) {
            currentPrefix += colSums[j];
            if (currentPrefix == target) {
                return true;
            }
        }

        return false;
    }
}