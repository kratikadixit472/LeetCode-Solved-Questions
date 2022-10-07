class KthLargest {

    PriorityQueue<Integer> pq;
    int k ;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        
        for(int ele : nums){
            pq.offer(ele);
        }
        while(pq.size() > k) {
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */