class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        if(numerator == 0) return "0";
        
        long num  = Math.abs(Long.valueOf(numerator));
        long den = Math.abs(Long.valueOf(denominator));
        
        StringBuilder sb = new StringBuilder();
        if(numerator < 0 ^ denominator < 0) sb.append("-");
        
        sb.append(Long.toString(num / den));
        long rem = num % den;
        if(rem == 0) return sb.toString();
        
        sb.append(".");
        
        Map<Long, Integer> map = new HashMap<>();
        
        while(rem != 0){
            
            if(map.containsKey(rem)){
                sb.insert(map.get(rem), "(");
                sb.append(")");
                break;
            }
            
            map.put(rem, sb.length());
            rem = rem * 10;
            sb.append(Long.toString(rem / den));
            rem = rem % den;
        }
        return sb.toString();
    }
}