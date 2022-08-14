class Solution {
    public String smallestNumber(String pattern) {
        
        StringBuilder ans = new StringBuilder();
        StringBuilder stack = new StringBuilder();
        
        for(int i = 0; i <= pattern.length(); i++){
            stack.append((char)(i + '1'));
            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                ans.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return ans.toString();
    }
}