class Solution {
    // O(n)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
        }
        
        int totalCost = 0;
        for (int j = 0; j < cost.length; j++) {
            totalCost += cost[j];
        }
        
        if (totalGas < totalCost) return -1;
        
        
        int startIndex = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if (total < 0) { // greedy, answer must be the last total < 0 index + 1 
                total = 0;
                startIndex = i + 1;
            }
        }
        
        return startIndex;
    }
}