class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> ans = new ArrayList<>();
        int n = candies.length, max = Integer.MIN_VALUE;
        
        for(int cand : candies){
            max = Math.max(max, cand);
        }
        
        for(int cand : candies){
            if(cand + extraCandies >= max){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}