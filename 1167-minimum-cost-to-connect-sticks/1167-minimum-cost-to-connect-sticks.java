class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int ele : sticks){
            pq.add(ele);
        }
        int ans = 0;
        while(pq.size() > 1){
            int a = pq.poll(), b = pq.poll();
            ans += a + b;
            pq.add(a+b);
        }
        return ans;
    }
}