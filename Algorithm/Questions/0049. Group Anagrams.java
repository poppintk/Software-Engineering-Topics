class Solution {
    // O(n*Llog(L)) where n is number of string and L is avergage length of strings
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length == 0) return ans;
        
        
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);// O(L log L)
            
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        for (List<String> value : map.values()) {
            ans.add(value);    
        }
        
        return ans;
    }
}