class Solution {
    public int[] arrayRankTransform(int[] arr) {
         
        int n = arr.length;
        int[] ans = new int[n];
        Set<Integer> set = new TreeSet<>();
        for(int ele : arr) set.add(ele);
        
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int ele : set){
            map.put(ele, rank++);
        }
        
        
        for(int i = 0; i < n; i++){
            ans[i] = map.get(arr[i]);
        }
        
        return ans;
    }
}