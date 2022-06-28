class Solution {
    public int minDeletions(String s) {
        
        int[] frq = new int[26];
        Set<Integer> set = new HashSet<>();
        
        for(char ch : s.toCharArray()){
            frq[ch - 'a']++;
        }
      
        int cnt = 0;
        for(int i = 0 ;i < 26; i++){
             
            while(frq[i] > 0 && set.contains(frq[i])){
                frq[i]--;
                cnt++;
            }
            set.add(frq[i]);
           
        }
        return cnt;
    }
}