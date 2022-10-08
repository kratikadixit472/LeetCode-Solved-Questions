class Solution {
    public int getKth(int lo, int hi, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        for(int i = lo; i <= hi; i++){
            int powVal = getPowerVal(i);
            pq.add(new int[]{i, powVal});
        }
        
        while(!pq.isEmpty() && k-- > 1){
            pq.poll();
        }
        return pq.peek()[0];
    }
    
    private int getPowerVal(int curr){
        
        if(curr == 1) return 0;
        
        int cnt = 0;
        
        if(curr % 2 == 0){
            cnt = 1 + getPowerVal(curr / 2);
        }
        else{
            cnt += 1 + getPowerVal(3 * curr + 1);
        }
        return cnt;
    }
}