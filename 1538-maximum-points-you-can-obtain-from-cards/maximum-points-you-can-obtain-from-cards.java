class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        int right = n - 1;
        for (int left = k - 1; left >= 0; left--) {
            sum -= cardPoints[left];      
            sum += cardPoints[right];     
            max = Math.max(max, sum);
            right--;
        }
        return max;
    }
}