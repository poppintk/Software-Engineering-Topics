// stack O(n) space solution
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(
            '(', ')',
            '{', '}',
            '[', ']'
        );
        
        Stack<Integer> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ')' || charArr[i] == '}' || charArr[i] == ']') {
                if (stack.isEmpty()) return false;
                int idx = stack.pop();
                if (charArr[i] != map.get(charArr[idx])) return false;
            } else {
                stack.add(i);   
            }
        }
        
        return stack.isEmpty();
    }
}