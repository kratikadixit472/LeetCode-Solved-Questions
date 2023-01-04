class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i + k <= s.length(); i++){
            String subs = s.substring(i, i+ k);
            if(!set.contains(subs)){
                need--;
                set.add(subs);
                if(need == 0) return true;
            }
        }
        return false;
    }
}