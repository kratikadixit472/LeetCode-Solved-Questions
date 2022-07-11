import java.util.List;  

class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue() == 1){
                ans.add(e.getKey());
            }
        }
        int[] ansArray = new int[ans.size()];
        int idx = 0;
        
        for(int ele : ans){
            ansArray[idx++] = ele;
        }
        
        return ansArray;
    }
}