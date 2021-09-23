class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> forward = new HashMap<>();
        Map<Character, Character> backward = new HashMap<>();
        
        int n = s.length();
        for (int i = 0; i < n; i++) {
            forward.put(s.charAt(i), t.charAt(i));
            backward.put(t.charAt(i), s.charAt(i));
        }
        
        for (int i = 0; i < n; i++) { 
            if (t.charAt(i) != forward.get(s.charAt(i))) return false;
            if (s.charAt(i) != backward.get(t.charAt(i))) return false;
        }
        return true;
    }
}