class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        List<String> ans = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() != b.getValue() ? a.getValue() - b.getValue() : ((b.getKey()).compareTo(a.getKey())));
        
        for(Map.Entry<String, Integer> key : map.entrySet()){
            pq.add(key);
            if(pq.size() > k) pq.poll();
        }
        
        while(!pq.isEmpty()){
            Map.Entry<String, Integer> key = pq.poll();
            ans.add(0, key.getKey());
        }
        // Collections.sort(ans);
        return ans;
    }
}