class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int count1 = 0; // Cost to make it start with '0' ("010101...")

        for (int i = 0; i < n; i++) {
            // Expected char for pattern starting with '0':
            // Even index -> '0', Odd index -> '1'
            char expected = (i % 2 == 0) ? '0' : '1';
            
            if (s.charAt(i) != expected) {
                count1++;
            }
        }

        // Cost for pattern starting with '1' ("101010...") is (n - count1)
        return Math.min(count1, n - count1);
    }
}