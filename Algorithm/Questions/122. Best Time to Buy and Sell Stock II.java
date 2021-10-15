class Solution {
    // On each day, you may decide to buy and/or sell the stock(any number of buy and/or sell). You can only hold at most one share of the stock at any time.
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0;
        for(int i = 1; i <prices.length; i++){
            if(prices[i] > prices[left]){
                profit += (prices[i] -  prices[left]);
                
            }
            
            left = i;
        }
        return profit;
    }
}