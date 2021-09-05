/*
* 1 <= s.length <= 100
* s contains only digits and may contain leading zero(s).
*/
class Solution {
    public int numDecodings(String s) {
        // let dp[i] be the number of way to decode string
        // dp[i] = dp[i - 1] (if S[i - 1] is character)  + dp[i - 2] (if S[i - 2] is character 2 and S[i - 1] <= 6 OR S[i - 2] is one)
        
        
        char[] S = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            if (S[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            
            if(i - 2 >= 0 && ((S[i - 1] <= '6' && S[i - 2] == '2') || S[i - 2] == '1')){
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}