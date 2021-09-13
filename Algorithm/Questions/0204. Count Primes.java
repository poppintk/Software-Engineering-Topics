class Solution {
    public int countPrimes(int n) {
        
        if (n < 2) return 0;
        
        int count = 0;
        
        boolean[] notPrime = new boolean[n];
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            int j = 2;
            while (j * i < n) {
                notPrime[j * i] = true;
                j = j + 1;
            }
        }
        
        for (int i = 2; i < n; i++) { // why starting from 2 ? 1 and 0 is not prime
            if (!notPrime[i]) count++;
        }
        
        
        return count;
    }
}