class Solution {
    List<String> ans ;
    Map<Integer, String> map;
    
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        
        if(digits.length() <= 0) return ans;
        
        map = new HashMap<>();
        map.put(2, "abc"); map.put(3, "def"); map.put(4, "ghi");
        map.put(5, "jkl"); map.put(6, "mno"); map.put(7, "pqrs");
        map.put(8, "tuv"); map.put(9, "wxyz");
        backtrack(0, digits, new StringBuilder());
        
        return ans;
    }
    
    private void backtrack(int idx, String digits, StringBuilder sb){
        
        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return;
        }
        
        String possible = map.get(digits.charAt(idx)-'0');
        for(char letter : possible.toCharArray()){
            sb.append(letter);
            backtrack(idx+1, digits, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}