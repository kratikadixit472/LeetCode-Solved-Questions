class Solution {
    public int getKth(int lo, int hi, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        for(int i = lo; i <= hi; i++){
            int powVal = getPowerVal(i, map);
            pq.add(new int[]{i, powVal});
        }
        
        while(!pq.isEmpty() && k-- > 1){
            pq.poll();
        }
        return pq.peek()[0];
    }
    
    private int getPowerVal(int curr, Map<Integer, Integer> map){
        
        if(curr == 1) return 0;
        if(map.containsKey(curr)) return map.get(curr);
        
        int cnt = 0;
        
        if(curr % 2 == 0){
            cnt = 1 + getPowerVal(curr / 2, map);
        }
        else{
            cnt += 1 + getPowerVal(3 * curr + 1, map);
        }
        
        map.put(curr, cnt);
        return map.get(curr);
    }
}