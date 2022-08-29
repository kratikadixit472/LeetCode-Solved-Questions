class Solution {
    public int[] dailyTemperatures(int[] tmp) {
        
        int n = tmp.length;
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(tmp[i] < tmp[j]){
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}