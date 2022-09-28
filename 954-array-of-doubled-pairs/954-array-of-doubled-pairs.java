class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele : arr){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        Integer[] B = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i)
            B[i] = arr[i];
        Arrays.sort(B, Comparator.comparingInt(Math::abs));
        
        for(int ele : B){
            if(map.get(ele) <= 0) continue;
            
            if(map.getOrDefault(2*ele, 0) <= 0) return false;
            
            map.put(ele, map.get(ele) - 1);
            map.put(2*ele, map.get(2*ele) - 1);
        }
        return true;
    }
}