class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128]; 
        
        int maxLength = 0;
        int left = 0; // Left boundary of the window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If we've seen this character inside our current window, 
            // slide the left pointer past its previous occurrence.
            if (lastSeen[currentChar] > left) {
                left = lastSeen[currentChar];
            }

            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);

            // Store the position of the character (using 1-based index)
            lastSeen[currentChar] = right + 1;
        }

        return maxLength;
    }
}