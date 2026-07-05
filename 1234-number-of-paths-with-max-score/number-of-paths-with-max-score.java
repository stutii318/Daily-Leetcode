import java.util.List;
import java.util.Arrays;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1000000007;

        // dp[r][c][0] will store the max score to reach (r, c)
        // dp[r][c][1] will store the number of paths achieving that max score
        int[][][] dp = new int[n][n][2];

        // Initialize all max scores to -1 (representing unreachable)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = -1;
            }
        }

        // Base case: Start at the bottom-right corner
        dp[n - 1][n - 1][0] = 0;
        dp[n - 1][n - 1][1] = 1;

        // Directions to look from the current cell: Down, Right, Down-Right
        int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};

        // Traverse the board from bottom-right up to top-left
        for (int r = n - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                // Skip the starting position since it's already initialized
                if (r == n - 1 && c == n - 1) continue;
                // Skip obstacles
                if (board.get(r).charAt(c) == 'X') continue;

                int maxPrevScore = -1;
                int paths = 0;

                // Check all 3 incoming cells
                for (int[] dir : dirs) {
                    int prevR = r + dir[0];
                    int prevC = c + dir[1];

                    // Verify boundaries and if the previous cell was reachable
                    if (prevR < n && prevC < n && dp[prevR][prevC][0] != -1) {
                        int score = dp[prevR][prevC][0];
                        if (score > maxPrevScore) {
                            maxPrevScore = score;
                            paths = dp[prevR][prevC][1];
                        } else if (score == maxPrevScore) {
                            paths = (paths + dp[prevR][prevC][1]) % MOD;
                        }
                    }
                }

                // If at least one incoming cell was reachable, update DP state
                if (maxPrevScore != -1) {
                    int currVal = (board.get(r).charAt(c) == 'E') ? 0 : (board.get(r).charAt(c) - '0');
                    dp[r][c][0] = maxPrevScore + currVal;
                    dp[r][c][1] = paths;
                }
            }
        }

        // If the destination 'E' at (0,0) is unreachable, return [0, 0]
        if (dp[0][0][0] == -1) {
            return new int[]{0, 0};
        }

        return new int[]{dp[0][0][0], dp[0][0][1]};
    }
}