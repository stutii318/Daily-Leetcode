class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        long multiplier = 1;
        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                x += digit * multiplier;
                sum += digit;
                multiplier *= 10;
            }
            n /= 10;
        } 
        return x * sum;
    }
}