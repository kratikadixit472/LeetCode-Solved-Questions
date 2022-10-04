class Solution {
    public List<List<Integer>> kSmallestPairs(int[] num1, int[] num2, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]+a[1] - b[0]-b[1]);
        
        for(int i = 0; i < num1.length; i++) pq.add(new int[]{num1[i], num2[0], 0});
        
        while(k-- > 0 && !pq.isEmpty()){
            
            int[] curr = pq.poll();
            ans.add(Arrays.asList(curr[0], curr[1]));
            
            int currIdx = curr[2];
            if(currIdx+1 < num2.length) pq.add(new int[]{curr[0], num2[currIdx+1], currIdx+1});
        }
        return ans;
    }
}