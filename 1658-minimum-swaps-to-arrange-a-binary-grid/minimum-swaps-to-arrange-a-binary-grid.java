class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];
        
        // Step 1: Count trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            trailingZeros[i] = count;
        }
        
        int totalSwaps = 0;
        
        // Step 2: Find and greedy swap rows to satisfy the condition
        for (int i = 0; i < n; i++) {
            int requiredZeros = n - 1 - i;
            int foundIdx = -1;
            
            // Search for the first row that meets the requirement
            for (int j = i; j < n; j++) {
                if (trailingZeros[j] >= requiredZeros) {
                    foundIdx = j;
                    break;
                }
            }
            
            // If no valid row found, it's impossible
            if (foundIdx == -1) {
                return -1;
            }
            
            // Bubble up the row to position i
            while (foundIdx > i) {
                int temp = trailingZeros[foundIdx];
                trailingZeros[foundIdx] = trailingZeros[foundIdx - 1];
                trailingZeros[foundIdx - 1] = temp;
                
                foundIdx--;
                totalSwaps++;
            }
        }
        
        return totalSwaps;
    }
}