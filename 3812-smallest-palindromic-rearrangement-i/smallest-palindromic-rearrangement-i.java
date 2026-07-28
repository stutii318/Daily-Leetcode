class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder leftHalf = new StringBuilder();
        String mid = "";
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            char ch = (char) ('a' + i);
            if (freq[i] % 2 != 0) {
                mid = String.valueOf(ch);
            }
            for (int j = 0; j < freq[i] / 2; j++) {
                leftHalf.append(ch);
            }
        }
        StringBuilder rightHalf = new StringBuilder(leftHalf).reverse();
        return leftHalf.append(mid).append(rightHalf).toString();
    }
}