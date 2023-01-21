class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> ans = new ArrayList<>();
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, n);
                    
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        ans.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return ans;
    }
    
    private boolean isValid(String s){
        if(s.length() > 3 || s.length() == 0 || s.charAt(0) == '0' && s.length() > 1 || Integer.parseInt(s) >= 256){
            return false;
        }
        return true;
    }
}