class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int n : nums) {
            set.add(n);
        }
        
        int longest = 0;
        for (int n : set) {
            if (set.contains(n - 1)) continue; // import check
            int count = 0;
            int cur = n;
            while (set.contains(cur)) {
                count++;
                cur++;
            }
            longest = Math.max(longest, count);
        }
        
        return longest;
    }
}