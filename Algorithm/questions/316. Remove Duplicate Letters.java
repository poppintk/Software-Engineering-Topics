class Solution {
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
    // 1) 字母可能只出现一次 acdb d这里就出现一次，如果就出现一次不管顺序
    // 2) 字母可能重复， c 出现了很多次，只能被记录一次
}