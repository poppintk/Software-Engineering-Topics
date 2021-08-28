class Trie {
    
    public class TrieNode {
        public char c;
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean hasWord;
        public TrieNode(char c) {
            this.c = c;
        }
    }
    
    public TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('.');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) return;
        
        char[] wordArray = word.toCharArray();
        
        TrieNode cur = root;
        Map<Character, TrieNode> curChildren = root.children;
        for (int i = 0; i < wordArray.length; i++) {
            if (!curChildren.containsKey(wordArray[i])) curChildren.put(wordArray[i],  new TrieNode(wordArray[i]));
            cur = curChildren.get(wordArray[i]);
            curChildren = cur.children;
        }
        cur.hasWord = true;
    }
    
    private TrieNode find(String word) {
        if (word == null) return null;
        
        char[] wordArray = word.toCharArray();
        
        TrieNode cur = root;
        Map<Character, TrieNode> curChildren = cur.children;
        for (int i = 0; i < wordArray.length; i++) {
            if (!curChildren.containsKey(wordArray[i])) return null;
            cur = curChildren.get(wordArray[i]);
            curChildren = cur.children;
        }
        return cur;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.hasWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node != null;
    }
}