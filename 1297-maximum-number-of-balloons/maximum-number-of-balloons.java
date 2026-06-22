class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        for (char c : text.toCharArray()) {
            counts[c - 'a']++;
        }
        int maxBalloons = counts['b' - 'a'];             // Need 1 'b'
        maxBalloons = Math.min(maxBalloons, counts['a' - 'a']);     // Need 1 'a'
        maxBalloons = Math.min(maxBalloons, counts['l' - 'a'] / 2); // Need 2 'l's
        maxBalloons = Math.min(maxBalloons, counts['o' - 'a'] / 2); // Need 2 'o's
        maxBalloons = Math.min(maxBalloons, counts['n' - 'a']);     // Need 1 'n'
        
        return maxBalloons;
    }
}