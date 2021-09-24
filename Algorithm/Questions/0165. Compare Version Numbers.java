class Solution {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        
        int n = Math.max(split1.length, split2.length);
        int i = 0;
        int j = 0;
        while (i < n || i < n) {
            int current1 = 0;
            if (i < split1.length) {
                current1 = Integer.valueOf(split1[i]);
            }
            int current2 = 0;
            if (j < split2.length) {
                current2 = Integer.valueOf(split2[j]);
            }
            
            if (current1 > current2) {
                return 1;
            } else if (current1 < current2){
                return -1;
            }
            i++;
            j++;
        }
        
        return 0;
    }
}