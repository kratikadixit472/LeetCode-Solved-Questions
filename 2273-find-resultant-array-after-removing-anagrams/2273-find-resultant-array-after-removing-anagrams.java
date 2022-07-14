class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<words.length; i++){
            
            char[] wd2 = words[i].toCharArray();
            Arrays.sort(wd2);
            String s1 = new String(wd2); 
            String s2 = "";
            
            if(i >= 1){
                char[] wd1 = words[i-1].toCharArray();
                Arrays.sort(wd1);
                s2 = new String(wd1);
            }
             
            if(s1.equals(s2)){
                continue;
            }
        
            else{
                res.add(words[i]);
            }
        }
        return res;
    }
}