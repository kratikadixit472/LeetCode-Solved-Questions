class Solution {
    
    class Pair {
        
        int val, ele;     
        public Pair(int val, int ele){
            this.val = val;
            this.ele = ele;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            pq.add(new Pair(e.getValue(), e.getKey()));
        }
        int idx = 0;
        int[] ans = new int[k];
        
        while(k-- > 0){
            ans[idx++] = pq.poll().ele;
        }
        return ans;
    }
}