class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sumL = 0, sumR = 0;
        int cntL = 0, cntR = 0;
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                cntL++;
            } else {
                sumL += num.charAt(i) - '0';
            }
        }
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                cntR++;
            } else {
                sumR += num.charAt(i) - '0';
            }
        }
        // If total '?' is odd, Alice makes the last move and always wins
        if ((cntL + cntR) % 2 != 0) {
            return true;
        }
        // Bob wins if and only if the difference balances out to exactly 9 per pair
        return 2 * (sumL - sumR) != 9 * (cntR - cntL);
    }
}