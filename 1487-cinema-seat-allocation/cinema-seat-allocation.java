import java.util.HashMap;
import java.util.Map;
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map each row to a bitmask representing occupied seats (2 to 9)
        Map<Integer, Integer> rowMasks = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            // Only seats 2 through 9 matter for 4-person groups
            if (col >= 2 && col <= 9) {
                rowMasks.put(row, rowMasks.getOrDefault(row, 0) | (1 << (col - 1)));
            }
        }

        // Assume all rows can host 2 groups initially
        int maxGroups = (n - rowMasks.size()) * 2;

        // Bitmasks for the 3 target 4-person blocks (0-indexed seat positions):
        // Seats 2,3,4,5 -> bits 1,2,3,4 -> 0b0000011110 = 30 (0x1E)
        // Seats 6,7,8,9 -> bits 5,6,7,8 -> 0b0111100000 = 480 (0x1E0)
        // Seats 4,5,6,7 -> bits 3,4,5,6 -> 0b0001111000 = 120 (0x78)
        int leftMask = (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4);   // 30
        int rightMask = (1 << 5) | (1 << 6) | (1 << 7) | (1 << 8);  // 480
        int middleMask = (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6); // 120

        for (int mask : rowMasks.values()) {
            boolean leftFree = (mask & leftMask) == 0;
            boolean rightFree = (mask & rightMask) == 0;
            boolean middleFree = (mask & middleMask) == 0;

            if (leftFree && rightFree) {
                maxGroups += 2;
            } else if (leftFree || rightFree || middleFree) {
                maxGroups += 1;
            }
            // If none are free, 0 groups are added for this row
        }

        return maxGroups;
    }
}