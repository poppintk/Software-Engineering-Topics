class Solution {
    // O(n^2) brute force
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            for (int j = i; j < heights.length; j++) {
                height = Math.min(heights[j], height);
                ans = Math.max((j - i + 1) * height, ans);
            }
        }
        
        return ans;
    }

    // O(n^2) brute force slightly better solution
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        int ans = 0;
        
        for (int i = 0; i < heights.length; i++) {
            int curHeight = heights[i];
            // find less than curHeight on left
            int l, r;
            for (l = i - 1; l >= 0; l--) {
                if (curHeight > heights[l]) {
                    break;
                }
            }
            // find less than curHeight on right
            for (r = i + 1; r < heights.length; r++) {
                if (curHeight > heights[r]) {
                    break;
                }
            }
            int width = r - l - 1;
            ans = Math.max(width * curHeight, ans);
        }
        
        return ans;
    }

    // base on brute forece version 2, we can optimaze solution by using monotonic stack
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int curt = (i == heights.length) ? -1 : heights[i];
            while (!stack.isEmpty() && curt <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}