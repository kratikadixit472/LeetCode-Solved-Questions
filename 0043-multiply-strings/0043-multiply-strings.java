class Solution {
    public String multiply(String num1, String num2) {
        
        int n = num1.length(), m = num2.length();
        int[] ans = new int[n + m];
        
        if(m == 0 || n == 0 || num1.equals("0") || num2.equals("0")) return "0";
        
        if("1".equals(num1)) return num2;
        if("1".equals(num2)) return num1;
        
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                prod += ans[i + j + 1];
                
                ans[i + j + 1] = prod % 10;
                ans[i + j] += prod / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int a : ans){
            if(sb.length() == 0 && a == 0){
                continue;
            }
            sb.append(a);
        }
        return sb.toString();
    }
}