class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        
        DFS(0, s, new ArrayList<>(), ans);
        return ans;
    }
    
    private void DFS(int idx, String s, List<String> al, List<List<String>> ans){
        
        if(idx == s.length()){
            ans.add(new ArrayList<>(al));
            return ;
        }
        
        for(int i = idx ; i < s.length(); i++){
            if(isPalindrome(s.substring(idx, i+1))){
                al.add(s.substring(idx, i+1));
                DFS(i+1, s, al, ans);
                al.remove(al.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}