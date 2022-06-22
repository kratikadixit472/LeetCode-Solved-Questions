class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> { 
                if(a.length() == b.length()){
                    return a.compareTo(b);
                }
                else{
                    return Integer.compare(a.length(), b.length());
                }
        }); 
        
         
        int i = 0;
        
        while(i < nums.length){
            pq.add(nums[i]);
            
            if(pq.size() > k){
                pq.poll();
            }
            i++;
        }
        
        return pq.poll();
    }
}