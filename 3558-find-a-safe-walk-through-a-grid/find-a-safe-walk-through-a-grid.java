import java.util.*;
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] minDamage = new int[m][n];
        for (int[] row : minDamage) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int startDamage = grid.get(0).get(0);
        minDamage[0][0] = startDamage;
        pq.offer(new int[]{0, 0, startDamage});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int currentDamage = curr[2];
            if (currentDamage > minDamage[r][c]) {
                continue;
            }
            if (r == m - 1 && c == n - 1) {
                break;
            }
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];    
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextDamage = currentDamage + grid.get(nr).get(nc);
                    if (nextDamage < minDamage[nr][nc]) {
                        minDamage[nr][nc] = nextDamage;
                        pq.offer(new int[]{nr, nc, nextDamage});
                    }
                }
            }
        }
        return health - minDamage[m - 1][n - 1] >= 1;
    }
}