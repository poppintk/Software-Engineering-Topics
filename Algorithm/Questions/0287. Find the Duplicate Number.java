class Solution {
    // O(n)time  O(1)sapce
    // fast and slow pointer
    public int findDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int slow = nums[0], fast = nums[0];
    
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) { // has cycle
                fast = nums[0];
                while(fast != slow) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return slow;
            }
        }
        

    }
}