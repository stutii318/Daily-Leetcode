import java.util.*;
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                addSum(set, grid[r][c]);
                for (int L = 1; r - L >= 0 && r + L < m && c - L >= 0 && c + L < n; L++) {
                    int sum = 0;
                    for (int i = 0; i < L; i++) {
                        sum += grid[r - L + i][c + i];
                    }
                    for (int i = 0; i < L; i++) {
                        sum += grid[r + i][c + L - i];
                    }
                    for (int i = 0; i < L; i++) {
                        sum += grid[r + L - i][c - i];
                    }
                    for (int i = 0; i < L; i++) {
                        sum += grid[r - i][c - L + i];
                    }
                    
                    addSum(set, sum);
                }
            }
        }
        int size = set.size();
        int[] result = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = set.pollFirst();
        }
        
        return result;
    }
    
    private void addSum(TreeSet<Integer> set, int sum) {
        set.add(sum);
        if (set.size() > 3) {
            set.pollFirst(); 
        }
    }
}