class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // NOTE: a tricky part of this question is when should we add the newInterval, when at the left of current
        List<int[]> ans = new ArrayList<>();
        for (int[] cur : intervals) {
            if (newInterval != null && cur[0] > newInterval[1]) { // on the left of current
                ans.add(newInterval);
                ans.add(cur);
                newInterval = null;
            } else if (newInterval == null || cur[1] < newInterval[0]) { // on the right of current, also due to newInterval set to null
                ans.add(cur);
            } else { // overlap
                newInterval[0] = Math.min(cur[0], newInterval[0]);
                newInterval[1] = Math.max(cur[1], newInterval[1]);
            }
        }
        
        if (newInterval != null) ans.add(newInterval);
        
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        
        return res;
    }
}