// O(m + n)
class Solution {

    Map<String, String> perfectMatch = new HashMap<>();
    Map<String, String> capMatch = new HashMap<>();
    Map<String, String> vowelMatch = new HashMap<>();
    
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] ans = new String[queries.length];
        
        // build map for each condition
        for (String word : wordlist) {
            perfectMatch.put(word, word);
            
            String lowercase = word.toLowerCase();
            capMatch.putIfAbsent(lowercase, word); // Note use putIfAbsent to make sure the order 
            
            String key = getVowelKey(lowercase);
            vowelMatch.putIfAbsent(key, word);
        }
        
        
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            String lowercase = q.toLowerCase();
            String key = getVowelKey(lowercase);
            if (perfectMatch.containsKey(q)) {
                ans[i] = perfectMatch.get(q);
            } else if (capMatch.containsKey(lowercase)) {
                ans[i] = capMatch.get(lowercase);
            } else if (vowelMatch.containsKey(key)) {
                ans[i] = vowelMatch.get(key);
            } else {
                ans[i] = "";
            }
        }
        
        return ans;
        
    }
    
    
    private String getVowelKey(String word) {
        String ans = "";
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                ans += "*";
            } else {
                ans += c;
            }
        }
        return ans;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}