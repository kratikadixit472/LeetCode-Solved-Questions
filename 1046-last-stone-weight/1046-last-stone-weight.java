class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int ele : stones){
            pq.add(ele);
        }
        
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            
            if(a != b){
                pq.add(a - b);
            }
        }
        return pq.size() == 1 ? pq.peek() : 0;
    }
}