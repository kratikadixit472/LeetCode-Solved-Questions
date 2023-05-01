class Solution {
    public int[][] indexPairs(String text, String[] words) {
        
        List<int[]> al = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        for(String w : words) set.add(w);
        int n = text.length();
        
        for(int i = 0 ; i < n; i++){
            for(int j = i; j < n; j++){
                if(set.contains(text.substring(i, j + 1))){
                    al.add(new int[]{i, j});
                }
            }
        }
        
        int[][] ans = new int[al.size()][];
        ans = al.toArray(ans);
        return ans;
    }
}