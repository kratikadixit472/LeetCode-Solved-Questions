class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        int sum = 0, gasSum = 0;
        for(int i =0; i < n; i++){
            gasSum += gas[i];
            sum += cost[i];
        }
        
        if(gasSum < sum) return -1;
        
        int ans = 0, total = 0;
        
        for(int i = 0; i < n; i++){
            
            total += gas[i] - cost[i];
            if(total < 0) {
                ans = i+1;
                total = 0;
            }
        }

        return ans;
        
    }
}
