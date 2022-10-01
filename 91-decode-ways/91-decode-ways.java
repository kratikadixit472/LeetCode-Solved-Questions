class Solution {
    public int numDecodings(String s) {
        
        return countAllPossible(s);
    }
    
    private int countAllPossible(String s){

        if(s.charAt(0) == '0') return 0;
        
        int a = 1, b = 1;
        
        for(int i = s.length()-1; i >= 0; i--){
            
            int sum = 0;
            
            if(s.charAt(i) != '0'){
                sum += a;
            }

            if(i < s.length()-1){
                int sec = Integer.valueOf(s.substring(i, i+2));
                if(sec >= 10 && sec <= 26) {
                    sum += b;
                }
            }
            b = a;
            a = sum;
        }
        return a;
    }
}
/*
1. string of numbers
2. we have 2 sigle digit(1-9) and double digit(10 - 26)
*/