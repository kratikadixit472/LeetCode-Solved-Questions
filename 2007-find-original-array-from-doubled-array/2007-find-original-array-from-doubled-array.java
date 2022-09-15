class Solution {
    public int[] findOriginalArray(int[] arr) {
        int n =arr.length;
        if(n % 2 != 0) return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(arr);
        int[] ans = new int[n/2];
        
        for(int ele : arr) map.put(ele, map.getOrDefault(ele, 0)+1);
        
        int idx = 0;
        for(int ele : arr){
            if(map.get(ele) > 0){
                map.put(ele, map.get(ele)-1);
                int doble = ele * 2;
                if(map.containsKey(doble) && map.get(doble) > 0){
                    map.put(doble, map.get(doble)-1);
                    ans[idx++] = ele;
                }
                else{
                    return new int[0];
                }
            }
        }
       
        return ans;
    }
}