class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele : arr){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        Arrays.sort(arr);
        
        for(int ele : arr){
            if(map.get(ele) <= 0) continue;
            
            if(ele < 0 && ele % 2 != 0) return false;
                
            int y = (ele > 0) ? 2*ele :  ele / 2;
            
            if(map.getOrDefault(y, 0) <= 0) return false;
            
            map.put(ele, map.get(ele) - 1);
            map.put(y, map.get(y) - 1);
        }
        return true;
    }
}