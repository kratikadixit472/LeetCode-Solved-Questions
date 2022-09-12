class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        Arrays.sort(tokens);
        int points = 0;
        
        if(tokens.length <= 0 || tokens[0] > power) {
            return 0;
        }
        
        int left = 0, right = tokens.length-1;
        
        while(left <= right){
            if(power >= tokens[left]){
                power -= tokens[left++];
                points++;
            }
            else {
                if(right - left > 1){
                    power += tokens[right--];
                    points--;
                }
                else break;
            } 
        }
        return points;
    }
}