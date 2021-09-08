class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0){
            return Arrays.asList(1);
        } 
        if (rowIndex == 1) {
            return Arrays.asList(1, 1);
        }

        List<Integer> prevLvl = Arrays.asList(1, 1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= rowIndex; i++) {
            ans = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ans.add(1);
                } else {
                    ans.add(prevLvl.get(j - 1) + prevLvl.get(j));
                }
            }
            prevLvl = ans;
        }
        
        
        return ans;
    }
}