class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> ans = new ArrayList<>();
        
        int[] last = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }
        
        int max = 0, brk = 0;
        
        for(int i = 0 ; i < s.length(); i++){
            max = Math.max(max, last[s.charAt(i) - 'a']);
            if(max == i){
                ans.add(i - brk + 1);
                brk = i + 1;
            }
        }
        return ans;
    }
}