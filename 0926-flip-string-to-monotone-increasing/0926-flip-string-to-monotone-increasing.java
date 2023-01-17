class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int n = s.length(), i = 0;
        int cnt_flip = 0, cnt_one = 0;
        
        for(i = 0; i < n; i++){
            if(s.charAt(i) == '1'){
                cnt_one++;
            }
            else{
                cnt_flip++;
            }
            cnt_flip = Math.min(cnt_flip, cnt_one);
        }
        return cnt_flip;
    }
}