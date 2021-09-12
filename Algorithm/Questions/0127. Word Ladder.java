class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        int step = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        queue.add(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return step;
                for (String next : genNext(cur, dict)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    queue.add(next);
                }
            }
            step++;
        }
        
        return 0;
    }
    
    private List<String> genNext(String cur, Set<String> dict) {
        List<String> ans = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String next = String.valueOf(chars);
                if (dict.contains(next)) {
                    ans.add(next);
                }
            }
            chars[i] = old;
        }
        return ans;
    }
}