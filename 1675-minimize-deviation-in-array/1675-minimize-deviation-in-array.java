class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        
        for(int num : nums){
            if(num % 2 == 0){
                pq.add(num);
                min = Math.min(min, num);
            }
            else{
                pq.add(2 * num);
                min = Math.min(min, 2 * num);
            }
        }
        
        int minDev = Integer.MAX_VALUE;
        
        while(!pq.isEmpty()){
            
            int val = pq.poll();
            minDev = Math.min(minDev, val - min);
            
            if(val % 2 == 0){
                pq.add(val / 2);
                min = Math.min(min, val / 2);
            }
            else{
                break;
            }
        }
        
        return minDev;
    }
}