class Solution {
    // idea is reduce two demensional to one demensional then compute as Q84
    // O(m * n)
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        if (matrix[0].length == 0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = -1;
        int[] heights = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
        
    }
    
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