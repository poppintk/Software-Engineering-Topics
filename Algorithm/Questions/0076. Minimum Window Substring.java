class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0) return s;
        if (t.length() > s.length()) return "";
        
        char[] SS = s.toCharArray();
        char[] TT = t.toCharArray();
        
        // build maps
        char[] tMap = new char[128];
        char[] sMap = new char[128];
        int unique = 0;
        for (int i = 0; i < TT.length; i++) {
            tMap[TT[i]]++;
            if (tMap[TT[i]] == 1) {
                unique++;
            }
        }
        int right = 0;
        int left = 0;
        int count = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        while (right < SS.length) {
            sMap[SS[right]]++;
            if (sMap[SS[right]] == tMap[SS[right]]) {
                count++;
            }
            
            while (left < SS.length && count == unique) {
                // OR update answer spot
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }
                
                if (sMap[SS[left]] == tMap[SS[left]]) {
                    count--;
                }
                sMap[SS[left]]--;
                left++;
            }
            // update answer spot
            
            right++;
        }
        if (min == Integer.MAX_VALUE) return "";
        
        return s.substring(start, start + min);
    }
}