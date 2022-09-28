class Solution {
    
    class Pair{
        String w;
        int frq;
        public Pair(String w, int frq){
            this.w = w;
            this.frq = frq;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        
        List<String> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.frq == b.frq) ? (b.w).compareTo(a.w) : a.frq - b.frq);
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for(String key : map.keySet()){
            pq.add(new Pair(key, map.get(key)));
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        // int[] ans = new int[k];
        // int idx = k;
        
        while(!pq.isEmpty()){
            ans.add(pq.poll().w);
        }
        Collections.reverse(ans);
        return ans;
    }
}