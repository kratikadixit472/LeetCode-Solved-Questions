class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for(int p : piles) pq.add(p);
        
        while(k-- > 0){
            int top = pq.poll();
            int nw = (top / 2);
            pq.add(top - nw);
        }
        
        int ans = 0;
        
        while(!pq.isEmpty()){
            ans += pq.poll();
        }
        return ans;
    }
}