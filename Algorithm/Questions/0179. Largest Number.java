class Solution {
    public String largestNumber(int[] nums) {
        
        List<String> arr = new ArrayList<>();
        for (int n : nums) {
            arr.add(String.valueOf(n));
        }
        
        Collections.sort(arr, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });
        
        if (arr.get(0).equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }

        return sb.toString();
    }
}