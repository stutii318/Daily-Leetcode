import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Descending by end point
            }
            return a[0] - b[0]; // Ascending by start point
        });
        
        int remainingCount = intervals.length;
        int maxEnd = 0;
        
        // 2. Iterate through the intervals and check for coverage
        for (int[] interval : intervals) {
            int end = interval[1];
            if (end <= maxEnd) {
                remainingCount--;
            } else {
                maxEnd = end;
            }
        }
        
        return remainingCount;
    }
}