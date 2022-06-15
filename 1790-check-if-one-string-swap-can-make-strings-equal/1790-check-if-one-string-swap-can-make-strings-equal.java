class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        List<Integer> al = new ArrayList<>();
        
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) al.add(i);
            if(al.size() > 2) return false;
        }
        
        return (al.size() == 0) || (al.size() == 2) && (s1.charAt(al.get(0)) == s2.charAt(al.get(1)) && s1.charAt(al.get(1)) == s2.charAt(al.get(0))) ;
    }
}