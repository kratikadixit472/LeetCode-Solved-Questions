class Solution {
    public int numSplits(String s) {
        
        int n = s.length();
        
        int[] pref = new int[n];
        int[] suff = new int[n];
        
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            set.add(s.charAt(i));
            pref[i] = set.size();
        }
        set.clear();
        
        for(int i = n-1; i >= 0 ; i--){
            set.add(s.charAt(i));
            suff[i] = set.size();
        }
        int ans = 0;
        
        for(int i = 1; i < n; i++){
            if(pref[i-1] == suff[i]) ans++;
        }
        return ans;
    }
}