class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        Set<String> set = new HashSet<>();
        
        for(String start : startWords){
            char[] st = start.toCharArray();
            Arrays.sort(st);
            set.add(new String(st));
        }
        
        int ans = 0;
        
        for(String target : targetWords){
            char[] tar = target.toCharArray();
            Arrays.sort(tar);
            target = new String(tar);
            
            for(int i = 0; i < target.length(); i++){
                
                String s = target.substring(0, i) + target.substring(i+1);
                if(set.contains(s)){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}