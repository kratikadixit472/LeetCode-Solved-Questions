class Solution {
    public boolean isPossible(int[] target) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long totalSum = 0;
        
        for(int ele : target){
            totalSum += ele;
            pq.add(ele);
        }
        
        while(!pq.isEmpty()){
            
            int maxEle = pq.poll();
            
            long remainTotal = totalSum - maxEle;
            
            if(maxEle == 1 || remainTotal == 1) return true;
            if(remainTotal == 0 || remainTotal > maxEle) return false;
                
            int updateMax = (int)(maxEle % remainTotal);
            
            if(updateMax == 0) return false;
            
            maxEle = updateMax;
            totalSum = remainTotal + maxEle;
            pq.add(maxEle);
        }
        return true;
    }
}