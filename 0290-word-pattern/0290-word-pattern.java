class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        Map<Character, String> map = new HashMap<>();
        String[] arr = s.split(" ");
        
        if(pattern.length() != arr.length) return false;
        
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i])) return false;
            }
            else{
                if(map.containsValue(arr[i])) return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }
}