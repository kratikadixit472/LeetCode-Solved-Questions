class Solution {
    public String removeStars(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        int cnt = 0, n = s.length();
        int i = n-1;
        
        while(i >= 0){
            
            char ch  = s.charAt(i);
            if(ch == '*'){
                while(i >= 0 && s.charAt(i) == '*'){
                    cnt += 1;
                    i--;
                }
            }
            
            else{
                if(cnt > 0){
                    while(i >= 0 && s.charAt(i) != '*' && cnt > 0 ){
                        cnt--;
                        i--;
                    }
                }
                else if(i >= 0){
                    sb.append(s.charAt(i--));
                }
            }
        }
        sb.reverse();
        return sb.toString();
    }
}

/*

Input: s = "leet**cod*e"
Output: "lecoe"

"abb*cdfg*****x*"

*/