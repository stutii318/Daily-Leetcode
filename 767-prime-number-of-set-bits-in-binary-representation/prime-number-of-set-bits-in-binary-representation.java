class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        boolean[] isPrime = new boolean[32];
        isPrime[2] = isPrime[3] = isPrime[5] = isPrime[7] = true;
        isPrime[11] = isPrime[13] = isPrime[17] = isPrime[19] = true;
        isPrime[23] = isPrime[29] = isPrime[31] = true;
        for (int i = left; i <= right; i++) {
            if (isPrime[Integer.bitCount(i)]) {
                count++;
            }
        }
        
        return count;
    }
}