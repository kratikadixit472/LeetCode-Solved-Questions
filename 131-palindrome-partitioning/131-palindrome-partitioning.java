class Solution {
    
    public List<List<String>> partition(String s) {
        
        List<List<String>> ans = new ArrayList<>();
        
        getAllPartitions(s, 0, s.length()-1, ans, new ArrayList<>());
        
        return ans;
    }
    
    private void getAllPartitions(String s, int l, int r, List<List<String>> ans, List<String> al){
        
        if(l >= s.length()) ans.add(new ArrayList<>(al));
        
        for(int i = l ; i <= r; i++){
            if(isPalindrome(s, l, i)){
                
                al.add(s.substring(l, i+1));
                getAllPartitions(s, i+1, r, ans, al);
                
                al.remove(al.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int l, int r){
        
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
        
    }
}