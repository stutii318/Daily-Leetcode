class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int minIdx = 0;
        int maxIdx = 0;
        for (int k = 0; k < n; k++) {
            if (nums[k] < nums[minIdx]) minIdx = k;
            if (nums[k] > nums[maxIdx]) maxIdx = k;
        }

        int i = Math.min(minIdx, maxIdx);
        int j = Math.max(minIdx, maxIdx);

        // Option 1: Remove both from front
        int frontOnly = j + 1;

        // Option 2: Remove both from back
        int backOnly = n - i;

        // Option 3: Remove one from front and one from back
        int bothEnds = (i + 1) + (n - j);

        return Math.min(frontOnly, Math.min(backOnly, bothEnds));
    }
}