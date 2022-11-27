class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        
        for(int i = 0; i + 9 < s.length(); i++){
            String ss = s.substring(i, i + 10);
            if(seen.contains(ss)){
                repeated.add(ss);
            }
            else seen.add(ss);
        }
        return new ArrayList(repeated);
    }
}