class Solution {
    /*
    *
    1 <= digits.length <= 100
    0 <= digits[i] <= 9
    digits does not contain any leading 0's.
    
    */
        
    public int[] plusOne(int[] digits) {
        List<Integer> ans = new ArrayList<>();
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i] + (i == digits.length - 1 ? 1 : 0);
            carry = sum / 10;
            ans.add(sum % 10);
        }
        
        if (carry != 0) ans.add(carry);
        
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[ans.size() - 1 - i] = ans.get(i);
        }
        
        return res;
    }
}