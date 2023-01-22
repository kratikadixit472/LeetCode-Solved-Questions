class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        DFS(0, s, new ArrayList<>(), ans, dp);
        return ans;
    }
    
    private void DFS(int idx, String s, List<String> al, List<List<String>> ans, boolean[][] dp){
        
        if(idx == s.length()){
            ans.add(new ArrayList<>(al));
            return ;
        }
        
        for(int i = idx ; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(idx) && (i - idx <= 2 || dp[idx+1][i-1])){
                dp[idx][i] = true;
                al.add(s.substring(idx, i+1));
                DFS(i+1, s, al, ans, dp);
                al.remove(al.size()-1);
            }
        }
    }
}