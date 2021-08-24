class Solution {
    // monotonic stack
    public String removeDuplicateLetters(String S) {
        Stack<Integer> stack = new Stack<>();
        
        int[] last = new int[128];
        Set<Integer> visited = new HashSet<>();
        
        for (int i = 0; i < S.length(); i++) last[S.charAt(i)] = i;
        for (int i = 0; i < S.length(); i++) {
            int c = S.charAt(i);
            if (visited.contains(c)) continue; // 去重
            visited.add(c);
            while (!stack.isEmpty() && c < stack.peek() && i < last[stack.peek()]) visited.remove(stack.pop());
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : stack) sb.append((char)i);
        return sb.toString();
    }
    // "cbacdcbc" = > "acdb"
    // 1) character can only appears once, "acdb" where 'd'here only sppears once. if only sppears once then we don't care
    // 2) character can be duplicated, c appears multiple times, and it can only be tracked once
}
