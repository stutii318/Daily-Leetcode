class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] memo = new int[n][n + 1];
        
        // Compute suffix sums
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return getOptimalStones(piles, suffixSum, memo, 0, 1);
    }

    private int getOptimalStones(int[] piles, int[] suffixSum, int[][] memo, int i, int M) {
        int n = piles.length;

        // Base Case: If the current player can take all remaining piles
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }

        // Return cached result if available
        if (memo[i][M] > 0) {
            return memo[i][M];
        }

        int maxStones = 0;

        // Try taking X piles (1 <= X <= 2M)
        for (int X = 1; X <= 2 * M; X++) {
            int nextM = Math.max(M, X);
            int opponentStones = getOptimalStones(piles, suffixSum, memo, i + X, nextM);
            
            // Current player's score = Total remaining stones - Opponent's optimal score
            maxStones = Math.max(maxStones, suffixSum[i] - opponentStones);
        }

        memo[i][M] = maxStones;
        return maxStones;
    }
}