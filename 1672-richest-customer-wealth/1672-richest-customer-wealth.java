class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int wealth = 0;
        
        for(int[] acc : accounts){
            int sum = 0;
            for(int ele : acc){
                sum += ele;
            }
            wealth = Math.max(wealth, sum);
        }
        return wealth;
    }   
}