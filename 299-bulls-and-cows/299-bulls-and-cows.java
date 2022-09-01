class Solution {
    public String getHint(String secret, String guess) {
        
        int[] cnt = new int[10];
        
        int bull = 0, cow = 0;
        
        for(int i = 0; i < guess.length(); i++){
            int g = guess.charAt(i) - '0', s = secret.charAt(i) - '0';
            
            if(g == s) bull++;
            else{
                if(cnt[s] < 0) cow++;
                if(cnt[g] > 0) cow++;
                cnt[s]++;
                cnt[g]--;
            }
        }
        String ans = Integer.toString(bull) + "A"+ Integer.toString(cow)+"B";
        
        return ans;
    }
}