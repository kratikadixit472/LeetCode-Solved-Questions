class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0;
        
        for(i = 0; i < costs.length; i++){
            coins -= costs[i];
            if(coins < 0) break;
        }
        return i;
    }
}