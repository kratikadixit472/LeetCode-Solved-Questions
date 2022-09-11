class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] engineers = new int[n][2];
        
        for(int i = 0; i < n; i++){
            engineers[i] = new int[]{efficiency[i], speed[i]};
        }
        
        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        
        long totalSpeed = 0, maxPerformance = Integer.MIN_VALUE;
        
        for(int[] eng : engineers){
            
            totalSpeed += eng[1];
            pq.add(eng[1]);
            if (pq.size() > k) { 
                totalSpeed -= pq.poll();
            }
            maxPerformance = Math.max(maxPerformance, totalSpeed * eng[0]);
        }
        return (int)(maxPerformance % 1000000007);
        
    }
}