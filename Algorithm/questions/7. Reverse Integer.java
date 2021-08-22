class Solution {
    // version1: going backwards, O(n), O(1)
    public int reverse(int x) {
        int cur = Math.abs(x); // NOTE: -3 % 7 = 4
        int remainder = 0;
        long ans = 0; // for overflow case
        while (cur != 0) {
            remainder = cur % 10;
            ans = ans * 10 + remainder; // if there is decial number then this not working
            cur = cur / 10;
        }
        
        if (x < 0) ans = -1 * ans;
        
        // for overflow case
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) return 0;
        return (int) ans;
    }
}