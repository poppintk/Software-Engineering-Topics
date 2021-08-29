class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        if (n == 2) return "11";
        
        String s = countAndSay(n - 1);
        
        
        int i = 0;
        int j = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while (j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                sb.append(j - i);
                sb.append(s.charAt(i));
                i = j;
            }
            j++;
        }
        sb.append(j - i);
        sb.append(s.charAt(i));
        
        
        
        return sb.toString();
    }
}