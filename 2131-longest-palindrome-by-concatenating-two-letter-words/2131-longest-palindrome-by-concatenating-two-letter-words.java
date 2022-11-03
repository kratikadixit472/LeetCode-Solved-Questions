class Solution {
    public int longestPalindrome(String[] words) {
        
        Map<String, Integer> map = new HashMap<>();
        int palindrome = 0;
        
        for(String w : words){
            String rev = w.charAt(1) +""+ w.charAt(0);
            if(map.containsKey(rev)){
                palindrome += 4;
                map.put(rev, map.getOrDefault(rev, 0) - 1);
                if(map.get(rev) == 0) map.remove(rev);
                continue;
            }
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        for(String key : map.keySet()){
            if(map.get(key) == 1 && (key.charAt(1)+""+key.charAt(0)).equals(key)){
                palindrome += 2;
                break;
            }
        }
        return palindrome;
    }
}