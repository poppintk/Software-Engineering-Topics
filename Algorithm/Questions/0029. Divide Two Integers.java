class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        // get sign
        int sign = 1;
        if (dividend < 0) {
            sign *= -1;
        }
        if (divisor < 0) {
            sign *= -1;
        }
        
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int shift = 31;
        int res = 0;
        while (a >= b) {
            while (a < b << shift) {
                shift--;
            }
            a -= (b << shift); // when using shift sign, best practice is with bracket
            res += 1 << shift; // a << shift == a * 2 ^ shift and a >> shift == a / 2^shift
        }
        
        return res * sign;
    }
}