class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] totalCount = new int[26];
        for (char c : s.toCharArray()) {
            totalCount[c - 'a']++;
        }

        // Try every possible pivot index i from right to left
        for (int i = n - 1; i >= 0; i--) {
            int[] count = totalCount.clone();
            boolean prefixValid = true;

            // Consume characters to match target[0...i-1]
            for (int j = 0; j < i; j++) {
                int c = target.charAt(j) - 'a';
                if (--count[c] < 0) {
                    prefixValid = false;
                    break;
                }
            }

            if (!prefixValid) continue;

            // Find the smallest character strictly greater than target[i]
            int targetChar = target.charAt(i) - 'a';
            int chosenChar = -1;
            for (int c = targetChar + 1; c < 26; c++) {
                if (count[c] > 0) {
                    chosenChar = c;
                    break;
                }
            }

            if (chosenChar != -1) {
                // Build the result
                StringBuilder sb = new StringBuilder();
                sb.append(target.substring(0, i));
                sb.append((char) ('a' + chosenChar));
                count[chosenChar]--;

                // Append remaining characters in ascending order
                for (int c = 0; c < 26; c++) {
                    while (count[c] > 0) {
                        sb.append((char) ('a' + c));
                        count[c]--;
                    }
                }
                return sb.toString();
            }
        }

        return "";
    }
}