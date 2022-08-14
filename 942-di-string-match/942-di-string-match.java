class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int lo = 0, hi = s.length();
        int[] ans = new int[s.length() + 1];
        
        for(int i = 0; i <s.length(); i++){
            if(s.charAt(i) == 'I'){
                ans[i] = lo++;
            }
            else{
                ans[i] = hi--;
            }
        }
        ans[n] = hi;
        return ans;
    }
}