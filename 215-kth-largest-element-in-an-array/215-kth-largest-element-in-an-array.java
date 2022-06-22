class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i = 0;
        
        while(i < nums.length){
            if(pq.size() < k){
                pq.add(nums[i]);
            }
            else if(pq.peek() < nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
            i++;
        }
        return pq.peek();
    }
}