class Solution {
    public int numberOfSubstrings(String s) {
        
        int[] count = new int[3];
        int ans = 0, j = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            count[ch - 'a']++;
            
            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                ans += s.length() - i;
                count[s.charAt(j++) - 'a']--;
            }
            //ans += j;
        }
        return ans;
    }
}