class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String doubledStr = s + s;
        
        StringBuilder alt1Builder = new StringBuilder();
        StringBuilder alt2Builder = new StringBuilder();
        
        for (int i = 0; i < 2 * n; i++) {
            alt1Builder.append(i % 2 == 0 ? '0' : '1');
            alt2Builder.append(i % 2 == 0 ? '1' : '0');
        }
        
        String alt1 = alt1Builder.toString();
        String alt2 = alt2Builder.toString();
        
        int diff1 = 0;
        int diff2 = 0;
        int minFlips = Integer.MAX_VALUE;
        int left = 0;
        
        for (int right = 0; right < 2 * n; right++) {
            if (doubledStr.charAt(right) != alt1.charAt(right)) {
                diff1++;
            }
            if (doubledStr.charAt(right) != alt2.charAt(right)) {
                diff2++;
            }
            
            // Maintain window of size n
            if (right - left + 1 > n) {
                if (doubledStr.charAt(left) != alt1.charAt(left)) {
                    diff1--;
                }
                if (doubledStr.charAt(left) != alt2.charAt(left)) {
                    diff2--;
                }
                left++;
            }
            
            // When window size reaches n, record minimum flips
            if (right - left + 1 == n) {
                minFlips = Math.min(minFlips, Math.min(diff1, diff2));
            }
        }
        
        return minFlips;
    }
}