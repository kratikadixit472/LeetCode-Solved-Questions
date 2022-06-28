class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        
        List<String> ans = new ArrayList<>();
        
        char[] ch = currentState.toCharArray();
        
        for(int i = 0; i < currentState.length(); i++){
            if(ch[i] == '+' && (i + 1 < currentState.length() && ch[i+1] == '+')){
                ch[i] = '-'; ch[i+1] = '-';
                ans.add(new String(ch));
                ch[i] = '+'; ch[i+1] = '+';
            }
        }
        
        return ans;
    }
}