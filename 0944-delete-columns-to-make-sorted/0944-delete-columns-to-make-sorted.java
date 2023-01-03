class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length, m = strs[0].length();
        int ans = 0;
        
        for(int col = 0; col < m; col++){
            for(int row = 1; row < n; row++){
                
                if(strs[row].charAt(col) < strs[row - 1].charAt(col)){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}