class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int m = targetSeconds / 60, s = targetSeconds % 60;
        
        return Math.min(getCost(m, s, startAt, moveCost, pushCost), getCost(m-1, s+60, startAt, moveCost, pushCost));
    }
    
    private int getCost(int min, int sec, int start, int moveCost, int pushCost){
        if(min < 0 || sec < 0 || min > 99 || sec > 99) return Integer.MAX_VALUE;
        
        String s = String.valueOf(min*100+sec);
        char prev = (char)(start + '0');
        int res = 0;
        
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == prev){
                res += pushCost;
            }
            else{
                res += pushCost + moveCost;
                prev = curr;
            }
        }
        return res;
    }
}