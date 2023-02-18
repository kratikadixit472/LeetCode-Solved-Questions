class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int ban : banned){
            set.add(ban);
        }
        
        int cnt = 0;
        
        for(int i = 1; i <= n; i++){
            if(set.contains(i)) continue;
            if(i <= maxSum){
                cnt++;
                maxSum -= i;
            }
            else break;
        }
        return cnt;
    }
}