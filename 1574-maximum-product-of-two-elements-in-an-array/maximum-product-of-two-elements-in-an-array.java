class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        for (int n : nums) {
            if (n > max1) {
                max2 = max1; // Previous largest becomes second largest
                max1 = n;    // Update largest
            } else if (n > max2) {
                max2 = n;    // Update second largest
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
}