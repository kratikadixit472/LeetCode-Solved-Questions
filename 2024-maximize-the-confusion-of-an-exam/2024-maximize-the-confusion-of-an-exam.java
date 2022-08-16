class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        int left = 0, maxCon = 0, f = 0, t = 0;
        
        for(int right = 0; right < answerKey.length(); right++){
            if(answerKey.charAt(right) == 'F') f++;
            if(answerKey.charAt(right) == 'T') t++;
            
            while(Math.min(t, f) > k){
                f -= (answerKey.charAt(left) == 'F') ? 1 : 0;
                t -= (answerKey.charAt(left) == 'T') ? 1 : 0;
                
                left++;
            }
            maxCon = Math.max(maxCon, right - left + 1);
        }
        
        return maxCon;
    }
}