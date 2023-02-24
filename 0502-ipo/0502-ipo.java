class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for(int i = 0; i < profits.length; i++){
            pq1.add(new int[]{capital[i], profits[i]});
        }
        
        for(int i = 0; i < k; i++){
            while(!pq1.isEmpty() && pq1.peek()[0] <= w){
                pq2.add(pq1.poll());
            }
            
            if(pq2.isEmpty()) break;
            
            w += pq2.poll()[1];
        }
        return w;
    }
}