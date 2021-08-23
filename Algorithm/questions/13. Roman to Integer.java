class Solution {
    // Note: any language words convert to integer, usually looping backwards on the language string 
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        
        // IX => 9  IV => 4
        // looping backwards, if next value is less than the current value substract
        int prev = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int curVal = map.get(c);
            if (prev > curVal) {
                ans -= curVal;
            } else {
                ans += curVal;
            }
            prev = curVal;
        }
        
        return ans;
        
    }
}