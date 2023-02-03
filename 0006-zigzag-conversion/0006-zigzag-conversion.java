class Solution {
    public String convert(String s, int numRows) {
        
        StringBuilder[] sb = new StringBuilder[numRows];
        
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        
        int n = s.length(), i = 0;
        while(i < n){
            
            for(int j = 0; i < s.length() && j < numRows; j++, i++){
                sb[j].append(s.charAt(i));
            }
            
            for(int j = numRows - 2; j >= 1 && i < n; j--, i++){
                sb[j].append(s.charAt(i));
            }
        }
        
        for(int j = 1; j < numRows; j++){
            sb[0].append(sb[j]);
        }
        
        return sb[0].toString();
    }
}