class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (map.get(sub) == 2) { // only when its more than 2 is added so more than 3,4.... not going to be duplicated
                ans.add(sub);
            }
        }
        
        
        return ans;
    }
}