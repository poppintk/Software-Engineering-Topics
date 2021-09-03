class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        
        Map<Character, String> strMap = new HashMap<>();
        Map<String, Character> charMap = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            strMap.put(pattern.charAt(i), words[i]);
            charMap.put(words[i], pattern.charAt(i));
        }

        for (int i = 0; i < words.length; i++) {
            if (!strMap.get(pattern.charAt(i)).equals(words[i])) {
                return false;
            }
            
            if (charMap.get(words[i]) != pattern.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}