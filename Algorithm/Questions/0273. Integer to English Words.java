class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return dfs(num);
    }
    
    private String dfs(int num) {
        String res = "";
        if (num == 0) return "";
        else if (num < 20) res += LESS_THAN_20[num];
        else if (num < 100) res += TENS[num / 10] + " " + dfs(num % 10);
        else if (num < 1000) res += dfs(num / 100) + " Hundred " + dfs(num % 100);
        else if (num < 1000000) res += dfs(num / 1000) + " Thousand " + dfs(num % 1000);
        else if (num < 1000000000) res += dfs(num / 1000000) + " Million " +  dfs(num % 1000000);
        else res += dfs(num / 1000000000) + " Billion " + dfs(num % 1000000000);
        return res.trim();
    }
}