class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        StringBuilder stack = new StringBuilder();
        boolean[] seen = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int currIdx = c - 'a';
            if (seen[currIdx]) {
                continue;
            }
            while (stack.length() > 0 && 
                   stack.charAt(stack.length() - 1) > c && 
                   lastIndex[stack.charAt(stack.length() - 1) - 'a'] > i) {
                seen[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }
            stack.append(c);
            seen[currIdx] = true;
        } 
        return stack.toString();
    }
}