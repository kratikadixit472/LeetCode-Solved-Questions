class Solution {
    public int largestAltitude(int[] gain) {
        
        int prev = 0, ans = 0;
        
        for(int g : gain){
            ans = Math.max(ans, g + prev);
            prev = g + prev;
        }
        return ans;
    }
}