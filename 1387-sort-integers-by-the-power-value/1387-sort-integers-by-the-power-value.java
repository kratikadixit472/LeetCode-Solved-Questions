class Solution {
    public int getKth(int lo, int hi, int k) {
     
        int idx = 0;
        Map<Integer, Integer>map = new HashMap<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        for(int i = lo ; i <= hi; i++){
            int steps = sortByPower(i, map);
            pq.add(new int[]{steps, i});
        }
        
        while(!pq.isEmpty() && k-->1) { 
            pq.poll();
        }
        
        return pq.peek()[1];
    }
    private int sortByPower(int curr, Map<Integer, Integer> map){
        
        if(curr == 1) return 0;
        if(map.containsKey(curr)) return map.get(curr);
        
        int count = 0;
        
        if(curr % 2 == 0){
            map.put(curr, 1+ sortByPower(curr / 2, map));
        }
        else{
            map.put(curr, 1+ sortByPower(3*curr + 1, map));
        }
        
        return map.get(curr);
    }
}