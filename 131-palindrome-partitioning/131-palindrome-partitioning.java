class Solution {
    
    public List<List<String>> partition(String s) {
        
        int n = s.length();
        List<List<String>> ans = new ArrayList<>();
        boolean[][] pdp = new boolean[n][n];
        
        for(int gap = 0; gap < n; gap++){
            for(int j = gap, i= 0 ; j < n; j++,i++){
                
                if(gap == 0) pdp[i][j] = true;
                
                else if(gap == 1 && s.charAt(i) == s.charAt(j)){
                    pdp[i][j] = true;
                }
                
                else if(s.charAt(i) == s.charAt(j) && pdp[i+1][j-1]){
                    pdp[i][j] = true;
                }
            }
        }
        getAllPartitions(s, 0, s.length()-1, ans, new ArrayList<>(), pdp);
        
        return ans;
    }
    
    private void getAllPartitions(String s, int l, int r, List<List<String>> ans, List<String> al, boolean[][] pdp){
        
        if(l >= s.length()) ans.add(new ArrayList<>(al));
        
        for(int i = l ; i <= r; i++){
            if(pdp[l][i]){
                
                al.add(s.substring(l, i+1));
                getAllPartitions(s, i+1, r, ans, al, pdp);
                
                al.remove(al.size()-1);
            }
        }
    }
    
//     private boolean isPalindrome(String s, int l, int r){
        
//         while(l < r){
//             if(s.charAt(l++) != s.charAt(r--)) return false;
//         }
//         return true;
        
//     }
}