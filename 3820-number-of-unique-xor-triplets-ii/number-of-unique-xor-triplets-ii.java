import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        
        // Step 1: Find all unique pairwise XOR values
        boolean[] pairXor = new boolean[2048];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }
        
        // Step 2: Combine pair XORs with every element to get triplet XORs
        boolean[] tripletXor = new boolean[2048];
        for (int p = 0; p < 2048; p++) {
            if (!pairXor[p]) continue;
            
            for (int num : nums) {
                tripletXor[p ^ num] = true;
            }
        }
        
        // Step 3: Count total unique triplet XOR values
        int count = 0;
        for (boolean present : tripletXor) {
            if (present) {
                count++;
            }
        }
        
        return count;
    }
}