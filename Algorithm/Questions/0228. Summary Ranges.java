class Solution {
    
    // case to be consider: 
    // 1) "0" and "2->4"
    // 2)  ending case
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        if (nums.length == 1) {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }
        
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) { 
            if (nums[i] != nums[i - 1] + 1) {
                String str = prev != nums[i - 1] ? prev + "->" + nums[i - 1] : String.valueOf(nums[i - 1]); 
                ans.add(str);
                prev = nums[i];
            }
            if (i == nums.length - 1) {
                if (prev != nums[i]) {
                    ans.add(prev + "->" + nums[i]);
                } else {
                    ans.add(String.valueOf(nums[i]));
                }
                
            }
            
        }
        
        return ans;
            
    }
}