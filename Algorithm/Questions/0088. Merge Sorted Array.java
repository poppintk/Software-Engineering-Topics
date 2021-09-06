/**
*
    nums1.length == m + n
    nums2.length == n
    0 <= m, n <= 200
    1 <= m + n <= 200
    -109 <= nums1[i], nums2[j] <= 109
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        /**
        * merge by going backwards
        */
        
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        
        while (i >= 0) {
            nums1[k] = nums1[i];
            k--;
            i--;
        }
        
        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
        
    }
}