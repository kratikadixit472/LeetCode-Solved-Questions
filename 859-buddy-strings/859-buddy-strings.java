class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        if(s.length() != goal.length()) return false;
        
        Set<Character> set = new HashSet<>();
        
        int idx1 = -1 , idx2 = -1;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)){
        
                if(idx1 == -1) idx1 = i;
                else if(idx2 ==  -1) idx2 = i;
                else return false;
            }
            set.add(s.charAt(i));
        }
        if(idx1 != -1 && idx2 != -1) return s.charAt(idx1) == goal.charAt(idx2) && s.charAt(idx2) == goal.charAt(idx1);
        
        if(idx1 != -1) return false;
        
        return set.size() < s.length();
    }
}