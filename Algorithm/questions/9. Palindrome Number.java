class Solution {
    
    // O(Log 10 (x))
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x >= 0 && x <= 9) return true; 
        // Could you solve it without converting the integer to a string?
        // if a number isPalindrome then revert number == original number
        // this question become revert integer
        
        int revert = 0;
        int cur = x;
        while (cur != 0) {
            revert = revert * 10 + cur % 10;
            cur = cur / 10;
        }
        return revert == x;
        
    }
}