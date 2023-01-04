class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ele : arr){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for(int key : map.keySet()){
            pq.add(new int[]{key, map.get(key)});
        }
        
        while(k > 0 && !pq.isEmpty()){
            int[] top = pq.poll();
            if(top[1] > k){
                int rem = top[1] - k;
                pq.add(new int[]{top[0], rem});
                break;
            }
            k = k - top[1];
        }
        
        // int ans = 0;
        // while(!pq.isEmpty()){
        //     ans += pq.poll()[1];
        // }
        return pq.size();
    }
}