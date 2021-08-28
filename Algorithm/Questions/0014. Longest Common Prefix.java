class Solution {
    // brute force,greedy.  O(max(L) * n * l) L is maximum length in the strs and n is number of string in strs and l is the length of each string in strs
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        // get maximum length 
        int len = 0;
        for (String str : strs) {
            len = Math.max(str.length(), len);
        }
        
       
        for (int l = len; l >= 1; l--) {
            String prev = null;
            boolean allSame = true;
            for (String str : strs) {
                if (str.length() < l) {
                    allSame = false;
                    break;
                }
                String cur = str.substring(0, l);
                if (prev != null && !prev.equals(cur)) {
                    allSame = false;
                    break;
                }
                prev = cur;
            }
            if (allSame) return prev;
        }
        
        return "";
    }
    // better O(n * L) sum of all character in the strs
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) { // not having prefix , then keep decreasing size of prefix 
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }        
        return prefix;
    }

    // use trie
    
    public class Trie {
        public class TrieNode {
            char c;
            Map<Character, TrieNode> children = new HashMap<>();
            boolean hasWord;
            TrieNode(char c) {
                this.c = c;
            }
        }

        private TrieNode root;
        public Trie() {
            root = new TrieNode('.');
        }

        public void insert(String word) {
            TrieNode cur = null;
            Map<Character, TrieNode> curChildren = root.children;
            char[] wordArray = word.toCharArray();
            for (int i = 0; i < wordArray.length; i++) {
                char c = wordArray[i];
                if (!curChildren.containsKey(c)) curChildren.put(c, new TrieNode(c));

                cur = curChildren.get(c);
                curChildren = cur.children;

                if (i == wordArray.length - 1) {
                    cur.hasWord = true;
                }
            }
        }

        public TrieNode searchNode(String word) {
            TrieNode cur = null;
            Map<Character, TrieNode> curChildren = root.children;
            char[] wordArray = word.toCharArray();
            for (int i = 0; i < wordArray.length; i++) {
                char c = wordArray[i];
                if (!curChildren.containsKey(c)) return null;

                cur = curChildren.get(c);
                curChildren = cur.children;
            }
            return cur; // if require exactly search, need to check cur.hasWord
        }

    }
}