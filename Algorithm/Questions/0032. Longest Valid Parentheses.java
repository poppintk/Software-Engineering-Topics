class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // stack is empty 
                } else {
                    maxans = Math.max(maxans, i - stack.peek()); // peek() at the left most
                }
            }
        }
        return maxans;
    }
}