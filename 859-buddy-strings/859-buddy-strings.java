class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        if(s.length() != goal.length()) return false;
        
        int[] frq = new int[26];
        for(char ch : s.toCharArray()){
            if(s.equals(goal)){
                if(frq[ch - 'a'] == 1) return true;
                frq[ch - 'a']++;
            }
        }
        
        List<Integer> al = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)){
                al.add(i);
            }
        }
        return al.size() == 2 && s.charAt(al.get(0)) == goal.charAt(al.get(1)) && s.charAt(al.get(1)) == goal.charAt(al.get(0));
    }
}