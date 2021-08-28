class Solution {
    // O(n^2) , by using rabin-karp able to reduce to O(m + n)
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        // if (haystack.equals(needle)) return 0;
        if (needle.length() == 0) return 0;
        
        int size = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if (i + size - 1 >= haystack.length()) break; 
            if (haystack.charAt(i) == needle.charAt(0) && haystack.substring(i, i + size).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}