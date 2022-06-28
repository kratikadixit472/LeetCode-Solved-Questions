class Solution {
    public int minDeletions(String s) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int[] frq = new int[26];
        
        for(char ch : s.toCharArray()){
            frq[ch - 'a']++;
        }
        
        for(int freq : frq){
            if(freq > 0) pq.add(freq);
        }
        
        int ans = 0;
        
        while(pq.size() > 1){
            
            int topEle = pq.poll();
            
            if(topEle == pq.peek()){
                
                if(topEle - 1 > 0){
                    pq.add(topEle - 1);
                }
                ans++;
            }
        }
        return ans;
    }
}