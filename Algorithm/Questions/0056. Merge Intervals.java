class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> ans = new ArrayList<>();
        
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] last = ans.get(ans.size() - 1);
            if (cur[0] <= last[1]) { // overlap
                ans.remove(ans.size() - 1);
                ans.add(new int[] {Math.min(cur[0], last[0]), Math.max(cur[1], last[1])});       
            } else {
                ans.add(cur);
            }
        }
        
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        
        return res;
    }
}