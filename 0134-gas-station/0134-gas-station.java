class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length, currGas = 0, totalGas = 0, start = 0;
        for(int i = 0; i < n; i++){
            currGas += (gas[i] - cost[i]);
            totalGas +=  (gas[i] - cost[i]);
            if(currGas < 0){
                start = i + 1;
                currGas = 0;
            }
        }
        return (totalGas < 0) ? -1 : start;
    }
}