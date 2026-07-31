import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        // Step 1: Count frequency of each letter
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Sort frequencies in ascending order
        Arrays.sort(freq);

        int totalPushes = 0;

        // Step 3: Iterate backwards (highest frequency first)
        for (int i = 0; i < 26; i++) {
            int count = freq[25 - i];
            if (count == 0) break;
            int pushCost = (i / 8) + 1;
            totalPushes += count * pushCost;
        }

        return totalPushes;
    }
}