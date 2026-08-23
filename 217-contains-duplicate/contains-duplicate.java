import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {

            // Already seen this number
            if (map.containsKey(num)) {
                return true;
            }

            // First time seeing this number
            map.put(num, 1);
        }

        return false;
    }
}