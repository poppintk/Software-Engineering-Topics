class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null ||nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] doubleNums = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            doubleNums[i] = nums[i % n];
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for (int i = doubleNums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && doubleNums[stack.peek()] <= doubleNums[i]) {
                stack.pop();
            }
            
            if (i < n) {
                ans[i] = stack.isEmpty() ? -1 : doubleNums[stack.peek()];
            }
            stack.add(i);
        }
        
        return ans;
    }
}