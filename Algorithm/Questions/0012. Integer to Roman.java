class Solution {
    // NOTE: any int covert to language words question, usually start subtract from bigest value to lowest value
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder sb = new StringBuilder();
        int cur = num;
        
        for (int i = 0; i < values.length; i++) {
            while (cur - values[i] >= 0) {
                cur = cur - values[i];
                sb.append(strs[i]);
            }

        }
        
        return sb.toString();
    }
}