class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0, n = capacity.length;
        
        for(int i = 0; i < n; i++){
            int diff = capacity[i] - rocks[i];
            if(diff != 0){
                pq.add(diff);
            }else{
                ans++;
            }
        }
        
        while(additionalRocks != 0 && !pq.isEmpty()){
            int top = pq.poll();
            additionalRocks = additionalRocks - top;
            if(additionalRocks < 0) break;
            ans++;
        }
        return ans;
    }
}