class Solution {
    class Pair{
        String s;
        int freq;
        public Pair(String s, int freq){
            this.s = s;
            this.freq = freq;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p1, p2) -> 
            (p1.freq == p2.freq) ? p1.s.compareTo(p2.s) : p2.freq - p1.freq
        );
        
        for(Map.Entry<String, Integer> e : map.entrySet()){
            Pair p = new Pair(e.getKey(), e.getValue());
            //if(pq.size() > k) pq.poll();
            pq.add(p);
        }
        
        List<String> ans = new ArrayList<>();
        while(k-- > 0 && !pq.isEmpty()){
            Pair p = pq.poll();
            ans.add(p.s);
        }
        //Collections.sort(ans);
        return ans;
    }
}