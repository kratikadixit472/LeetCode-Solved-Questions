class Solution {
    
    List<String> ans = new ArrayList<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                   dp[i] = true;
                }
            }
        
        }
        if(dp[n]){
            get_All(0, s, wordDict, "", dp);
        }
        return ans;
    }
    
    private void get_All(int idx, String s, List<String> wordDict, String ssf, boolean[] dp){
        
        if(idx >= s.length()){
            ans.add(ssf.substring(0, ssf.length()-1));
            return;
        }
        
        for(int i = 0; i + idx <= s.length(); i++){
            if(dp[idx+i]){
                String str = s.substring(idx, i+idx);
               if(wordDict.contains(str)){
                   get_All(i + idx, s, wordDict, ssf + str+" ", dp);
               }
            }
        }
    }
}