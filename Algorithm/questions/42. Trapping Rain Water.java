class Solution {
    // brute force, looping width then looping height(verison 1)
    // looping height find its left right width(version2)
    // can we do better? monotonic stack
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int w = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[bottom];
                ans += h * w;
            }
            
            stack.add(i);
        }
        
        return ans;
    }
}