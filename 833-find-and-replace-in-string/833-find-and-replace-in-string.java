class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < indices.length; i++){
            int pattern = indices[i];
            int len = sources[i].length();
            if(indices[i] + len > s.length()) continue;
            String subs = s.substring(indices[i], indices[i]+len);
            if(subs.equals(sources[i])){
                map.put(indices[i], i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); ){
            if(map.containsKey(i)){
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length();
            }
            else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}

/*
Input:
"abcd"
[0,1]
["ab","bc"]
["eee","ffff"]
Expected: "affffd"
*/