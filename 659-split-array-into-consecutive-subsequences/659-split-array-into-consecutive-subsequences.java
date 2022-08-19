class Solution {
    public boolean isPossible(int[] nums) {
        
        if(nums.length < 3) return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        
        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        
        int n = nums.length;
        
        for(int a : nums){
            
            if(map.get(a) <= 0) continue;
            map.put(a, map.get(a)-1);
            
            if(end.containsKey(a - 1) && end.get(a-1) > 0){
                end.put(a-1, end.get(a-1) - 1);
                end.put(a, end.getOrDefault(a, 0)+1);
                continue;
            }
            else if(map.containsKey(a+1) && map.get(a+1) > 0 && map.containsKey(a+2) && map.get(a+2) > 0){
                map.put(a+1, map.get(a+1) - 1);
                map.put(a+2, map.get(a+2) - 1);
                end.put(a+2, end.getOrDefault(a+2, 0)+1);
                continue;
            }
            else return false;
        }
        return true;
    }
}
