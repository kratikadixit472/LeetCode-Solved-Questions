class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> ans = new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (Math.abs(b - x) == Math.abs(a - x)) ? b - a : Math.abs(b - x) - Math.abs(a - x));
        
        for(int ele : arr){
            pq.add(ele);
            if(pq.size() > k) pq.poll();
        }
        
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        Collections.sort(ans);
        return ans;
    }
}