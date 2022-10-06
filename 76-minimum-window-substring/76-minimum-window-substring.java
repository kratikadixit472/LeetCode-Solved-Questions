class Solution {
    public String minWindow(String s1, String s2) {
        int left = 0, res = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch : s2.toCharArray()){
            map.put(ch, map.getOrDefault(ch ,0)+1);
        }
        int target = map.size(), matched = 0;
        int si = -1, ei = -1;
        
        for(int right = 0; right < s1.length(); right++){
            char ch = s1.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch ,0)-1);
                if(map.get(ch) >= 0) matched++;
            }
            while(matched == s2.length()){
                if(res > right - left + 1){
                    res = right - left + 1;
                    si = left;
                }
                char c1 = s1.charAt(left++);
                if(map.containsKey(c1)){
                    if(map.get(c1) == 0) matched--;
                    map.put(c1, map.getOrDefault(c1 ,0)+1);
                }
            }
            // System.out.println();
        }
        if(si == -1 || res > s1.length()) return "";
        return s1.substring(si, si+res);
    }
}