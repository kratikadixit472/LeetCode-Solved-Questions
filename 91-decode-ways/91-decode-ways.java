class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        
        int a = 1, b = 0;
        
        for(int i = n-1; i>=0; i--){
            
            int sum = 0;
            
            if(s.charAt(i) != '0') {
                 sum = a;
            }
            
            if(i < n - 1){
                int sec = Integer.valueOf(s.substring(i, i+2));
                if(sec >= 10 && sec <= 26){
                    sum += b;
                }
            }
            b = a;
            a = sum;
        
        }
        
        return a;
    }
}