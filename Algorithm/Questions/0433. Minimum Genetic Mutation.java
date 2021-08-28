class Solution {
    // This Question same as word ladder
    // O(n * L * L) where n is number of string in the queue and L is length of the string
    private char[] CHARACTERS = new char[] {'A', 'C', 'G', 'T'};
    
    public int minMutation(String start, String end, String[] bank) {
        Set<String> dict = convertSet(bank);
        
        dict.add(start); // test remvoe
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(start);
        queue.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i  = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(end)) return step;
                for (String next : generateNext(cur, dict)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    queue.add(next);
                }
            }
            
            step++;
        }
        return -1;
    }
    
    private Set<String> convertSet(String[] bank) {
        Set<String> dict = new HashSet<>();
        
        for (String s : bank) {
            dict.add(s);
        }
        
        return dict;
    }
    // O(L * L)
    private List<String> generateNext(String str, Set<String> dict) {
        List<String> ans = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c : CHARACTERS) {
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