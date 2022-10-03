class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int minTime = 0, currMaxTime = 0;
        
        for(int i = 0; i < colors.length(); i++){
            char c = colors.charAt(i);
            if(i > 0 && colors.charAt(i) != colors.charAt(i-1)){
                currMaxTime = 0;
            }
            
            minTime += Math.min(neededTime[i], currMaxTime);
            currMaxTime = Math.max(currMaxTime, neededTime[i]);
        }
        return minTime;
    }
}