class Solution {
    //  `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]` 
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.equals("0")) return "0";
        if (num2 == null || num2.equals("0")) return "0";
        
        int m = num1.length();
        int n = num2.length();
        
        int[] pos = new int[n + m];
        
        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                int product = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                
                int p1 = i + j, p2 = i + j + 1;
                int sum = product + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
                
            }
        }
        
        StringBuilder sb = new StringBuilder();
        boolean isLead = true;
        for (int i = 0 ; i < pos.length; i++) {
            if (pos[i] == 0 && isLead) continue;
            sb.append(pos[i]);
            isLead = false;
        }
        
        return sb.toString();
    }
}