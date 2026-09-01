import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        List<int[]> litters = new ArrayList<>();
        
        // Identify start position and assign bit indices to each 'L'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litters.add(new int[]{i, j});
                }
            }
        }
        
        int totalLitters = litters.size();
        if (totalLitters == 0) return 0; // Already cleaned
        
        int targetMask = (1 << totalLitters) - 1;
        
        // litterMap[r][c] stores the litter bit index (0 to totalLitters-1), or -1 if none
        int[][] litterMap = new int[m][n];
        for (int[] row : litterMap) Arrays.fill(row, -1);
        for (int i = 0; i < totalLitters; i++) {
            litterMap[litters.get(i)[0]][litters.get(i)[1]] = i;
        }
        
        // maxEnergy[r][c][mask] stores the max remaining energy seen for that state
        int[][][] maxEnergy = new int[m][n][1 << totalLitters];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }
        
        // Queue stores: {r, c, remaining_energy, mask, moves}
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC, energy, 0, 0});
        maxEnergy[startR][startC][0] = energy;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int e = curr[2];
            int mask = curr[3];
            int moves = curr[4];
            
            if (mask == targetMask) {
                return moves;
            }
            
            // If we have no energy left to take another step, we cannot move further
            if (e == 0) continue;
            
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                char cell = classroom[nr].charAt(nc);
                if (cell == 'X') continue;
                
                int nextEnergy = e - 1;
                int nextMask = mask;
                
                // If it's a reset point, refill energy to max capacity
                if (cell == 'R') {
                    nextEnergy = energy;
                } else if (cell == 'L') {
                    int bit = litterMap[nr][nc];
                    if (bit != -1) {
                        nextMask |= (1 << bit);
                    }
                }
                
                // Prune if we reached this state with <= energy than previously recorded
                if (nextEnergy > maxEnergy[nr][nc][nextMask]) {
                    maxEnergy[nr][nc][nextMask] = nextEnergy;
                    queue.offer(new int[]{nr, nc, nextEnergy, nextMask, moves + 1});
                }
            }
        }
        
        return -1;
    }
}