class Solution {
    public int getMaximumConsecutive(int[] coins) {
        
        Arrays.sort(coins);
        int res = 1;
        
        for(int coin : coins){
            if(res < coin) break;
            res += coin;
        }
        return res;
    }
}